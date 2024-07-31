package io.youngwon.app.security.provider;


public record LoginProviderUser(
        LoginProvider provider,
        String name,
        String email,
        String id
) {
}
