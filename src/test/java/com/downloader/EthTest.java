package com.downloader;


import com.downloader.services.*;
import com.downloader.services.abstranction.AbstractBaseRuleService;
import com.downloader.services.impl.DefaultFactory;
import com.downloader.services.impl.eth.EthChainServiceImpl;
import com.downloader.services.impl.eth.client.EthClient;
import com.downloader.wrapper.BlockWrapper;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

public class EthTest {
    @Test
    public void testEthDownloadBlock() {
        EthClient client = new EthClient("", 1);
        BlockWrapper<Integer> block = client.getBlock(100);
        IRuleFactory factory = new DefaultFactory();
        EthChainServiceImpl service = new EthChainServiceImpl(factory);
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

        @Override
        public void handleRule(IRuleBody rule, IOutput output) {

        }
    }


}
