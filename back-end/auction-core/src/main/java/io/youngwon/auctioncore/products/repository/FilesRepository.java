package io.youngwon.auctioncore.products.repository;

import io.youngwon.auctioncore.products.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files, Long> {
}
