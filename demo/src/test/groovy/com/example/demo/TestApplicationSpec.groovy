package com.example.demo

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class TestApplicationSpec extends Specification {

    def "helloテスト"() {
        when:
        final expected = "hello"
        final actual = "hello"

        then:
        actual == expected
    }
}