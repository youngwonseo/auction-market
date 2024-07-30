package io.youngwon.app.api;

import io.youngwon.app.domain.users.entity.User;
import io.youngwon.app.domain.users.repository.UsersRepository;
import io.youngwon.app.api.dto.LoginRequestDto;
import io.youngwon.app.api.dto.LoginResponseDto;
import io.youngwon.app.domain.users.webclient.KakaoWebClient;
import io.youngwon.app.exception.NotImplementedException;
import io.youngwon.app.security.Jwt;
import io.youngwon.app.security.JwtAuthenticationToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import static io.youngwon.app.utils.ApiUtils.ApiResult;
import static io.youngwon.app.utils.ApiUtils.success;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AuthApiController {

//    private final Jwt jwt;

    private final UsersRepository usersRepository;

//    private final AuthenticationManager authenticationManager;

    @PostMapping("/api/auth/login")
    public ApiResult<LoginResponseDto> loginWithKakao(@RequestBody LoginRequestDto requestDto) {
        throw new NotImplementedException();
//
//        // 엑세스 토큰을 받고 JWT를 반환
//        String accessToken = null; //new KakaoWebClient.GetAccessToken(requestDto.getCode()).get();
//
//        // 벤더에서 조회한 로그인 정보
//        User login = null; //new KakaoWebClient.GetUserInfo(accessToken).get();
//
//        // vendor로 구분
//        User user = usersRepository.findByEmail(login.getEmail()).orElse(null);
//        if (user == null) {
//            user = usersRepository.save(login);
//        }
//
//
//        Authentication authentication = authenticationManager.authenticate(
//            new JwtAuthenticationToken(user.getEmail())
//        );
//
//
//        final String token = user.newJwt(
//            jwt,
//            authentication.getAuthorities().stream()
//                    .map(GrantedAuthority::getAuthority)
//                    .toArray(String[]::new)
//        );
//
//        log.info("login end");
//        return success(new LoginResponseDto(token, user));
    }


    @GetMapping(path = "me")
    public ApiResult<Boolean> me() {
        return null;
    }


}
