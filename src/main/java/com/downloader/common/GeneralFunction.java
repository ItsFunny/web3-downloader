package com.downloader.common;

import cn.hutool.core.util.StrUtil;
import org.mvel2.MVEL;
import org.mvel2.PropertyAccessException;

import java.util.Map;

public class GeneralFunction {
    public static <L, R> R convert(Map<String, L> context, Map<String, String> elMap, R output) {
        for (Map.Entry<String, String> entry : elMap.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            try {
                output.getClass().getField(k);
                Object result = MVEL.eval(v, context, output.getClass().getField(StrUtil.lowerFirst(k)).getType());
                output.getClass().getField(StrUtil.lowerFirst(k)).set(output, result);
            } catch (PropertyAccessException pae) {
                //上层有重试机制
                throw new RuntimeException("Cant find property from el context, field is " + k + ", value is " + v, pae);
            } catch (Exception e) {
                throw new RuntimeException("GeneralFunction convert error, field is " + k + ", value is " + v, e);
            }
        }
        return output;
    }
}