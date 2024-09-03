package com.downloader.dto;

import lombok.Data;

@Data
public class LiteBlockDTO {
    private String currentHash;
    private String previousHash;
    private int blockNumber;
}
