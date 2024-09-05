package com.downloader.services.impl.eth.body;

import com.downloader.services.IRuleBody;
import com.downloader.services.impl.BaseOutputModel;
import lombok.Data;

@Data
public class BaseBlock extends BaseOutputModel implements IRuleBody {
    public Integer approvalCount;
    public Double avgGasPrice;
    public Double baseFeePreGas;
    public String baseFeePreGasRaw;
    public Double blockReward;
    public String blockRewardRaw;
    public Long blocktime;
    public Double burntFee;
    public String burntFeeRaw;
    public String difficulty;
    public String extraData;
    public String extraDataHex;
    public Double fee;
    public String feeRaw;
    public Integer gasLimit;
    public String gasLimitRaw;
    public Integer gasUsed;
    public String hash;
    public String hashRate;
    public Integer height;
    public Double highestTip;
    public Integer internalTranCount;
    public Double internalValueTotal;
    public String internalValueTotalRaw;
    public Integer logCount;
    public String logsBloom;
    public Long mineTime;
    public String minerHash;
    public String mixHash;
    public String nextBlockHash;
    public String nonce;
    public String previousBlockHash;
    public String receiptsRoot;
    public Double reward;
    public String rewardRaw;
    public String sha3Uncles;
    public Integer size;
    public String stateRoot;
    public Integer tokenTransferCount;
    public String totalDifficulty;
    public Double totalTip;
    public Integer transactionCount;
    public String transactionsRoot;
    public Double uncleReward;
    public String uncleRewardRaw;
    public Integer unclesCount;
    public Double valueTotal;
    public String valueTotalRaw;
}
