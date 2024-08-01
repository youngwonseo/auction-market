package io.youngwon.app.api;


import io.youngwon.app.security.UserPrincipal;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
class ProductApiControllerTest {

    @Autowired
    private MockMvc mvc;

    private RequestPostProcessor withMockUserAsOauth2Login() {
        return oauth2Login().oauth2User(UserPrincipal.builder().id("1000").email("test@email.com").name("이름").build());
    }

    @Test
    @WithMockUser
    @DisplayName("상품 등록 성공")
    void postProductSuccessTest() throws Exception {
        String request = """
                {
                    "title": "맥북프로 M1 16G",
                    "content": "2024년식 맥북프로 M3 32G입니다.",
                    "startPrice": 1000,
                    "startDateTime": "2021-05-01T10:00:00",
                    "endDateTime": "2021-05-10T10:00:00",
                    "category": 1
                }
                """;
        mvc.perform(post("/api/v1/products")
                        .with(withMockUserAsOauth2Login())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    @DisplayName("상품 등록 실패 (제목 공백)")
    void postProductFailTest() throws Exception {

        String request = """
                {
                    "title": " ",
                    "content": "2024년식 맥북프로 M3 32G입니다.",
                    "startPrice": 1000,
                    "startDateTime": "2021-05-01T10:00:00",
                    "endDateTime": "2021-05-10T10:00:00",
                    "category": 1
                }
                """;
        mvc.perform(post("/api/v1/products")
                        .with(withMockUserAsOauth2Login())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser
    @DisplayName("상품 목록 조회 성공 (페이징)")
    void findAllSuccessTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/products")
                        .with(withMockUserAsOauth2Login())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    @DisplayName("단일 상품 조회 성공")
    void findByIdSuccessTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/products/{id}", 1)
                        .with(withMockUserAsOauth2Login())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.response.title", Is.is("맥북프로 M1 16G")));
    }

    @Test
    @WithMockUser
    @DisplayName("단일 상품 조회 실패 (존재하지 않는 ID)")
    void findByIdFailureTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/products/{id}", 100000)
                        .with(withMockUserAsOauth2Login())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
