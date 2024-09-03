package com.downloader.config;

import lombok.Data;

import java.util.List;

@Data
public class DownloaderConfig {
    private List<ChainConfig> chains;
}
