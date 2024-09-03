package com.downloader.services.impl;

import com.downloader.services.*;
import com.downloader.services.abstranction.AbstractBaseRuleService;

import java.util.ArrayList;
import java.util.List;

public class SimpleRuleEngine implements IRuleEngine {

    private List<IRuleService> ruleServices;

    public SimpleRuleEngine(List<IRuleService> ruleServices) {
        this.ruleServices = ruleServices;
    }

    @Override
    public void dispatch(IRuleBody rule, IOutput output) {
        for (IRuleService ruleService : ruleServices) {
            new RuleEngineWrapper(this, ruleService).handleRule(rule, output);
        }
    }

    public static class RuleEngineWrapper extends AbstractBaseRuleService {
        private IRuleService internal;

        public RuleEngineWrapper(IRuleEngine engine, IRuleService internal) {
            super(engine);
            this.internal = internal;
        }

        @Override
        public void handleRule(IRuleBody rule, IOutput output) {
            this.internal.handleRule(rule, output);
        }

    }
}
