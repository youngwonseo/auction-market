package io.youngwon.app.domain.auctions.service;

import io.youngwon.app.api.dto.AuctionResponse;
import io.youngwon.app.api.dto.AuctionsEnterRequestDto;
import io.youngwon.app.api.dto.AuctionsResponseDto;
import io.youngwon.app.domain.auctions.repository.AuctionsRepository;
import io.youngwon.app.domain.products.repository.ProductsRepository;
import io.youngwon.app.exception.NotImplementedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuctionsService {

    private final ProductsRepository productsRepository;
    private final AuctionsRepository auctionsRepository;


    @Transactional
    public List<AuctionResponse> enter(Long id, AuctionsEnterRequestDto requestDto, Long userId) {
        throw new NotImplementedException();
//        Product products = productsRepository
//                .findById(id)
//                .orElseThrow(() -> new NotFoundException("Could not found product for " + id));
//
//        Auctions auctions = auctionsRepository.save(requestDto.toEntity(products, new User(userId)));
//        products.addAuctions(auctions);
//
//        return products.getAuctions().stream().map(AuctionResponse::new).collect(Collectors.toList());
    }


    @Transactional
    public AuctionsResponseDto cancel(Long id, Long auctionId) {
        throw new NotImplementedException();
//        Product products = productsRepository
//                .findById(id)
//                .orElseThrow(() -> new NotFoundException("Could not found product for " + id));
//
////        Auctions auctions = auctionsRepository.findById(requestDto.getAuctoinsId())
////                .orElseThrow(() -> new NotFoundException("Could not found auction for " + requestDto.getAuctoinsId()));
//
//        // 자신의 입찰이 가장 상위에 존재하면
//        if (products.getAuctions().size() > 0 &&
//                products.getAuctions().get(0).getId() == auctionId) {
//            products.getAuctions().get(0).cancel();
//        }
//
//        if (products.getAuctions().size() > 1) {
//            return new AuctionsResponseDto(products.getAuctions().get(1));
//        }
//
//        return null;
    }


    @Transactional
    public void deleteAll() {
        throw new NotImplementedException();
//        auctionsRepository.deleteAll();
    }


}
