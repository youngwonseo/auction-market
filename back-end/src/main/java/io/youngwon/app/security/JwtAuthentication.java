package io.youngwon.app.security;

import java.io.Serializable;

import static lombok.Lombok.checkNotNull;

public class JwtAuthentication implements Serializable {

    public final Long id;

    public final String name;

    JwtAuthentication(Long id, String name) {
        checkNotNull(id, "id must be provided");
        checkNotNull(name, "name must be provided");

        this.id = id;
        this.name = name;
    }
}
