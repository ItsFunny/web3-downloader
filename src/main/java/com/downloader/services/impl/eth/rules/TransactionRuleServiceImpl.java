package com.downloader.services.impl.eth.rules;


import com.downloader.services.IOutput;
import com.downloader.services.IRuleBody;
import com.downloader.services.impl.eth.body.EthTransactionRuleBody;
import com.downloader.services.impl.evm.IEvmRuleService;
import org.web3j.protocol.core.methods.response.Transaction;

public class TransactionRuleServiceImpl implements IEvmRuleService {

    @Override
    public void handleRule(IRuleBody rule, IOutput output) {
        if (!(rule instanceof EthTransactionRuleBody)) {
            return;
        }
        EthTransactionRuleBody body = (EthTransactionRuleBody) rule;
        Transaction ethTransaction = body.getTransaction();
        String fromAddress = ethTransaction.getFrom();
        String toAddress = ethTransaction.getTo();
    }
}
