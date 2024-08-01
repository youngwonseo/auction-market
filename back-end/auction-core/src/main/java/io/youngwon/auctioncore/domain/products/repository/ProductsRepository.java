package io.youngwon.auctioncore.domain.products.repository;

import io.youngwon.auctioncore.domain.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {



//    public List<Products> findByEndDateTimeLessThanAndIsFinishIs(LocalDateTime endDateTime, Boolean isFinish);

}
