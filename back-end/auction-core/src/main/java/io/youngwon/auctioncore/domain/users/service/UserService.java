package io.youngwon.auctioncore.domain.users.service;

import io.youngwon.auctioncore.domain.users.entity.User;
import io.youngwon.auctioncore.domain.users.model.LoginProvider;
import io.youngwon.auctioncore.domain.users.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UsersRepository usersRepository;

    public Long login(
            LoginProvider provider,
            String providerId,
            String name,
            String email) {
        Optional<User> userOptional = usersRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            return userOptional.get().update(provider, providerId, name).getId();
        }
        return usersRepository.save(User.builder()
                .email(email)
                .name(name)
                .provider(provider)
                .providerId(providerId)
                .build()).getId();
    }

    @Transactional(readOnly = true)
    public User getById(Long id) {
        return usersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public User update() {
        return null;
    }

    @Transactional
    public User delete() {
        return null;
    }

}
