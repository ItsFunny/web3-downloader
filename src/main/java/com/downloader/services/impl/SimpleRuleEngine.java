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

    // TODO
    @Override
    public void dispatch(IRuleBody rule, IOutput output) {
        for (IRuleService ruleService : ruleServices) {
            ruleService.setEngine(this);
            ruleService.handleRule(rule, output);
        }
    }

}
