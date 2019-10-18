package com.zhuang.autocode.service;

import com.zhuang.autocode.model.AutoCode;
import com.zhuang.autocode.model.AutoCodeDetail;

public interface AutoCodeService {
	
	void add(AutoCode model);
    
    AutoCode get(String id);
    
    AutoCodeDetail getDetailByPrefixCode(String autoCodeId , String prefixCode);

    void addDetail(AutoCodeDetail detail);

    void saveDetail(AutoCodeDetail detail);
}
