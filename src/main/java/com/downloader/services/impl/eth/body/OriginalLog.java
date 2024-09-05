package com.downloader.services.impl.eth.body;

import lombok.Data;

import java.util.ArrayList;

@Data
public class OriginalLog {
    public String address;
    public ArrayList<String> topics;
    public String data;
    public String blockNumber;
    public String transactionHash;
    public String transactionIndex;
    public String blockHash;
    public String logIndex;
    public Boolean removed;
    public String txhash;
    public String txindex;
}
