package com.downloader.services;

import java.util.List;

public interface IRuleFactory {
    IOutput defaultOutput();

    IRuleEngine createRuleEngine();

    List<IRuleBody> createRuleBodies(IBlock block);
}
