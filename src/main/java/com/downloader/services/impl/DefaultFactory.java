package com.downloader.services.impl;

import com.downloader.services.*;
import com.downloader.services.impl.eth.output.EthTransactionOutput;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class DefaultFactory implements IRuleFactory {

    private List<IRuleService> ruleServices;
    private List<IRuleBodyCreator> creators;

    public DefaultFactory(List<IRuleService> evmRuleServices, List<IRuleBodyCreator> creators) {
        this.ruleServices = evmRuleServices;
        this.creators = creators;
    }

    @Override
    public IOutput defaultOutput() {
        return new EthTransactionOutput();
    }

    @Override
    public IRuleEngine createRuleEngine() {
        return new SimpleRuleEngine(this.ruleServices);
    }

    @Override
    public List<IRuleBody> createRuleBodies(IBlock block) {
        return this.creators.stream().map(creator -> creator.create(block)).collect(Collectors.toList());
    }
}
