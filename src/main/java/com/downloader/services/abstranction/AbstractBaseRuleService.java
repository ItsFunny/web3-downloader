package com.downloader.services.abstranction;

import com.downloader.services.IRuleEngine;
import com.downloader.services.IRuleService;

public abstract class AbstractBaseRuleService implements IRuleService {

    private IRuleEngine engine;

    private RuleContext context;

    public AbstractBaseRuleService(IRuleEngine engine) {
        this.engine = engine;
    }

    public AbstractBaseRuleService() {
    }

    @Override
    public IRuleEngine getEngine() {
        return this.engine;
    }

    @Override
    public void setEngine(IRuleEngine engine) {
        this.engine = engine;
    }

    public RuleContext getContext() {
        return context;
    }

    public void setContext(RuleContext context) {
        this.context = context;
    }
}
