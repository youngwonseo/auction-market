package io.youngwon.auctionapi.api;


import io.youngwon.auctionapi.common.ApiUtils;
import io.youngwon.auctionapi.security.UserPrincipal;
import io.youngwon.auctioncore.products.service.ProductLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.youngwon.auctionapi.common.ApiUtils.success;


@RequiredArgsConstructor
@RestController
public class LikeApiController {

    private final ProductLikeService likesService;

    @PutMapping("/api/v1/products/{id}/like")
    public ApiUtils.ApiResult<Void> like(@PathVariable Long id,
                                            @AuthenticationPrincipal UserPrincipal principal) {
        likesService.like(id, principal.getIdAsLong());
        return success(null);
    }

    @PutMapping("/api/v1/products/{id}/unlike")
    public ApiUtils.ApiResult<Void> unlike(@PathVariable Long id,
                                              @AuthenticationPrincipal UserPrincipal principal) {
        likesService.unlike(id, principal.getIdAsLong());
        return success(null);
    }
}
