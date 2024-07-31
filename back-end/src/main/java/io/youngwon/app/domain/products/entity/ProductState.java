package io.youngwon.app.domain.products.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductState {
    WAIT("STATE_WAITING", "대기중"),
    SELLING("STATE_SELLING", "판매중"),
    FINISHED("STATE_FINISH", "종료");

    private final String key;
    private final String value;
}
