package io.youngwon.auctioncore.products.service;

import io.youngwon.auctioncore.products.entity.Like;
import io.youngwon.auctioncore.products.repository.LikeRepository;
import io.youngwon.auctioncore.products.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductLikeService {

    private final ProductRepository productRepository;
    private final LikeRepository likeRepository;

    @Transactional
    public void like(Long id, Long userId) {
        productRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        // TODO 동시성 문제 해결 필요
        // TODO 성능을 위해 집계테이블 분리
        productRepository.increaseLikeCount(id);

        likeRepository.save(Like.builder().productId(id).createdBy(userId).build());
    }

    @Transactional
    public void unlike(Long id, Long userId) {
        productRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        // TODO 동시성 문제 해결 필요
        // TODO 성능을 위해 집계테이블 분리
        productRepository.increaseLikeCount(id);

        likeRepository.delete(Like.builder().productId(id).createdBy(userId).build());
    }
}
