package io.youngwon.app.domain.products.repository;

import io.youngwon.app.domain.products.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Like, Long> {

}
