package com.zhuang.autocode.service;

import com.zhuang.autocode.model.AutoCode;
import com.zhuang.data.DbAccessor;

public class DefaultAutoCodeService implements AutoCodeService {

    private DbAccessor dbAccessor;

    public DefaultAutoCodeService() {
        this.dbAccessor = DbAccessor.get();
    }

    public DefaultAutoCodeService(DbAccessor dbAccessor) {
        this.dbAccessor = dbAccessor;
    }

    @Override
    public void add(AutoCode autoCode) {
        dbAccessor.insert(autoCode);
    }

    @Override
    public void update(AutoCode model) {
        dbAccessor.update(model,true);
    }

    @Override
    public AutoCode getByExpressionAndCodePrefix(String expression, String codePrefix) {
        AutoCode params = new AutoCode();
        params.setExpression(expression);
        params.setCodePrefix(codePrefix);
        return dbAccessor.selectOne(params, AutoCode.class);
    }

}
