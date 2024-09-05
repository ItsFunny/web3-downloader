package com.downloader.services.impl.eth.rules;

import com.downloader.common.GeneralFunction;
import com.downloader.services.IOutput;
import com.downloader.services.IRuleBody;
import com.downloader.services.abstranction.AbstractBaseRuleService;
import com.downloader.services.impl.eth.body.BaseTransaction;
import com.downloader.services.impl.eth.body.OriginalTx;

import java.util.Map;

public class BaseTransactionRule extends AbstractBaseRuleService {

    @Override
    public void handleRule(IRuleBody rule, IOutput output) {
        OriginalTx originalTx = (OriginalTx) rule;
        BaseTransaction tx = new BaseTransaction();
        GeneralFunction.convert(Map.of("originalTx", originalTx), this.getContext().getElMap().get("BaseTransaction"), tx);
        tx.setBlockHeight(output.getBlockHeight());
        tx.setBlocktime(output.getBlockTime());
        tx.setHour((int) ((output.getBlockTime() / 3600 + 8) % 24));
        tx.setBlockHash(output.getBlockHash());
        this.redispatchRule(tx, output);
    }

    @Override
    public boolean accept(IRuleBody body) {
        return body instanceof OriginalTx;
    }
}
