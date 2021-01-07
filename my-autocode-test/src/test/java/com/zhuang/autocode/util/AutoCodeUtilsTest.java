package com.zhuang.autocode.util;

import com.zhuang.autocode.MyAutoCodeTestApplicationTest;
import org.junit.Test;

public class AutoCodeUtilsTest extends MyAutoCodeTestApplicationTest {

    @Test
    public void test() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(AutoCodeUtils.nextCode("SQ{dt:yyyyMMdd}{seq:3}"));
        }
    }

}
