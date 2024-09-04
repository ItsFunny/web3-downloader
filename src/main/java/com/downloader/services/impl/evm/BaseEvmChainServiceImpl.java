package com.downloader.services.impl.evm;

import com.downloader.services.IRuleEngine;
import com.downloader.services.IRuleFactory;
import com.downloader.services.abstranction.BaseChainServiceImpl;
import com.downloader.wrapper.BlockWrapper;


public abstract class BaseEvmChainServiceImpl extends BaseChainServiceImpl<Integer> {

    public BaseEvmChainServiceImpl(IRuleFactory factory) {
        super(factory);
    }

    @Override
    public Integer checkReorg(BlockWrapper<Integer> block) {
        return null;
    }

    @Override
    public void rollBack(Integer number) {
        IRuleEngine engine = this.factory.createRuleEngine();

    }
}
