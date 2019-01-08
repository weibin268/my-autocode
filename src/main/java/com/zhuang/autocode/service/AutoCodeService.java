package com.zhuang.autocode.service;

import com.zhuang.autocode.model.SysAutoCode;
import com.zhuang.autocode.model.SysAutoCodeDetail;

public interface AutoCodeService {
	
	void Add(SysAutoCode model);
    
    SysAutoCode Get(String id);
    
    SysAutoCodeDetail GetDetailByPrefixCode(String autoCodeId ,String prefixCode);

    void AddDetail(SysAutoCodeDetail detail);

    void SaveDetail(SysAutoCodeDetail detail);
}
