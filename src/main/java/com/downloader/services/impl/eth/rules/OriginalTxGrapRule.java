package com.downloader.services.impl.eth.rules;

import cn.hutool.json.JSONUtil;
import com.downloader.services.IOutput;
import com.downloader.services.IRuleBody;
import com.downloader.services.IRuleService;
import com.downloader.services.abstranction.AbstractBaseRuleService;
import com.downloader.services.impl.eth.body.OriginalBlock;
import com.downloader.services.impl.eth.body.OriginalTx;

import java.util.ArrayList;

public class OriginalTxGrapRule extends AbstractBaseRuleService {

    @Override
    public void handleRule(IRuleBody rule, IOutput output) {
        OriginalBlock block = (OriginalBlock) rule;
        ArrayList transactions = block.getTransactions();
        transactions.forEach((e) -> {
            OriginalTx originalTx = JSONUtil.toBean(JSONUtil.parseObj(e), OriginalTx.class);
            this.redispatchRule(originalTx,output);
        });
    }

    @Override
    public boolean accept(IRuleBody body) {
        return body instanceof OriginalBlock;
    }
}
