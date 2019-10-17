package com.zhuang.autocode.parser;

public interface Parser {

	String getName();

	String parse(ParserContext context);

}
