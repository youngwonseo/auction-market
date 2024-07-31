package io.youngwon.app.domain.products.repository;

import io.youngwon.app.domain.products.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files, Long> {
}
