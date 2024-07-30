package io.youngwon.app.domain.products.repository;

import io.youngwon.app.domain.products.entity.Categories;
import io.youngwon.app.domain.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategories(Categories categories);

//    public List<Products> findByEndDateTimeLessThanAndIsFinishIs(LocalDateTime endDateTime, Boolean isFinish);

}
