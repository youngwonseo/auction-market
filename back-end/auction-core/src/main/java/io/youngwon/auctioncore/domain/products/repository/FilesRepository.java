package io.youngwon.auctioncore.domain.products.repository;

import io.youngwon.auctioncore.domain.products.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files, Long> {
}
