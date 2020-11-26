package com.zhuang.autocode.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuang.autocode.mapper.AutoCodeMapper;
import com.zhuang.autocode.model.AutoCode;

public class MyBatisPlusAutoCodeService extends ServiceImpl<AutoCodeMapper, AutoCode> implements AutoCodeService {

    @Override
    public void add(AutoCode model) {
        save(model);
    }

    @Override
    public void update(AutoCode model) {
        updateById(model);
    }

    @Override
    public AutoCode get(String id) {
        return getById(id);
    }

    @Override
    public AutoCode getByExpressionAndCodePrefix(String expression, String codePrefix) {
        return getOne(new LambdaQueryWrapper<AutoCode>()
                .eq(AutoCode::getExpression, expression)
                .eq(AutoCode::getCodePrefix, codePrefix)
        );
    }

}
