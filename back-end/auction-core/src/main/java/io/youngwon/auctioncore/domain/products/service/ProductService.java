package io.youngwon.auctioncore.domain.products.service;


import io.youngwon.auctioncore.domain.products.entity.Product;
import io.youngwon.auctioncore.domain.products.entity.ProductState;
import io.youngwon.auctioncore.domain.products.repository.ProductsRepository;
import io.youngwon.auctioncore.domain.users.entity.User;
import io.youngwon.auctioncore.domain.users.repository.UsersRepository;
import io.youngwon.auctioncore.exception.BadRequestException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductsRepository productsRepository;
    private final UsersRepository usersRepository;

    @Transactional(readOnly = true)
    public Product getOne(Long id, Long userId) {
        return productsRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public Page<Product> getAll(
            final ProductState type,
            final String title,
            final String content,
            final Pageable pageable,
            final Long userId) {
        return productsRepository
                .findAll(pageable);
    }

    @Transactional
    public Long updateState(Long id, ProductState type) {
        Product products = productsRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        if (type == ProductState.SELLING) {
            products.onSale();
        } else if (type == ProductState.FINISHED) {
            products.finish();
        }

        return id;
    }

    @Transactional
    public Long register(
            final String title,
            final String content,
            final BigDecimal startPrice,
            final Long categoryId,
            final LocalDateTime startDateTime,
            final LocalDateTime endDateTime,
            final Long createdBy) {
        return productsRepository.save(
                        Product.builder()
                                .title(title)
                                .content(content)
                                .startPrice(startPrice)
                                .categoryId(categoryId)
                                .startDateTime(startDateTime)
                                .endDateTime(endDateTime)
                                .createdBy(User.of(createdBy))
                                .build())
                .getId();
    }

    @Transactional
    public Long update(
            final Long id,
            final String title,
            final String content,
            final BigDecimal startPrice,
            final LocalDateTime startDateTime,
            final LocalDateTime endDateTime) {

        Product product = productsRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        // TODO 동시성 문제 확인
        if (product.getState() != ProductState.WAIT) {
            throw new BadRequestException(BadRequestException.ErrorType.NotWaitProduct);
        }

        product.update(
                title,
                content,
                startPrice,
                startDateTime,
                endDateTime
        );

        return id;
    }

    @Transactional
    public Long delete(Long id) {
        Product product = productsRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        if (!product.delete()) {
            throw new EntityNotFoundException();
        }
        return id;
    }

    @Transactional
    public Boolean like(Long productId, Long userId) {
        return null;
    }

    @Transactional
    public Boolean unlike(Long productId, Long userId) {
        return null;
    }

}
