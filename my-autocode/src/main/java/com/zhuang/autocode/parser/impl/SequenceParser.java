package com.zhuang.autocode.parser.impl;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.UUID;

import com.zhuang.autocode.model.AutoCode;
import com.zhuang.autocode.parser.Parser;
import com.zhuang.autocode.parser.ParserContext;

public class SequenceParser implements Parser {

    public String getName() {
        return "seq";
    }

    public String parse(ParserContext context) {
        String result = "";
        result = getSeq(context);
        return result;
    }

    private String getSeq(ParserContext context) {
        String[] arParam = context.getParameter().split(",");
        int minLength = 0;
        boolean keepIncrease = false;
        Integer intSeq = 0;
        minLength = Integer.parseInt(arParam[0]);
        if (arParam.length >= 2) {
            if (arParam[1] != "0") {
                keepIncrease = true;
            }
        }
        String codePrefix = context.getParsedText().split("\\{")[0];
        if (keepIncrease) {
            codePrefix = "none";
        }
        AutoCode autoCode = context.getService().getByExpressionAndCodePrefix(context.getExpression(), codePrefix);
        Date dtNow = new Date();
        if (autoCode != null) {
            autoCode.setCodeSeq(autoCode.getCodeSeq() + 1);
            autoCode.setModifyTime(dtNow);
            context.getService().update(autoCode);
        } else {
            autoCode = new AutoCode();
            autoCode.setId(UUID.randomUUID().toString());
            autoCode.setExpression(context.getExpression());
            autoCode.setCodePrefix(codePrefix);
            autoCode.setCodeSeq(1);
            autoCode.setCreateTime(dtNow);
            autoCode.setModifyTime(dtNow);
            context.getService().add(autoCode);
        }
        int finalLength = (Math.max(autoCode.getCodeSeq().toString().length(), minLength));
        String dfPattern = "";
        for (int i = 0; i < finalLength; i++) {
            dfPattern = dfPattern + "0";
        }
        intSeq = autoCode.getCodeSeq();
        DecimalFormat df = new DecimalFormat(dfPattern);
        return df.format(intSeq);
    }

}
