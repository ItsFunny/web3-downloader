package com.downloader.services.impl.eth.rules;

import com.downloader.common.GeneralFunction;
import com.downloader.services.IOutput;
import com.downloader.services.IRuleBody;
import com.downloader.services.abstranction.AbstractBaseRuleService;
import com.downloader.services.impl.eth.body.BaseBlock;
import com.downloader.services.impl.eth.body.OriginalBlock;

import java.util.Map;

public class BaseBlockConverterRule extends AbstractBaseRuleService {

    @Override
    public void handleRule(IRuleBody rule, IOutput output) {
        BaseBlock baseBlock = new BaseBlock();
        OriginalBlock originalBlock = (OriginalBlock) rule;
        GeneralFunction.convert(Map.of("originalBlock", originalBlock), this.getContext().getElMap().get("BaseBlock"), baseBlock);
        this.redispatchRule(baseBlock, output);
        output.output("baseBlock", baseBlock);
        output.setBlockHash(baseBlock.getHash());
        output.setBlockTime(baseBlock.getBlocktime());
    }

    @Override
    public boolean accept(IRuleBody body) {
        return body instanceof BaseBlock;
    }
}
