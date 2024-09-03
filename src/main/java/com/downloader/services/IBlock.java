package com.downloader.services;

import java.util.List;

public interface IBlock extends IIdentity {
    List<IRuleBody> getRules();
}
