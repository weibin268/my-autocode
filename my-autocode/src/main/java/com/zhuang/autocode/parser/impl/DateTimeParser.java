package com.zhuang.autocode.parser.impl;

import com.zhuang.autocode.parser.Parser;
import com.zhuang.autocode.parser.ParserContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeParser implements Parser {

    public String getName() {
        return "dt";
    }

    public String parse(ParserContext context) {
        Date dNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(context.getParameter());
        return sdf.format(dNow);
    }

}
