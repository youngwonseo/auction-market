package io.youngwon.app.security.provider;

import io.youngwon.app.exception.NotImplementedException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum LoginProvider {
    KAKAO("kakao"), NAVER("naver");

    public static LoginProvider valueFromRegistrationId(String registrationId) {
        if (KAKAO.registrationId.equals(registrationId)) {
            return KAKAO;
        } else if(NAVER.registrationId.equals(registrationId)) {
            return NAVER;
        }
        throw new NotImplementedException();
    }

    private final String registrationId;
}
