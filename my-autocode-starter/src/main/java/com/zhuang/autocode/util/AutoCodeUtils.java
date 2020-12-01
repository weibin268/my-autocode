package com.zhuang.autocode.util;

import com.zhuang.autocode.AutoCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 文件上传工具类
 */
@Component
public class AutoCodeUtils {

    private static AutoCodeUtils _this;

    @Autowired
    private AutoCodeBuilder autoCodeBuilder;

    @PostConstruct
    public void init() {
        _this = this;
    }

    public static String nextCode(String expression) {
        return _this.autoCodeBuilder.build(expression);
    }

}
