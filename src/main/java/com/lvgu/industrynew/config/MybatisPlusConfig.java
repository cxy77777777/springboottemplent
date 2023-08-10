package com.lvgu.industrynew.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis-plus配置
 *开启分页
 * @author fyh
 * @since 1.0.0
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 配置分页
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}