package com.downloader.services;

import com.downloader.models.DownloaderState;
import com.downloader.wrapper.BlockWrapper;

public interface DownloaderService<N> {
    DownloaderState getCurrentState(int chainId);

    void downloadBlock(BlockWrapper<N> block);
}
