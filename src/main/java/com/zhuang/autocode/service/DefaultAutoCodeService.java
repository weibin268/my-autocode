package com.zhuang.autocode.service;

import com.zhuang.autocode.model.SysAutoCode;
import com.zhuang.autocode.model.SysAutoCodeDetail;
import com.zhuang.data.DbAccessor;

public class DefaultAutoCodeService implements AutoCodeService {

	DbAccessor dbAccessor = DbAccessor.get();

	public void Add(SysAutoCode model) {

		dbAccessor.executeNonQuery("com.zhuang.autocode.mapper.SysAutoCode.addSysAutoCode", model);
		
	}

	public SysAutoCode Get(String id) {

		return dbAccessor.queryEntity("com.zhuang.autocode.mapper.SysAutoCode.selectSysAutoCodeById", id,SysAutoCode.class);

	}

	public SysAutoCodeDetail GetDetailByPrefixCode(String autoCodeId, String prefixCode) {
		SysAutoCodeDetail entity;

		SysAutoCodeDetail param = new SysAutoCodeDetail();
		param.setAutocodeId(autoCodeId);
		param.setPrefixCode(prefixCode);
		entity = dbAccessor
				.queryEntity("com.zhuang.autocode.mapper.SysAutoCodeDetail.selectSysAutoCodeDetailByPrefixCode", param,SysAutoCodeDetail.class);

		return entity;
	}

	public void AddDetail(SysAutoCodeDetail detail) {

		dbAccessor.executeNonQuery("com.zhuang.autocode.mapper.SysAutoCodeDetail.insertSysAutoCodeDetail", detail);

	}

	public void SaveDetail(SysAutoCodeDetail detail) {

		dbAccessor.executeNonQuery("com.zhuang.autocode.mapper.SysAutoCodeDetail.updateSysAutoCodeDetail", detail);
	
	}

}
