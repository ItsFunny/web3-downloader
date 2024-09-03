package com.downloader.services.impl;

import com.downloader.models.DownloaderState;
import com.downloader.services.DownloaderService;
import com.downloader.services.IChainService;
import com.downloader.services.IDownStream;
import com.downloader.wrapper.BlockWrapper;
import com.downloader.wrapper.OutputWrapper;

public class DefaultDownloaderServiceImpl<N> implements DownloaderService<N> {
    private IChainService<N> chainService;

    private IDownStream downStream;

    public DefaultDownloaderServiceImpl(IChainService<N> chainService, IDownStream downStream) {
        this.chainService = chainService;
        this.downStream = downStream;
    }

    @Override
    public DownloaderState getCurrentState(int chainId) {
        return null;
    }

    @Override
    public void downloadBlock(BlockWrapper<N> block) {
        // reorg
        N reorgNumber = this.chainService.checkReorg(block);
        if (reorgNumber != null) {
            this.chainService.rollBack(reorgNumber);
            return;
        }
        OutputWrapper blockWrapper = chainService.handleBlock(block);
        this.downStream.handleOutput(blockWrapper);
    }
}
