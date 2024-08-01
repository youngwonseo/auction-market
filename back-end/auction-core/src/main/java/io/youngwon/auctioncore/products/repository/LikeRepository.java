package io.youngwon.auctioncore.products.repository;

import io.youngwon.auctioncore.products.entity.Like;
import io.youngwon.auctioncore.products.entity.id.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, LikeId> {

}
