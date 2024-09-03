package com.downloader.services.abstranction;

import com.downloader.services.*;
import com.downloader.wrapper.BlockWrapper;
import com.downloader.wrapper.OutputWrapper;

import java.util.List;

public abstract class BaseChainServiceImpl<N> implements IChainService<N> {
    protected IRuleFactory factory;


    @Override
    public OutputWrapper handleBlock(BlockWrapper<N> block) {
        OutputWrapper ret = new OutputWrapper(this.factory.defaultOutput());
        IOutput output = ret.getOutput();
        List<IRuleService> ruleServices = this.factory.createRuleServices();
        for (IRuleService ruleService : ruleServices) {
            List<IRuleBody> rules = block.getInternal().getRules();
            for (IRuleBody rule : rules) {
                ruleService.handleRule(rule, output);
            }
        }
        return ret;
    }
}
