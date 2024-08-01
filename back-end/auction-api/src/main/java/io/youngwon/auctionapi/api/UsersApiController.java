package io.youngwon.auctionapi.api;

import io.youngwon.auctionapi.api.dto.MeResponse;
import io.youngwon.auctionapi.common.ApiUtils;
import io.youngwon.auctionapi.security.UserPrincipal;
import io.youngwon.auctioncore.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UsersApiController {

    private final UserService usersService;

    @GetMapping("/api/v1/me")
    public ApiUtils.ApiResult<MeResponse> me(@AuthenticationPrincipal UserPrincipal principal) {
        return ApiUtils.success(new MeResponse(principal.getEmail(), principal.getName()));
    }
}
