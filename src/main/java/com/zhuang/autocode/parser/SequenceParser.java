package com.zhuang.autocode.parser;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.UUID;

import com.zhuang.autocode.model.SysAutoCodeDetail;

public class SequenceParser implements Parser {

	public String getName() {
		return "seq";
	}

	public String Parse(ParserContext context) {

		String result = "";

		result = GetSeq(context);

		return result;
	}

	private String GetSeq(ParserContext context) {
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

		String prefixCode = context.getParsedText().split("\\{")[0];

		if (keepIncrease) {
			prefixCode = "none";
		}

		SysAutoCodeDetail detailModel = context.getService()
				.GetDetailByPrefixCode(context.getSysAutoCode().getId(), prefixCode);

		Date dtNow = new Date();

		if (detailModel != null) {
			detailModel.setSeq(detailModel.getSeq() + 1);
			detailModel.setModifiedTime(dtNow);

			context.getService().SaveDetail(detailModel);
		} else {
			detailModel = new SysAutoCodeDetail();
			detailModel.setId(UUID.randomUUID().toString());
			detailModel.setAutocodeId(context.getSysAutoCode().getId());
			detailModel.setPrefixCode(prefixCode);
			detailModel.setSeq(1);
			detailModel.setCreatedTime(dtNow);
			detailModel.setModifiedTime(dtNow);

			context.getService().AddDetail(detailModel);
		}

		int finalLength = (detailModel.getSeq().toString().length() > minLength
				? detailModel.getSeq().toString().length() : minLength);

		String dfPattern = "";

		for (int i = 0; i < finalLength; i++) {
			dfPattern = dfPattern + "0";
		}

		intSeq = detailModel.getSeq();

		DecimalFormat df = new DecimalFormat(dfPattern);

		return df.format(intSeq);
	}

}
