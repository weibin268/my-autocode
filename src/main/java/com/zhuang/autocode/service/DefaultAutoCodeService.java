package com.zhuang.autocode.service;

import com.zhuang.autocode.model.SysAutoCode;
import com.zhuang.autocode.model.SysAutoCodeDetail;
import com.zhuang.data.DbAccessor;

public class DefaultAutoCodeService implements AutoCodeService {

    private DbAccessor dbAccessor = DbAccessor.get();
    public void add(SysAutoCode sysAutoCode) {
        dbAccessor.insert(sysAutoCode);
    }

    public SysAutoCode get(String id) {
        return dbAccessor.select(id, SysAutoCode.class);
    }

    public SysAutoCodeDetail getDetailByPrefixCode(String autoCodeId, String prefixCode) {
        SysAutoCodeDetail params = new SysAutoCodeDetail();
        params.setAutocodeId(autoCodeId);
        params.setPrefixCode(prefixCode);
        return dbAccessor.selectOne(params, SysAutoCodeDetail.class);
    }

    public void addDetail(SysAutoCodeDetail detail) {
        dbAccessor.insert(detail);
    }

    public void saveDetail(SysAutoCodeDetail detail) {
        dbAccessor.update(detail);
    }

}
