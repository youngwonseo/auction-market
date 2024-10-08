package io.youngwon.auctioncore.products.repository;

import io.youngwon.auctioncore.products.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    @Query("select c from Categories as c where c.parent = null")
    public List<Categories> findRoots();

}
