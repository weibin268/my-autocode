package com.zhuang.autocode.test;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;

import com.zhuang.autocode.model.AutoCode;
import com.zhuang.autocode.model.AutoCodeDetail;
import com.zhuang.autocode.service.DefaultAutoCodeService;

public class DefaultAutoCodeServiceTest {

	private String guid = "00f634f2-8156-4f37-914e-8eb30ccf4b2d";

	@Test
	public void add() {
		
		DefaultAutoCodeService service = new DefaultAutoCodeService();
		AutoCode autoCode =new AutoCode();
		autoCode.setId("1");
		autoCode.setExpression("SQ{dt:yyyyMMdd}{seq:3}");
		autoCode.setDescription("1");
		
		service.add(autoCode);
	}

	@Test
	public void addDetail() {
		DefaultAutoCodeService service = new DefaultAutoCodeService();

		AutoCodeDetail autoCodeDetail = new AutoCodeDetail();
		autoCodeDetail.setId(UUID.randomUUID().toString());
		autoCodeDetail.setSeq(1);
		autoCodeDetail.setPrefixCode("zwb");
		autoCodeDetail.setAutocodeId("1");
		autoCodeDetail.setCreateTime(new Date());
		autoCodeDetail.setModifyTime(new Date());

		service.addDetail(autoCodeDetail);
	}

	@Test
	public void saveDetail() {
		DefaultAutoCodeService service = new DefaultAutoCodeService();

		AutoCodeDetail autoCodeDetail = new AutoCodeDetail();
		autoCodeDetail.setId(guid);
		autoCodeDetail.setSeq(1);
		autoCodeDetail.setPrefixCode("zzzzzzzzzzzz");
		autoCodeDetail.setAutocodeId("1111111111111");
		autoCodeDetail.setCreateTime(new Date());
		autoCodeDetail.setModifyTime(new Date());

		service.saveDetail(autoCodeDetail);
	}

	@Test
	public void getDetailByPrefixCode() {

		DefaultAutoCodeService service = new DefaultAutoCodeService();

		AutoCodeDetail autoCodeDetail = service.getDetailByPrefixCode("1111111111111", "zzzzzzzzzzzz");

		System.out.println(autoCodeDetail.getId());

	}
}
