package com.zhuang.autocode;

import com.zhuang.autocode.service.AutoCodeService;
import com.zhuang.autocode.service.MyBatisPlusAutoCodeService;
import com.zhuang.autocode.service.RedisAutoCodeService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@MapperScan("com.zhuang.autocode.mapper")
public class MyAutoCodeAutoConfiguration {

    @Bean
    public AutoCodeBuilder autoCodeBuilder(AutoCodeService autoCodeService) {
        return new AutoCodeBuilder(autoCodeService);
    }

    @Bean
    @ConditionalOnProperty(name = "my.autocode.storeProvider", havingValue = "db", matchIfMissing = true)
    public AutoCodeService myBatisPlusAutoCodeService() {
        return new MyBatisPlusAutoCodeService();
    }

    @Bean
    @ConditionalOnProperty(name = "my.autocode.storeProvider", havingValue = "redis")
    public AutoCodeService redisAutoCodeService() {
        return new RedisAutoCodeService();
    }

}
