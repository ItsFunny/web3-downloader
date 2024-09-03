package com.downloader.services.impl.eth;

import com.downloader.services.*;
import com.downloader.services.impl.eth.output.EthTransactionOutput;
import com.downloader.services.impl.evm.IEvmRuleService;

import java.util.ArrayList;
import java.util.List;

public class EthFactory implements IRuleFactory {

    private List<IEvmRuleService> evmRuleServices;

    public EthFactory(List<IEvmRuleService> evmRuleServices) {
        this.evmRuleServices = evmRuleServices;
    }

    @Override
    public IOutput defaultOutput() {
        return new EthTransactionOutput();
    }

    @Override
    public List<IRuleService> createRuleServices() {
        return new ArrayList<>(this.evmRuleServices);
    }
}
