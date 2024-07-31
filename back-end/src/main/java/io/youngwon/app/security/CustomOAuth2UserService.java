package io.youngwon.app.security;

import com.jayway.jsonpath.JsonPath;
import io.youngwon.app.domain.users.service.UserService;
import io.youngwon.app.security.provider.LoginProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserService userService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        try {
            return processOAuth2User(userRequest, oAuth2User);
        } catch (Exception e) {
            throw new InternalAuthenticationServiceException(e.getMessage(), e.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {

        LoginProvider provider = LoginProvider
                .valueFromRegistrationId(userRequest.getClientRegistration().getRegistrationId());

        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        String idInProvider = null;
        String email = null;
        String name = null;
        switch (provider) {
            case KAKAO -> {
                idInProvider = String.valueOf(oAuth2User.getAttributes().get(userNameAttributeName));
                email = JsonPath.read(oAuth2User.getAttributes(), "$.kakao_account.email");
                name = JsonPath.read(oAuth2User.getAttributes(), "$.properties.nickname");
            }
            case NAVER -> {
                idInProvider = JsonPath.read(oAuth2User.getAttributes(), "$.response.id");
                email = JsonPath.read(oAuth2User.getAttributes(), "$.response.email");
                name = JsonPath.read(oAuth2User.getAttributes(), "$.response.name");
            }
        }

        Long loggedInId = userService.login(provider, idInProvider, name, email);
        return new UserPrincipal(String.valueOf(loggedInId), email, name);
    }
}
