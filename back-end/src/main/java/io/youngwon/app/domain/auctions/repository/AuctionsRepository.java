package io.youngwon.app.domain.auctions.repository;

import io.youngwon.app.domain.auctions.entity.Auctions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionsRepository extends JpaRepository<Auctions, Long> {
}
