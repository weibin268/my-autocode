package com.zhuang.autocode.model;

import com.zhuang.data.orm.annotation.Id;
import com.zhuang.data.orm.annotation.Table;
import com.zhuang.data.orm.annotation.UnderscoreNaming;

import java.util.Date;

@UnderscoreNaming
@Table(name = "sys_autocode_detail")
public class AutoCodeDetail {
	@Id
	public String id;

	public String autocodeId;

	public String prefixCode;

	public Integer seq;

	public Date createTime;

	public Date modifyTime;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}
