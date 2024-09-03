package com.downloader.services;

import java.util.List;

public interface IRuleFactory {
    IOutput defaultOutput();

    List<IRuleService> createRuleServices();

}
