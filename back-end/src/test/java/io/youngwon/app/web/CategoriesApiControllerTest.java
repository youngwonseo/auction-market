package io.youngwon.app.web;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class CategoriesApiControllerTest extends SpringMockMvcTestSupport {

//    @Test
//    @Order(1)
//    @WithMockJwtAuthentication
//    @DisplayName("01. 카테고리 등록 성공 테스트(상위 카테고리 없음)")
//    public void categorySaveSuccessTest() throws Exception {
//
//        CategoriesSaveRequestDto requestDto = CategoriesSaveRequestDto.builder().title("가전").build();
//        ResultActions result = this.mockMvc.perform(
//                post("/api/categories")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(requestDto))
//        );
//
//        result.andDo(
//                document("category-save",
//                        getDocumentRequest(),
//                        getDocumentResponse(),
//                        requestFields(
//                                fieldWithPath("title").type(JsonFieldType.STRING).description("카테고리명"),
//                                fieldWithPath("parent").type(JsonFieldType.NUMBER).description("상위카테고리 식별자").optional()
//                       source ),
//                        responseFields(
//                                fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("성공여부"),
//                                fieldWithPath("response.id").type(JsonFieldType.NUMBER).description("식별자"),
//                                fieldWithPath("response.title").type(JsonFieldType.STRING).description("상품명"),
//                                fieldWithPath("response.parent").type(JsonFieldType.NUMBER).description("상위 카테고리 식별자").optional(),
//                                fieldWithPath("error").type(JsonFieldType.NULL).description("오류")
//                        )
//                )
//        ).andExpect(status().isOk());
////        .andExpect(jsonPath("$.response.title", is(requestDto.getTitle())))
////        .andExpect(jsonPath("$.response.createdAt").exists());
//    }

//
//    @Test
//    @Order(2)
//    @WithMockJwtAuthentication
//    @DisplayName("02. 카테고리 수정 성공 테스트")
//    public void categoryUpdateSuccessTest() throws Exception {
//
//        CategoriesSaveRequestDto requestDto = CategoriesSaveRequestDto.builder().title("가전").build();
//        ResultActions result = this.mockMvc.perform(
//                put("/api/categories")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(requestDto))
//        );
//
//        result.andDo(
//                document("category-save",
//                        getDocumentRequest(),
//                        getDocumentResponse(),
//                        requestFields(
//                                fieldWithPath("title").type(JsonFieldType.STRING).description("카테고리명"),
//                                fieldWithPath("parent").type(JsonFieldType.NUMBER).description("상위카테고리 식별자").optional()
//                        ),
//                        responseFields(
//                                fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("성공여부"),
//                                fieldWithPath("response.id").type(JsonFieldType.NUMBER).description("식별자"),
//                                fieldWithPath("response.title").type(JsonFieldType.STRING).description("상품명"),
//                                fieldWithPath("response.parent").type(JsonFieldType.NUMBER).description("상위 카테고리 식별자").optional(),
//                                fieldWithPath("error").type(JsonFieldType.NULL).description("오류")
//                        )
//                )
//        ).andExpect(status().isOk());
//    }

}
