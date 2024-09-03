package com.downloader.common;

import lombok.Data;

public enum ChainEnums {
    Evm("evm"),
    ;
    private String chainType;

    ChainEnums(String chainType) {
        this.chainType = chainType;
    }

    public String getChainType() {
        return chainType;
    }

    public static ChainEnums getChainType(String chainType) {
        for (ChainEnums chainEnums : ChainEnums.values()) {
            if (chainEnums.getChainType().equals(chainType)) {
                return chainEnums;
            }
        }
        return null;
    }
}
