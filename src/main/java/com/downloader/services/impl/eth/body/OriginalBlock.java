package com.downloader.services.impl.eth.body;

import com.downloader.services.IRuleBody;
import lombok.Data;

import java.util.ArrayList;

@Data
public class OriginalBlock<N> implements IRuleBody {
    private N blockNumber;
    private String baseFeePerGas;
    private String difficulty;
    private String extraData;
    private String gasLimit;
    private String gasUsed;
    private String hash;
    private String logsBloom;
    private String miner;
    private String mixHash;
    private String nonce;
    private String number;
    private String parentHash;
    private String receiptsRoot;
    private String sha3Uncles;
    private String size;
    private String stateRoot;
    private String timestamp;
    private String totalDifficulty;
    private ArrayList<OriginalTx> transactions;
    private String transactionsRoot;
    private ArrayList<String> uncles;
    private Long blocktime;
}
