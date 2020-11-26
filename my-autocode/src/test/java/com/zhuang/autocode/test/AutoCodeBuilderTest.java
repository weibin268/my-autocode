package com.zhuang.autocode.test;

import org.junit.Test;

import com.zhuang.autocode.AutoCodeBuilder;

public class AutoCodeBuilderTest {

    @Test
    public void build() {

        AutoCodeBuilder builder = new AutoCodeBuilder();
        String code = builder.build("SQ{dt:yyyyMMdd}{seq:3}");
        System.out.println(code);

    }
}
