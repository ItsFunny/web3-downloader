package com.downloader.services;

import com.downloader.wrapper.OutputWrapper;

public interface IDownStream {
    void handleOutput(OutputWrapper wrapper);
}
