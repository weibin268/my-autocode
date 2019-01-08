package com.zhuang.autocode.model;

import com.zhuang.data.orm.annotation.Table;
import com.zhuang.data.orm.annotation.UnderscoreNaming;

import java.util.Date;

@UnderscoreNaming
@Table(name = "sys_autocode_detail")
public class SysAutoCodeDetail {

	public String id;

	public String autocodeId;

	public String prefixCode;

	public Integer seq;

	public Date createdTime;

	public Date modifiedTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAutocodeId() {
		return autocodeId;
	}

	public void setAutocodeId(String autocodeId) {
		this.autocodeId = autocodeId;
	}

	public String getPrefixCode() {
		return prefixCode;
	}

	public void setPrefixCode(String prefixCode) {
		this.prefixCode = prefixCode;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
}
