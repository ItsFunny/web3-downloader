package com.downloader.services.impl.eth.rules;

import com.downloader.services.IClient;
import com.downloader.services.IOutput;
import com.downloader.services.IRuleBody;
import com.downloader.services.IRuleService;
import com.downloader.services.abstranction.AbstractBaseRuleService;
import com.downloader.services.impl.eth.body.OriginalBlock;
import com.downloader.wrapper.BlockWrapper;

public class OriginalBlockRule<N> extends AbstractBaseRuleService {
    private IClient<N> client;

    @Override
    public void handleRule(IRuleBody rule, IOutput output) {
        OriginalBlock<N> block = (OriginalBlock<N>) rule;
        BlockWrapper<N> blockWrapper = this.client.getBlock(block.getBlockNumber());
        this.redispatchRule(blockWrapper, output);
    }

    @Override
    public boolean accept(IRuleBody body) {
        return body instanceof OriginalBlock;
    }
}
