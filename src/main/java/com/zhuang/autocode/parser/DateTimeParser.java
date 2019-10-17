package com.zhuang.autocode.parser;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeParser implements Parser {

	public String getName() {
		return "dt";
	}

	public String parse(ParserContext context) {

		Date dNow = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat(context.getParameter());
		String strNow = sdf.format(dNow);

		return strNow;
	}

}
