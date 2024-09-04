package com.downloader;


import com.downloader.services.*;
import com.downloader.services.abstranction.AbstractBaseRuleService;
import com.downloader.services.impl.DefaultFactory;
import com.downloader.services.impl.eth.EthChainServiceImpl;
import com.downloader.services.impl.eth.client.EthClient;
import com.downloader.services.impl.eth.models.EthBlockWrapper;
import com.downloader.wrapper.BlockWrapper;
import com.downloader.wrapper.OutputWrapper;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;

public class EthTest {
    @Test
    public void testEthDownloadBlock() {
        EthClient client = new EthClient("https://eth-sepolia.api.onfinality.io/public\t", 1);
        IRuleFactory factory = new DefaultFactory(Arrays.asList(new BlockParameterRule(client), new WrapperRule()),
                Arrays.asList((block) -> {
                    EthBlockWrapper ethBlockWrapper = (EthBlockWrapper) block;
                    return BlockParameter.builder().blockNumber(ethBlockWrapper.getBlock().getNumber().intValue()).chain("demo")
                            .build();
                }));
        EthChainServiceImpl service = new EthChainServiceImpl(factory);
        BlockWrapper<Integer> block = client.getBlock(100);
        OutputWrapper output = service.handleBlock(block);
        System.out.println(output);
    }

    @Data
    @Builder
    public static class BlockParameter implements IRuleBody {
        private String chain;
        private final int blockNumber;
    }

    @Data
    @Builder
    public static class TransactionRuleBody implements IRuleBody {

    }

    public static class BlockParameterRule extends AbstractBaseRuleService {
        private IClient<Integer> client;

        public BlockParameterRule(IClient<Integer> client) {
            this.client = client;
        }

        @Override
        public void handleRule(IRuleBody rule, IOutput output) {
            if (rule instanceof BlockParameter) {
                BlockParameter blockParameter = (BlockParameter) rule;
                System.out.println("Block number: " + blockParameter.getBlockNumber());
                BlockWrapper<Integer> block = this.client.getBlock(blockParameter.getBlockNumber());
                this.redispatchRule(block, output);
            }
        }
    }

    public static class WrapperRule extends AbstractBaseRuleService {
        @Override
        public void handleRule(IRuleBody rule, IOutput output) {
            if (rule instanceof BlockWrapper) {
                BlockWrapper<Integer> block = (BlockWrapper<Integer>) rule;
                System.out.println("Block number: " + block.getNumber());
            }
        }
    }


}
