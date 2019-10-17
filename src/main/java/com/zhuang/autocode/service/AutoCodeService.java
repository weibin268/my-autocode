package com.zhuang.autocode.service;

import com.zhuang.autocode.model.SysAutoCode;
import com.zhuang.autocode.model.SysAutoCodeDetail;

public interface AutoCodeService {
	
	void add(SysAutoCode model);
    
    SysAutoCode get(String id);
    
    SysAutoCodeDetail getDetailByPrefixCode(String autoCodeId , String prefixCode);

    void addDetail(SysAutoCodeDetail detail);

    void saveDetail(SysAutoCodeDetail detail);
}
