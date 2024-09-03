package com.downloader.services;

import com.downloader.wrapper.BlockWrapper;
import com.downloader.wrapper.OutputWrapper;

public interface IChainService<N> {
    OutputWrapper handleBlock(BlockWrapper<N> block);

    N checkReorg(BlockWrapper<N> block);

    void rollBack(N number);
}
