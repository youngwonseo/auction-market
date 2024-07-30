package io.youngwon.app.config.auth;


import io.youngwon.app.domain.users.repository.UsersRepository;
import io.youngwon.app.security.Jwt;
import io.youngwon.app.security.JwtAccessDeniedHandler;
import io.youngwon.app.security.JwtAuthenticationProvider;
import io.youngwon.app.security.JwtAuthenticationTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

//    private final Jwt jwt;
//
//    private final JwtAccessDeniedHandler accessDeniedHandler;
//
//    private final JwtTokenConfigure jwtTokenConfigure;
//
//    private final EntryPointUnauthorizedHandler unauthorizedHandler;
//
//
//    @Bean
//    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
//        return new JwtAuthenticationTokenFilter(jwtTokenConfigure.getHeader(), jwt);
//    }
//
//    @Bean
//    public JwtAuthenticationProvider jwtAuthenticationProvider(UsersRepository usersRepository) {
//        return new JwtAuthenticationProvider(usersRepository);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) ->
                authorize
                        .requestMatchers(
                                "/**",
                                "/css/**",
                                "/images/**",
                                "/js/**",
                                "/h2-console/**",
                                "/api/auth/login")
                        .permitAll());
        return http.build();
    }
}
