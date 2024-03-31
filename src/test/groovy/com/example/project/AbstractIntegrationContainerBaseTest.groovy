package com.example.project

import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.GenericContainer
import spock.lang.Specification

/**
 * 싱글턴 테스트 컨테이너
 * 추상클래스를 하나 생성 후, 내부에 테스트에 사용할 컨테이너를 선언해둔다
 * 이후 통합테스트 환경에서, 이 추상클래스를 상속받아서 테스트 진행
 */
@SpringBootTest
abstract class AbstractIntegrationContainerBaseTest extends Specification {
    static final GenericContainer MY_REDIS_CONTAINER

    static {
        MY_REDIS_CONTAINER = new GenericContainer<>("redis:6")
            .withExposedPorts(6379)

        MY_REDIS_CONTAINER.start()

        System.setProperty("spring.redis.host", MY_REDIS_CONTAINER.getHost())
        System.setProperty("spring.redis.port", MY_REDIS_CONTAINER.getMappedPort(6379).toString())
    }
}
