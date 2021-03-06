package com.zhuang.autocode.parser;

import com.zhuang.autocode.model.AutoCode;
import com.zhuang.autocode.service.AutoCodeService;

public class ParserContext {

	private String expression;
	private String parameter;
	private String parsedText;
	private AutoCodeService service;

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
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
