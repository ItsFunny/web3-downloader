package com.downloader.services;

// ? merge functions?
public interface IRuleService {
    void handleRule(IRuleBody rule, IOutput output);

    default void redispatchRule(IRuleBody rule, IOutput output) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
