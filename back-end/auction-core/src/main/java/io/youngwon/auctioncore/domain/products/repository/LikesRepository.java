package io.youngwon.auctioncore.domain.products.repository;

import io.youngwon.auctioncore.domain.products.entity.Like;
import io.youngwon.auctioncore.domain.products.entity.id.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Like, LikeId> {

}
