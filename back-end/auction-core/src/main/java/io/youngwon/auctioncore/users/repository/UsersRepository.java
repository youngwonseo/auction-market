package io.youngwon.auctioncore.users.repository;

import io.youngwon.auctioncore.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);
}

