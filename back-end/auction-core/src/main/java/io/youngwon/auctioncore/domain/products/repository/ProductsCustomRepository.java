package io.youngwon.auctioncore.domain.products.repository;

import io.youngwon.auctioncore.domain.products.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductsCustomRepository {


    List<Product> findAllForStartCheck(LocalDateTime now);

    List<Product> findAllForEndCheck(LocalDateTime now);

}
