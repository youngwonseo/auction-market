package io.youngwon.auctionapi.api;


import io.youngwon.auctionapi.common.ApiUtils;
import io.youngwon.auctioncore.exception.NotImplementedException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.youngwon.auctionapi.api.dto.AuctionResponse;
import io.youngwon.auctionapi.api.dto.AuctionsEnterRequestDto;
import io.youngwon.auctioncore.domain.auctions.service.AuctionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class AuctionsApiController {

    private final AuctionsService auctionsService;

    // 큐
//    private final Producer producer;

    private final ObjectMapper objectMapper;

    @PatchMapping("/api/products/{id}/auctions/enter")
    public ApiUtils.ApiResult<List<AuctionResponse>> enter(
            @PathVariable Long id,
            @RequestBody AuctionsEnterRequestDto requestDto) {
        throw new NotImplementedException();
    }


    @PatchMapping("{productId}/auctions/{id}/cancel")
    public ApiUtils.ApiResult<List<AuctionResponse>> cancel(@PathVariable Long productId,
                                                            @PathVariable Long id) {

        return null;
    }


//    @GetMapping("auctions")
//    public Long delete(){
//        auctionsService.deleteAll();
//        return 0L;
//    }


}
