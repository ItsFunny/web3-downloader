package com.downloader.services.impl.eth.client;

import com.downloader.services.IClient;
import com.downloader.services.impl.eth.models.EthBlockWrapper;
import com.downloader.wrapper.BlockWrapper;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;

public class EthClient implements IClient<Integer> {
    private Web3j web3j;
    private int chainId;

    public EthClient(String rpcUrl, int chainId) {
        Web3j web3j = Web3j.build(new HttpService(rpcUrl));
        this.chainId = chainId;
        this.web3j = web3j;
    }

    @Override
    public BlockWrapper<Integer> getBlock(Integer number) {
        DefaultBlockParameter parameter = DefaultBlockParameter.valueOf(BigInteger.valueOf(number.longValue()));
        try {
            EthBlock block = this.web3j.ethGetBlockByNumber(parameter, false).send();
            EthBlock.Block ethBlock = block.getBlock();
            BlockWrapper<Integer> wrapper = BlockWrapper.<Integer>builder().number(ethBlock.getNumber().intValue()).internal(new EthBlockWrapper(ethBlock)).build();
            return wrapper;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer latestBlockNumber() {
        try {
            return this.web3j.ethBlockNumber().send().getBlockNumber().intValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int chainId() {
        return this.chainId;
    }
}
