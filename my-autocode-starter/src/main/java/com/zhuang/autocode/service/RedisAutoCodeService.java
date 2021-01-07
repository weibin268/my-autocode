package com.zhuang.autocode.service;

import com.alibaba.fastjson.JSON;
import com.zhuang.autocode.model.AutoCode;
import com.zhuang.autocode.util.RedisUtils;

public class RedisAutoCodeService implements AutoCodeService {

    @Override
    public void add(AutoCode model) {
        RedisUtils.set(getKey(model), JSON.toJSONString(model));
    }

    @Override
    public void update(AutoCode model) {
        RedisUtils.set(getKey(model), JSON.toJSONString(model));
    }

    @Override
    public AutoCode getByExpressionAndCodePrefix(String expression, String codePrefix) {
        String strAutoCode = RedisUtils.get(getKey(expression, codePrefix));
        return JSON.parseObject(strAutoCode, AutoCode.class);
    }

    private String getKey(AutoCode autoCode) {
        return getKey(autoCode.getExpression(), autoCode.getCodePrefix());
    }

    private String getKey(String expression, String codePrefix) {
        return "AutoCode_" + expression + "_" + codePrefix;
    }

}
