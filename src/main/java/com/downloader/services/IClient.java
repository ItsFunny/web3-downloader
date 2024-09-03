package com.downloader.services;


import com.downloader.wrapper.BlockWrapper;

public interface IClient<N> {
    BlockWrapper getBlock(N number);

    N latestBlockNumber();

    int chainId();
}
