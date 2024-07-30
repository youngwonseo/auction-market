package io.youngwon.app.domain.products.service;

import io.youngwon.app.api.dto.ProductsListResponseDto;
import io.youngwon.app.api.dto.ProductsStateType;
import io.youngwon.app.domain.products.entity.Categories;
import io.youngwon.app.exception.NotImplementedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
public class ProductsSearchService {

    public Page<ProductsListResponseDto> findAll(
            final Categories categories,
            final String title,
            final String content,
            final ProductsStateType type,
//            final Boolean own,
//            final Boolean onLike,
//            final Boolean onAuction,
            final Long userId,
            final Pageable pageable
    ) {
        throw new NotImplementedException();
//        JPQLQuery<Product> query = from(product);
//
//        // 동시검색?
//        // 좋아요
//        if (type != null && type == ProductsStateType.LIKE) {
//            query = query.innerJoin(product.likes, likes)
//                    .on(likes.users.id.eq(userId));
//        }
//
//        // 경매참여
//        if (type != null && type == ProductsStateType.AUCTION) {
//            query = query.innerJoin(product.auctions, auctions)
//                    .on(auctions.participants.id.eq(userId));
//        }
//
//        query = query.where(
//                eqCategories(categories),
//                likeTitle(title),
//                eqState(type),
//                onlyOwn(type != null && type == ProductsStateType.OWN ? true : false, userId)
//        ).orderBy(
//                product.state.desc(),
//                product.id.desc()
//        );
//
//        final List<Product> products = getQuerydsl().applyPagination(pageable, query).fetch();
//        return new PageImpl<>(
//                products.stream().map(d -> new ProductsListResponseDto(d, userId)).collect(Collectors.toList()),
//                pageable,
//                query.fetchCount());
    }
}
