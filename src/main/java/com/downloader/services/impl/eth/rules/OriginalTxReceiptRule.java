package com.downloader.services.impl.eth.rules;

import com.downloader.services.IOutput;
import com.downloader.services.IRuleBody;
import com.downloader.services.abstranction.AbstractBaseRuleService;
import com.downloader.services.impl.eth.body.BaseTransaction;


public class OriginalTxReceiptRule extends AbstractBaseRuleService {

    @Override
    public void handleRule(IRuleBody body, IOutput output) {
        BaseTransaction baseTransaction= (BaseTransaction) body;
        String txHash = baseTransaction.getHash();

    }

    @Override
    public boolean accept(IRuleBody body) {
        return body instanceof BaseTransaction;
    }
}
