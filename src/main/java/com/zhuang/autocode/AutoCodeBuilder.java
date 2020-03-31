package com.zhuang.autocode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zhuang.autocode.model.AutoCode;
import com.zhuang.autocode.parser.Parser;
import com.zhuang.autocode.parser.ParserContext;
import com.zhuang.autocode.parser.ParserRepository;
import com.zhuang.autocode.service.DefaultAutoCodeService;

import com.zhuang.autocode.service.AutoCodeService;
import com.zhuang.data.DbAccessor;

public class AutoCodeBuilder {
    private AutoCodeService service;

    public AutoCodeBuilder() {
        this(new DefaultAutoCodeService());
    }

    public AutoCodeBuilder(AutoCodeService service) {
        this.service = service;
    }

    public String build(String expression) {
        String result = "";
        result = expression;
        Pattern pattern = Pattern.compile("(?<=\\{)[^\\{\\}]+(?=\\})");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            String tag = matcher.group();
            String[] arTag = tag.split(":");
            String tagName = arTag[0];
            String tagParam = arTag.length > 1 ? tag.replaceAll(tagName + ":", "") : "";
            String parsedText = "";
            Parser parser = ParserRepository.getInstance().getParser(tagName);
            if (parser != null) {
                ParserContext parserContext = new ParserContext();
                parserContext.setExpression(expression);
                parserContext.setParameter(tagParam);
                parserContext.setParsedText(result);
                parserContext.setService(service);

                parsedText = parser.parse(parserContext);
            }
            result = result.replace("{" + tag + "}", parsedText);
        }
        return result;
    }
}
