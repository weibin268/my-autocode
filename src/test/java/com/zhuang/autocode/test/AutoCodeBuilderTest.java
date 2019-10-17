package com.zhuang.autocode.test;

import org.junit.Test;

import com.zhuang.autocode.AutoCodeBuilder;

public class AutoCodeBuilderTest {

    @Test
    public void build() {

        AutoCodeBuilder builder = new AutoCodeBuilder("1");
        String code = builder.build();
        System.out.println(code);

    }
}
