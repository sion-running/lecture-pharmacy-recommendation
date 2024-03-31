package com.example.project.api.service

import spock.lang.Specification

import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

class KakaoUriBuilderServiceTest extends Specification {
    // 테스트할 서비스 가져오기
    private KakaoUriBuilderService kakaoUriBuilderService;

    // 테스트 할 메서드 생성
    // setup은 모든 메서드가 실행되기 전에 먼저 실행된다
    def setup() {
        kakaoUriBuilderService = new KakaoUriBuilderService();
    }

    def "buildUriByAddressSearch - 한글 파라미터의 경우 정상적으로 인코딩"() {
        given:
        String address = "서울 성북구"
        def charset = StandardCharsets.UTF_8

        when:
        def uri = kakaoUriBuilderService.buildUriByAddressSearch(address)
        def decodeResult = URLDecoder.decode(uri.toString(), charset)

        then:
        decodeResult == "https://dapi.kakao.com/v2/local/search/address.json?query=서울 성북구"
    }
}
