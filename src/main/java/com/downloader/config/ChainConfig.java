package com.downloader.config;

import lombok.Data;

@Data
public class ChainConfig {
    private String rpcUrl;
    private Integer chainId;
    private String chainName;
    private String chainType;
}
