package io.youngwon.app.api;


import io.youngwon.app.domain.products.service.LikesService;
import io.youngwon.app.exception.NotImplementedException;
import io.youngwon.app.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.youngwon.app.utils.ApiUtils.ApiResult;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/products")
public class LikesApiController {

    private final LikesService likesService;

    @PatchMapping("{id}/like")
    public ApiResult<Integer> like(@PathVariable Long id,
                                   @AuthenticationPrincipal UserPrincipal authentication) {
        throw new NotImplementedException();
    }

    @PatchMapping("{id}/unlike")
    public ApiResult<Integer> unlike(@PathVariable Long id,
                                     @AuthenticationPrincipal UserPrincipal authentication) {
        throw new NotImplementedException();
    }
}
