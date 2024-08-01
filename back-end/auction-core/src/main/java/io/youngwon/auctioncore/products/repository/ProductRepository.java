package io.youngwon.auctioncore.products.repository;

import io.youngwon.auctioncore.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query("UPDATE Product SET likeCount = likeCount + 1 WHERE id = :id")
    void increaseLikeCount(long id);

    @Modifying
    @Query("UPDATE Product SET likeCount = likeCount - 1 WHERE id = :id")
    void decreaseLikeCount(long id);
}
