package io.youngwon.auctionapi.api;


import io.youngwon.auctionapi.common.ApiUtils;
import io.youngwon.auctionapi.security.UserPrincipal;
import io.youngwon.auctioncore.domain.products.service.LikesService;
import io.youngwon.auctioncore.exception.NotImplementedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/products")
public class LikesApiController {

    private final LikesService likesService;

    @PatchMapping("{id}/like")
    public ApiUtils.ApiResult<Integer> like(@PathVariable Long id,
                                            @AuthenticationPrincipal UserPrincipal authentication) {
        throw new NotImplementedException();
    }

    @PatchMapping("{id}/unlike")
    public ApiUtils.ApiResult<Integer> unlike(@PathVariable Long id,
                                              @AuthenticationPrincipal UserPrincipal authentication) {
        throw new NotImplementedException();
    }
}
