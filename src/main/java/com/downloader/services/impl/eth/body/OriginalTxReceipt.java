package com.downloader.services.impl.eth.body;

import com.downloader.services.IRuleBody;
import lombok.Data;

import java.util.ArrayList;

public class OriginalTxReceipt implements IRuleBody {
    public String blockHash;
    public String blockNumber;
    public String contractAddress;
    public String cumulativeGasUsed;
    public String effectiveGasPrice;
    public String from;
    public String gasUsed;
    public String l1Fee;
    public String l1FeeScalar;
    public String l1GasPrice;
    public String l1GasUsed;
    public ArrayList<OriginalLog> logs;
    public String logsBloom;
    public String status;
    public String to;
    public String transactionHash;
    public String transactionIndex;
    public String type;
}
