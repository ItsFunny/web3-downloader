package com.downloader.services;

import java.util.Map;

public interface IOutput extends IIdentity {
    void output(String key, Object data);

    void setBlockHash(String hash);

    String getBlockHash();

    void setBlockTime(long ts);

    Integer getBlockHeight();

    Long getBlockTime();
}
