package com.zhuang.autocode.service;

import com.zhuang.autocode.model.AutoCode;

public interface AutoCodeService {
	
	void add(AutoCode model);

	void update(AutoCode model);

    AutoCode get(String id);
    
    AutoCode getByExpressionAndCodePrefix(String expression, String codePrefix);

}
