package com.downloader.services.abstranction;

import lombok.Data;

import java.util.Map;

@Data
public class RuleContext {

    private Map<String, Map<String, String>> elMap;
}
