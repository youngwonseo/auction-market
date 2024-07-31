package io.youngwon.app.api;

import io.youngwon.app.api.dto.MeResponse;
import io.youngwon.app.domain.users.service.UserService;
import io.youngwon.app.security.UserPrincipal;
import io.youngwon.app.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.youngwon.app.utils.ApiUtils.success;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UsersApiController {

    private final UserService usersService;

    @GetMapping("/api/v1/me")
    public ApiUtils.ApiResult<MeResponse> me(@AuthenticationPrincipal UserPrincipal principal) {
        return success(new MeResponse(principal.getEmail(), principal.getName()));
    }
}
