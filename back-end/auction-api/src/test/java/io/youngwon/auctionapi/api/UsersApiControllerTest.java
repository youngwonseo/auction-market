package io.youngwon.auctionapi.api;

import io.youngwon.auctionapi.security.UserPrincipal;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
class UsersApiControllerTest {

    @Autowired
    private MockMvc mvc;

    private RequestPostProcessor withMockUserAsOauth2Login() {
        return oauth2Login().oauth2User(UserPrincipal.builder().id("1000").email("test@email.com").name("이름").build());
    }

    @Test
    void 인증_실패() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/api/v1/me")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    void 인증_성공() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/me")
                        .with(withMockUserAsOauth2Login())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.response.name", Is.is("이름")))
                .andExpect(jsonPath("$.response.email", Is.is("test@email.com")));
    }
}
