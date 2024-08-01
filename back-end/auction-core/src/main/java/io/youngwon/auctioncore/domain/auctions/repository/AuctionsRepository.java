package io.youngwon.auctioncore.domain.auctions.repository;

import io.youngwon.auctioncore.domain.auctions.entity.Auctions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionsRepository extends JpaRepository<Auctions, Long> {
}
