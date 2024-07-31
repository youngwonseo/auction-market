package io.youngwon.app.domain.products.service;


import io.youngwon.app.api.dto.ProductListResponse;
import io.youngwon.app.api.dto.ProductResponse;
import io.youngwon.app.api.dto.ProductsStateType;
import io.youngwon.app.domain.products.entity.Product;
import io.youngwon.app.domain.products.entity.ProductState;
import io.youngwon.app.domain.products.repository.ProductsRepository;
import io.youngwon.app.exception.BadRequestException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    @Transactional(readOnly = true)
    public ProductResponse getOne(Long id, Long userId) {
        Product products = productsRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return ProductResponse.of(products, false);
    }

    @Transactional(readOnly = true)
    public List<ProductListResponse> getAll(
            final ProductsStateType type,
            final String value,
            final Pageable pageable,
            final Long userId) {

        return productsRepository
                .findAll()
                .stream()
                .map(d -> ProductListResponse.of(d, false))
                .collect(Collectors.toList());
    }

    @Transactional
    public Long updateState(Long id, ProductsStateType type) {
        Product products = productsRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        if (type == ProductsStateType.SELLING) {
            products.onSale();
        } else if (type == ProductsStateType.FINISH) {
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
            final LocalDateTime endDateTime
    ) {
        return productsRepository.save(
                Product.builder()
                        .title(title)
                        .content(content)
                        .startPrice(startPrice)
                        .categoryId(categoryId)
                        .startDateTime(startDateTime)
                        .endDateTime(endDateTime)
                        .build()
        ).getId();
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

    //    @Transactional
//    public Long toFinish(Long id) {
//        Products products = productsRepository
//                .findById(id)
//                .orElseThrow(() -> new NotFoundException("Could not found product for " + id));
//        products.finish();
//        return id;
//    }

    @Transactional
    public Boolean like(Long productId, Long userId) {
        return null;
    }

    @Transactional
    public Boolean unlike(Long productId, Long userId) {
        return null;
    }

}
