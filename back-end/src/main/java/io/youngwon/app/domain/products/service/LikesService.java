package io.youngwon.app.domain.products.service;

import io.youngwon.app.config.errors.NotFoundException;
import io.youngwon.app.domain.products.entity.Like;
import io.youngwon.app.domain.products.repository.LikesRepository;
import io.youngwon.app.domain.products.entity.Product;
import io.youngwon.app.domain.products.repository.ProductsRepository;
import io.youngwon.app.domain.users.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LikesService {

    private final ProductsRepository productsRepository;
    private final LikesRepository likesRepository;

    @Transactional
    public Integer like(Long id, Long userId) {
        Product products = productsRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Could not found product for " + id));


        // 이미 존재하면


        return products.like(new Like(products, new User(userId)));
    }


    @Transactional
    public Integer unlike(Long id, Long userId) {
        Product products = productsRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Could not found product for " + id));

        // 존재하지 않으면

        Like likes = products.getLikes()
                .stream().filter(like -> like.getUsers().getId() == userId).findFirst()
                .orElseThrow(() -> new NotFoundException("Could not found likes for products " + id + " and user " + userId));

        return products.unlike(likes);
    }

}
