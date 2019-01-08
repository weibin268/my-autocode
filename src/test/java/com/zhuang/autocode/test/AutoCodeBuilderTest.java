package com.zhuang.autocode.test;

import org.junit.Test;

import com.zhuang.autocode.AutoCodeBuilder;


public class AutoCodeBuilderTest {
	

	@Test
	public void testBuild() {
		
		AutoCodeBuilder builder=new AutoCodeBuilder("1");
		String code = builder.Build();
		System.out.println(code);
		
	}
}
