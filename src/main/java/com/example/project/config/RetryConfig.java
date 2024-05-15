package com.example.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@Configuration
public class RetryConfig {

    // spring retry를 구현하는 방법은,
    // 1. RetryTemplate을 사용하거나 2. 어노테이션을 이용하는 방법이 있는데
    // RetryTemplate을 사용한다면 아래와 같이 bean 등록한다 (이 프로젝트에서는 어노테이션을 사용함)
    // @Bean
    // public RetryTemplate retryTemplate() {
    //      return new RetryTemplate();
    // }
}
