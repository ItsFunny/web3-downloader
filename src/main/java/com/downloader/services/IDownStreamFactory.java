package com.downloader.services;

public interface IDownStreamFactory extends IRuleFactory {
    IDownStream createDownStream();
}
