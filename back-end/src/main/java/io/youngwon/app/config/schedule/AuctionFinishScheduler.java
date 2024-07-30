package io.youngwon.app.config.schedule;

import io.youngwon.app.api.dto.ProductsListStateResponseDto;
import io.youngwon.app.domain.products.service.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class AuctionFinishScheduler {

    public final ProductsService productsService;


    public void auctionEndCheck() {
        // 완료된 경매가 있는지 검사
        // end면서
//        productsService
        // product
        LocalDateTime now = LocalDateTime.now();
        // on sale
        List<ProductsListStateResponseDto> startedList = productsService.findAllForStartCheck(now);
        List<ProductsListStateResponseDto> finishedList = productsService.findAllForEndCheck(now);

        log.info(startedList.size() + "," + finishedList.size() + "," + now);

//        for(ProductsListStateResponseDto product : startedList){
//            productsService.updateState(product.getId(), ProductsStateType.SELLING);
//        }
//
//        for(ProductsListStateResponseDto product : finishedList){
//            productsService.updateState(product.getId(), ProductsStateType.FINISH);
//        }

        // finish

//        messagingTemplate.convertAndSend("/topic/state",
//                finishedList
//        );


        log.info("Java cron job expression:: " + now);
    }
}
