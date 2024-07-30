package io.youngwon.app.domain.products.repository;

import io.youngwon.app.domain.products.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductsCustomRepository {


    List<Product> findAllForStartCheck(LocalDateTime now);

    public List<Product> findAllForEndCheck(LocalDateTime now);

}
