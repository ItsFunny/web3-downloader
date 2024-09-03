package com.downloader.services;

public interface IRuleEngine {
    void dispatch(IRuleBody rule, IOutput output);
}
