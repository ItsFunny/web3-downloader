package com.downloader.services.impl.eth.body;

import com.downloader.services.IRuleBody;
import lombok.Data;

@Data
public class OriginalTx implements IRuleBody {
    public String blockHash;
    public String blockNumber;
    public String from;
    public String gas;
    public String gasPrice;
    public String maxFeePerGas;
    public String maxPriorityFeePerGas;
    public String hash;
    public String input;
    public String nonce;
    public String to;
    public String transactionIndex;
    public String value;
    public String type;
    public String chainId;
    public String v;
    public String r;
    public String s;
    public String sourceHash;
    public String mint;
}
