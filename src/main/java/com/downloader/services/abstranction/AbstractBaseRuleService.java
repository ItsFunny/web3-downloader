package com.downloader.services.abstranction;

import com.downloader.services.IOutput;
import com.downloader.services.IRuleBody;
import com.downloader.services.IRuleEngine;
import com.downloader.services.IRuleService;

public abstract class AbstractBaseRuleService implements IRuleService {

    private IRuleEngine engine;

    public AbstractBaseRuleService(IRuleEngine engine) {
        this.engine = engine;
    }

    public AbstractBaseRuleService() {
    }

    @Override
    public void redispatchRule(IRuleBody rule, IOutput output) {
        this.engine.dispatch(rule, output);
    }
}
