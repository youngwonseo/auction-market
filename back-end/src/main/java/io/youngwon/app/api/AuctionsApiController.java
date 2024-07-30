package io.youngwon.app.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.youngwon.app.api.dto.AuctionsEnterRequestDto;
import io.youngwon.app.api.dto.AuctionsListResponseDto;
import io.youngwon.app.domain.auctions.service.AuctionsService;
import io.youngwon.app.security.JwtAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.youngwon.app.utils.ApiUtils.ApiResult;
import static io.youngwon.app.utils.ApiUtils.success;


@RequiredArgsConstructor
@RestController
public class AuctionsApiController {

    private final AuctionsService auctionsService;

    // 큐
//    private final Producer producer;

    private final ObjectMapper objectMapper;

    @PatchMapping("/api/products/{id}/auctions/enter")
    public ApiResult<List<AuctionsListResponseDto>> enter(
            @PathVariable Long id,
            @RequestBody AuctionsEnterRequestDto requestDto,
            @AuthenticationPrincipal JwtAuthentication authentication) {

        // 캐싱


        // isFinish Check
        List<AuctionsListResponseDto> result = auctionsService.enter(id, requestDto, authentication.id);


        // 상품에 대한 auction 전체 정보 반환?
        try {
            String auction = objectMapper.writeValueAsString(result);
//            producer.sendTo(auction);
        } catch (Exception e) {

        }


        return success(result);
    }


    @PatchMapping("{productId}/auctions/{id}/cancel")
    public ApiResult<List<AuctionsListResponseDto>> cancel(@PathVariable Long productId,
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
