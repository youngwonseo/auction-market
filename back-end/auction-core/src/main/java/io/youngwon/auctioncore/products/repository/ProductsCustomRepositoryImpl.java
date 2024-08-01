package io.youngwon.auctioncore.products.repository;

import io.youngwon.auctioncore.products.entity.Product;
import io.youngwon.auctioncore.exception.NotImplementedException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public class ProductsCustomRepositoryImpl implements ProductsCustomRepository {

    @Override
    public List<Product> findAllForStartCheck(LocalDateTime now) {

        throw new NotImplementedException();

//        final QProduct product = QProduct.product;
//
//        // 시작 시간이 지났는데 대기중일경우
//        return from(product)
//                .where(
//                        product.startDateTime.before(now),
//                        product.endDateTime.after(now),
//                        product.state.ne(State.SELLING)
//                ).fetch();
    }


    @Override
    public List<Product> findAllForEndCheck(LocalDateTime now) {
        throw new NotImplementedException();
//        final QProduct product = QProduct.product;
//
//        // 종료 시간이 지났는데 판매중인경우
//        return from(product)
//                .where(
//                        product.endDateTime.before(now),
//                        product.state.ne(State.FINISH)
//                ).fetch();
    }


}
