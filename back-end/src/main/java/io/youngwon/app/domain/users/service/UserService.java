package io.youngwon.app.domain.users.service;

import io.youngwon.app.api.dto.UserResponse;
import io.youngwon.app.api.dto.UserSaveRequestDto;
import io.youngwon.app.domain.users.entity.User;
import io.youngwon.app.domain.users.repository.UsersRepository;
import io.youngwon.app.security.provider.LoginProvider;
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
    public UserResponse getById(Long id) {
        User user = usersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new UserResponse(user.getId(), user.getEmail(), user.getName());
    }

    @Transactional
    public Long save(UserSaveRequestDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getId();
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
