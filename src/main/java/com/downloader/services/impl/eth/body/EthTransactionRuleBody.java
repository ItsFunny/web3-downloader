package com.downloader.services.impl.eth.body;

import com.downloader.services.impl.evm.IEvmRuleBody;
import lombok.Data;
import org.web3j.protocol.core.methods.response.Transaction;

@Data
public class EthTransactionRuleBody implements IEvmRuleBody {
    protected Transaction transaction;
}
