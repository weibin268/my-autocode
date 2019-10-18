package com.zhuang.autocode.service;

import com.zhuang.autocode.model.AutoCode;
import com.zhuang.autocode.model.AutoCodeDetail;
import com.zhuang.data.DbAccessor;

public class DefaultAutoCodeService implements AutoCodeService {

    private DbAccessor dbAccessor;

    public DefaultAutoCodeService() {
        this.dbAccessor = DbAccessor.get();
    }

    public DefaultAutoCodeService(DbAccessor dbAccessor) {
        this.dbAccessor = dbAccessor;
    }

    public void add(AutoCode autoCode) {
        dbAccessor.insert(autoCode);
    }

    public AutoCode get(String id) {
        return dbAccessor.select(id, AutoCode.class);
    }

    public AutoCodeDetail getDetailByPrefixCode(String autoCodeId, String prefixCode) {
        AutoCodeDetail params = new AutoCodeDetail();
        params.setAutocodeId(autoCodeId);
        params.setPrefixCode(prefixCode);
        return dbAccessor.selectOne(params, AutoCodeDetail.class);
    }

    public void addDetail(AutoCodeDetail detail) {
        dbAccessor.insert(detail);
    }

    public void saveDetail(AutoCodeDetail detail) {
        dbAccessor.update(detail);
    }

}
