package io.youngwon.auctioncore.auctions.repository;

import io.youngwon.auctioncore.auctions.entity.Auctions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionsRepository extends JpaRepository<Auctions, Long> {
}
