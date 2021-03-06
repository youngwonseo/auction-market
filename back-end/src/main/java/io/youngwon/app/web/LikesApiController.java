package io.youngwon.app.web;


import io.youngwon.app.config.auth.LoginUser;
import io.youngwon.app.config.auth.dto.SessionUser;
import io.youngwon.app.service.LikesService;
import io.youngwon.app.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.youngwon.app.utils.ApiUtils.ApiResult;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/products")
public class LikesApiController {

    private final LikesService likesService;

    @PatchMapping("{id}/like")
    public ApiResult<Boolean> like(@LoginUser SessionUser user) {


        return null;
    }

    @PatchMapping("{id}/unlike")
    public ApiResult<Boolean> unlike(@LoginUser SessionUser user) {
        return null;
    }
}
