package com.zhuang.autocode.test;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;

import com.zhuang.autocode.model.SysAutoCode;
import com.zhuang.autocode.model.SysAutoCodeDetail;
import com.zhuang.autocode.service.DefaultAutoCodeService;

public class DefaultAutoCodeServiceTest {

	private String guid = "00f634f2-8156-4f37-914e-8eb30ccf4b2d";

	@Test
	public void add() {
		
		DefaultAutoCodeService service = new DefaultAutoCodeService();
		SysAutoCode sysAutoCode=new SysAutoCode();
		sysAutoCode.setId("1");
		sysAutoCode.setExpression("SQ{dt:yyyyMMdd}{seq:3}");
		sysAutoCode.setDescription("1");
		
		service.add(sysAutoCode);
	}

	@Test
	public void addDetail() {
		DefaultAutoCodeService service = new DefaultAutoCodeService();

		SysAutoCodeDetail sysAutoCodeDetail = new SysAutoCodeDetail();
		sysAutoCodeDetail.setId(UUID.randomUUID().toString());
		sysAutoCodeDetail.setSeq(1);
		sysAutoCodeDetail.setPrefixCode("zwb");
		sysAutoCodeDetail.setAutocodeId("1");
		sysAutoCodeDetail.setCreatedTime(new Date());
		sysAutoCodeDetail.setModifiedTime(new Date());

		service.addDetail(sysAutoCodeDetail);
	}

	@Test
	public void saveDetail() {
		DefaultAutoCodeService service = new DefaultAutoCodeService();

		SysAutoCodeDetail sysAutoCodeDetail = new SysAutoCodeDetail();
		sysAutoCodeDetail.setId(guid);
		sysAutoCodeDetail.setSeq(1);
		sysAutoCodeDetail.setPrefixCode("zzzzzzzzzzzz");
		sysAutoCodeDetail.setAutocodeId("1111111111111");
		sysAutoCodeDetail.setCreatedTime(new Date());
		sysAutoCodeDetail.setModifiedTime(new Date());

		service.saveDetail(sysAutoCodeDetail);
	}

	@Test
	public void getDetailByPrefixCode() {

		DefaultAutoCodeService service = new DefaultAutoCodeService();

		SysAutoCodeDetail sysAutoCodeDetail = service.getDetailByPrefixCode("1111111111111", "zzzzzzzzzzzz");

		System.out.println(sysAutoCodeDetail.getId());

	}
}
