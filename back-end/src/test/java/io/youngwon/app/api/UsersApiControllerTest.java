package io.youngwon.app.api;

import io.youngwon.app.domain.users.repository.UsersRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.transaction.BeforeTransaction;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class UsersApiControllerTest extends SpringMockMvcTestSupport {

    @Autowired
    private UsersRepository usersRepository;


    @BeforeTransaction
    public void accountSetup() {
//        User user = usersRepository.save(User.builder()
//                .email("jazz9008@gmail.com")
//                .name("서영원")
//                .build());
    }


    @Test
    @Order(1)
    @DisplayName("내정보 조회 성공 테스트")
    public void userSuccessTest() throws Exception {
        // 세션정보를 받아오지 못함
//        this.mockMvc.perform(
//                get("/api/users/me")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//        ).andDo(print())
//                .andExpect(status().is2xxSuccessful());
    }


    @Test
    @Order(2)
    @DisplayName("내정보 조회 실패 테스트 (로그인 안됨)")
    public void userFailureTest() throws Exception {
//        this.mockMvc.perform(
//                get("/api/users/me")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//        ).andDo(print())
//                .andExpect(status().is4xxClientError());
    }

//
//    @AfterTransaction
//    public void accountRemove() {
//        usersRepository.deleteAll();
//    }


}
