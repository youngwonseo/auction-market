package io.youngwon.app.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.youngwon.app.api.dto.AuctionResponse;
import io.youngwon.app.api.dto.AuctionsEnterRequestDto;
import io.youngwon.app.domain.auctions.service.AuctionsService;
import io.youngwon.app.exception.NotImplementedException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.youngwon.app.utils.ApiUtils.ApiResult;


@RequiredArgsConstructor
@RestController
public class AuctionsApiController {

    private final AuctionsService auctionsService;

    // 큐
//    private final Producer producer;

    private final ObjectMapper objectMapper;

    @PatchMapping("/api/products/{id}/auctions/enter")
    public ApiResult<List<AuctionResponse>> enter(
            @PathVariable Long id,
            @RequestBody AuctionsEnterRequestDto requestDto) {
        throw new NotImplementedException();
    }


    @PatchMapping("{productId}/auctions/{id}/cancel")
    public ApiResult<List<AuctionResponse>> cancel(@PathVariable Long productId,
                                                   @PathVariable Long id) {


        auctionsService.cancel(productId, id);
        return null;
    }


//    @GetMapping("auctions")
//    public Long delete(){
//        auctionsService.deleteAll();
//        return 0L;
//    }


}
