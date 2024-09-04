package com.downloader.services;

public interface IRuleService {
    void handleRule(IRuleBody rule, IOutput output);

    IRuleEngine getEngine();

    void setEngine(IRuleEngine engine);

    default void redispatchRule(IRuleBody rule, IOutput output) {
        this.getEngine().dispatch(rule, output);
    }
}
