package com.zhuang.autocode;

import com.zhuang.autocode.AutoCodeBuilder;
import com.zhuang.autocode.service.AutoCodeService;
import com.zhuang.autocode.service.MyBatisPlusAutoCodeService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@MapperScan("com.zhuang.autocode.mapper")
public class MyAutoCodeAutoConfiguration {

    @Bean
    public AutoCodeBuilder autoCodeBuilder() {
        return new AutoCodeBuilder(autoCodeService());
    }

    @Bean
    public AutoCodeService autoCodeService() {
        return new MyBatisPlusAutoCodeService();
    }

}
