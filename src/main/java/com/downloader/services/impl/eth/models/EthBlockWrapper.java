package com.downloader.services.impl.eth.models;

import com.downloader.services.IBlock;
import com.downloader.services.IRuleBody;
import lombok.Data;
import org.web3j.protocol.core.methods.response.EthBlock;


@Data
public class EthBlockWrapper implements IBlock {
    private EthBlock.Block block;

    public EthBlockWrapper(EthBlock.Block block) {
        this.block = block;
    }
}
