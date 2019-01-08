package com.zhuang.autocode.parser;

import com.zhuang.autocode.model.SysAutoCode;
import com.zhuang.autocode.service.AutoCodeService;

public class ParserContext {

	private SysAutoCode sysAutoCode;

	private String parameter;

	private String parsedText;

	private AutoCodeService service;

	public SysAutoCode getSysAutoCode() {
		return sysAutoCode;
	}

	public void setSysAutoCode(SysAutoCode sysAutoCode) {
		this.sysAutoCode = sysAutoCode;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getParsedText() {
		return parsedText;
	}

	public void setParsedText(String parsedText) {
		this.parsedText = parsedText;
	}

	public AutoCodeService getService() {
		return service;
	}

	public void setService(AutoCodeService service) {
		this.service = service;
	}
}
