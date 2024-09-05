package com.downloader.services.impl.eth.rules;

import cn.hutool.core.util.StrUtil;
import com.downloader.services.IOutput;
import com.downloader.services.IRuleBody;
import com.downloader.services.abstranction.AbstractBaseRuleService;
import com.downloader.services.impl.eth.body.BaseTransaction;

public class CompleteTranslationMethodIDRule extends AbstractBaseRuleService {

    @Override
    public void handleRule(IRuleBody body, IOutput output) {
        BaseTransaction baseTransaction = (BaseTransaction) body;
        ((BaseTransaction) body).setMethodId(((BaseTransaction) body).getInputHex().substring(0,
                baseTransaction.getInputHex().startsWith("0x") || baseTransaction.getInputHex().startsWith("0X") ? 10 : 8));
    }

    @Override
    public boolean accept(IRuleBody body) {
        if (body instanceof BaseTransaction) {
            BaseTransaction baseTransaction = (BaseTransaction) body;
            if (StrUtil.isNotBlank(baseTransaction.getInputHex()) && baseTransaction.getInputHex().length() >= 10) {
                return true;
            }
        }
        return false;
    }
}
