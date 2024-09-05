package com.downloader.services;

public interface IRuleService {
    void handleRule(IRuleBody body, IOutput output);

    boolean accept(IRuleBody body);

    IRuleEngine getEngine();

    void setEngine(IRuleEngine engine);

    default void redispatchRule(IRuleBody rule, IOutput output) {
        this.getEngine().dispatch(rule, output);
    }
}
