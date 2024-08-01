package io.youngwon.auctionapi.api;


import io.youngwon.auctionapi.api.dto.AuctionsBidRequest;
import io.youngwon.auctionapi.common.ApiUtils;
import io.youngwon.auctionapi.security.UserPrincipal;
import io.youngwon.auctioncore.auctions.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static io.youngwon.auctionapi.common.ApiUtils.success;


@RequiredArgsConstructor
@RestController
public class AuctionsApiController {

    private final AuctionService auctionsService;

    @PostMapping("/api/v1/products/{id}/auctions/bid")
    public ApiUtils.ApiResult<Boolean> bid(
            @PathVariable Long id,
            @RequestBody AuctionsBidRequest request,
            @AuthenticationPrincipal UserPrincipal principal) {

        return success(auctionsService.bid(id, request.price(), principal.getIdAsLong()));
    }
}
