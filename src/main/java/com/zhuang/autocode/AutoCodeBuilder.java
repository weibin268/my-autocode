package com.zhuang.autocode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zhuang.autocode.model.SysAutoCode;
import com.zhuang.autocode.parser.Parser;
import com.zhuang.autocode.parser.ParserContext;
import com.zhuang.autocode.parser.ParserRepository;
import com.zhuang.autocode.service.DefaultAutoCodeService;

import com.zhuang.autocode.service.AutoCodeService;

public class AutoCodeBuilder {

	private SysAutoCode sysAutoCode;
	AutoCodeService service;

	public AutoCodeBuilder(String autoCodeId) {
		this(autoCodeId, new DefaultAutoCodeService());
	}

	public AutoCodeBuilder(String autoCodeId, AutoCodeService service) {
		this.service = service;
		this.sysAutoCode = service.Get(autoCodeId);
	}

	public String Build() {
		String result = "";

		result=sysAutoCode.getExpression();

		Pattern pattern=Pattern.compile("(?<=\\{)[^\\{\\}]+(?=\\})");

		Matcher matcher=pattern.matcher(sysAutoCode.getExpression());
		
		while (matcher.find()) {
			
			String tag = matcher.group();
			String[] arTag = tag.split(":");
			String tagName = arTag[0];
			String tagParam = arTag.length > 1 ? tag.replaceAll(tagName + ":", "") : "";

			String parsedText = "";

            Parser parser = ParserRepository.getInstance().GetParser(tagName);
            if (parser != null)
            {
              	ParserContext parserContext = new ParserContext();
              	parserContext.setSysAutoCode(sysAutoCode);
              	parserContext.setParameter(tagParam);
              	parserContext.setParsedText(result);
              	parserContext.setService(service);
              	
                parsedText = parser.Parse(parserContext);
            }

            result = result.replace("{" + tag + "}", parsedText);
        
		}
		
		return result;
	}
}
