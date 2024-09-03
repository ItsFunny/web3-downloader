package com.downloader.services.impl.evm;

import com.downloader.services.abstranction.BaseChainServiceImpl;
import com.downloader.wrapper.BlockWrapper;


public abstract class BaseEvmChainServiceImpl extends BaseChainServiceImpl<Integer> {

    @Override
    public Integer checkReorg(BlockWrapper<Integer> block) {
        return null;
    }

    @Override
    public void rollBack(Integer number) {

    }
}
