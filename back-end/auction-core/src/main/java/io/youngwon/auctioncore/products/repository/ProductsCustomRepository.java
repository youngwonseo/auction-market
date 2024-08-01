package io.youngwon.auctioncore.products.repository;

import io.youngwon.auctioncore.products.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductsCustomRepository {


    List<Product> findAllForStartCheck(LocalDateTime now);

    List<Product> findAllForEndCheck(LocalDateTime now);

}
