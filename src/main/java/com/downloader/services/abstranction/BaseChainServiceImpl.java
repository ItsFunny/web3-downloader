package com.downloader.services.abstranction;

import com.downloader.services.*;
import com.downloader.wrapper.BlockWrapper;
import com.downloader.wrapper.OutputWrapper;

import java.util.List;

public abstract class BaseChainServiceImpl<N> implements IChainService<N> {
    protected IRuleFactory factory;

    public BaseChainServiceImpl(IRuleFactory factory) {
        this.factory = factory;
    }


    @Override
    public OutputWrapper handleBlock(BlockWrapper<N> block) {
        OutputWrapper ret = new OutputWrapper(this.factory.defaultOutput());
        IOutput output = ret.getOutput();
        IRuleEngine engine = this.factory.createRuleEngine();
        List<IRuleBody> ruleBodies = this.factory.createRuleBodies(block.getInternal());
        for (IRuleBody ruleBody : ruleBodies) {
            engine.dispatch(ruleBody, output);
        }
        return ret;
    }
}
