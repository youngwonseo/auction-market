package io.youngwon.auctioncore.auctions.service;

import io.youngwon.auctioncore.auctions.repository.AuctionPriceRepository;
import io.youngwon.auctioncore.exception.BadRequestException;
import io.youngwon.auctioncore.products.entity.Product;
import io.youngwon.auctioncore.products.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuctionService {

    private final ProductRepository productRepository;
    private final AuctionPriceRepository auctionPriceRepository;

    public boolean bid(Long productId, BigDecimal price, Long userId) {
        // TODO 메모리 캐시로 처리
        Product product = productRepository.findById(productId).orElseThrow(EntityNotFoundException::new);
        if (!product.validateForAuction(LocalDateTime.now())) {
            throw new BadRequestException(BadRequestException.ErrorType.InvalidBid);
        }

        boolean isSuccess = auctionPriceRepository.bid(productId, price, userId);

        // TODO 카프카 메시지 발행
        if (isSuccess) {

        }

        return isSuccess;
    }
}
