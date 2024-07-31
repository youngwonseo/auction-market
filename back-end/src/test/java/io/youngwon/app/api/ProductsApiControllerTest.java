package io.youngwon.app.api;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class ProductsApiControllerTest extends SpringMockMvcTestSupport {

    @BeforeEach
    void setup() {
//    @Test
//    @Order(1)
//    @WithMockJwtAuthentication
//    @DisplayName("01. 상품 등록 성공 테스트")
//    public void productSaveSuccessTest() throws Exception {
//
//        // request body
//        ProductsSaveRequestDto requestDto = ProductsSaveRequestDto.builder()
//                .title("맥북프로 M1 16G")
//                .content("2021년식 맥북프로 M1 16G입니다.")
//                .startPrice(1000L)
//                .startDateTime("2021-05-01 10:00 AM")
//                .endDateTime("2021-05-10 10:00 AM")
//                .categories(1L)
//                .tags(new String[]{""})
//                .build();
//
//        ResultActions result = this.mockMvc.perform(
//                post("/api/products")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(requestDto))
//        );
//
//        result.andDo(
//                document("product-save",
//                        getDocumentRequest(),
//                        getDocumentResponse(),
//                        requestFields(
//                                fieldWithPath("title").type(JsonFieldType.STRING).description("상품명"),
//                                fieldWithPath("content").type(JsonFieldType.STRING).description("상세내용"),
//                                fieldWithPath("images").type(JsonFieldType.NULL).description("상품 이미지"),
//                                fieldWithPath("startPrice").type(JsonFieldType.NUMBER).description("경매 시작가"),
//                                fieldWithPath("startDateTime").type(JsonFieldType.STRING).description("경매 시작시간"),
//                                fieldWithPath("endDateTime").type(JsonFieldType.STRING).description("경매 종료시간"),
//                                fieldWithPath("categories").type(JsonFieldType.NUMBER).description("카테고리"),
//                                fieldWithPath("tags").type(JsonFieldType.ARRAY).description("태그 목록")
//                        ),
//                        responseFields(
//                                fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("성공여부"),
//                                fieldWithPath("response.id").type(JsonFieldType.NUMBER).description("식별자"),
//                                fieldWithPath("response.title").type(JsonFieldType.STRING).description("상품명"),
//                                fieldWithPath("response.content").type(JsonFieldType.STRING).description("상세내용"),
//                                fieldWithPath("response.startPrice").type(JsonFieldType.NUMBER).description("경매 시작가"),
//                                fieldWithPath("response.startDateTime").type(JsonFieldType.STRING).description("경매 시작시간"),
//                                fieldWithPath("response.endDateTime").type(JsonFieldType.STRING).description("경매 종료시간"),
//                                fieldWithPath("response.viewCount").type(JsonFieldType.NUMBER).description("조회수"),
//                                fieldWithPath("response.auctions").type(JsonFieldType.ARRAY).description("경매 정보"),
//                                fieldWithPath("response.state").type(JsonFieldType.STRING).description("상태"),
//                                fieldWithPath("response.images").type(JsonFieldType.ARRAY).description("상품 이미지"),
//                                fieldWithPath("response.numOfLike").type(JsonFieldType.NUMBER).description("좋아요 수"),
//                                fieldWithPath("response.isLike").type(JsonFieldType.BOOLEAN).description("좋아요 여부"),
//                                fieldWithPath("response.numOfAuctions").type(JsonFieldType.NUMBER).description("경매 입찰수"),
//                                fieldWithPath("response.numOfParticipant").type(JsonFieldType.NUMBER).description("경매 참여자수"),
//                                fieldWithPath("response.price").type(JsonFieldType.NULL).description("현재가격"),
//                                fieldWithPath("response.categories").type(JsonFieldType.ARRAY).description("카테고리"),
//                                fieldWithPath("response.categories.[].id").type(JsonFieldType.NUMBER).description("카테고리 식별자"),
//                                fieldWithPath("response.categories.[].title").type(JsonFieldType.NULL).description("카테고리명"),
//                                fieldWithPath("error").type(JsonFieldType.NULL).description("에러여부")
//                        )
//                )
//        );

//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.response.title", is(requestDto.getTitle())))
//                .andExpect(jsonPath("$.response.content", is(requestDto.getContent())))
//                .andExpect(jsonPath("$.response.createdAt").exists());
    }


    @Test
    @Order(2)
    @DisplayName("02. 상품 등록 실패 테스트 (존재하지 않는 카테고리 선택)")
    public void productSaveFailureTest1() throws Exception {

//        ProductsSaveRequestDto requestDto = ProductsSaveRequestDto.builder()
//                .title("상품1")
//                .content("상품1입니다.")
//                .startPrice(1000L)
//                .startDateTime("2021-01-01 10:00 AM")
//                .endDateTime("2021-01-10 10:00 PM")
//                .categories(1L)
//                .build();
//
//        this.mockMvc.perform(
//                post("/api/products")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(requestDto))
//        ).andDo(print())
//                .andExpect(status().is5xxServerError());

    }


//    @Test
//    @Order(3)
//    @WithMockJwtAuthentication
//    @DisplayName("03. 상품 등록 실패 테스트 (상품 시작 가격, 종료 날짜 누락)")
//    public void productSaveFailureTest2() throws Exception {
//        ProductsSaveRequestDto requestDto = ProductsSaveRequestDto.builder()
//                .title("상품1")
//                .content("상품1입니다.")
////                .startPrice(1000L)
//                .startDateTime("2021-01-01 10:00 AM")
////                .endDateTime("2021-01-10 10:00 PM")
//                .categories(1L)
//                .build();
//
//        this.mockMvc.perform(
//                post("/api/products")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(requestDto))
//        ).andDo(print())
//                .andExpect(status().is4xxClientError())
//                .andExpect(jsonPath("$.success", is(false)))
//                .andExpect(jsonPath("$.error").exists())
//                .andExpect(jsonPath("$.error.status", is(400)));
//
//    }


    @Test
    @Order(4)
    @DisplayName("04. 상품 등록 실패 테스트 (로그인이 되어 있지 않음)")
    public void productSaveFailureTest3() throws Exception {

    }


    @Test
    @Order(5)
    @DisplayName("05. 상품 목록 조회 테스트 (페이징)")
    public void findAllSuccessTest() throws Exception {
//        this.mockMvc.perform(get("/api/products"));

    }


    @Test
    @Order(6)
    @DisplayName("06. 단일 상품 조회 테스트")
    public void findByIdSuccessTest() throws Exception {
//        this.mockMvc.perform(get("/api/products/{id}", 10))
//                .andDo(print())
//                .andExpect(status().is(HttpStatus.OK.value()))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andDo(document("products", // (3)
//                        pathParameters(
//                                parameterWithName("id").description("products unique id") // (4)
//                        ),
//                        responseFields(
//                                fieldWithPath("success").description("result"),
//                                fieldWithPath("response.id").description("book unique id"),
//                                fieldWithPath("response.title").description("title"),
//                                fieldWithPath("response.content").description("book unique id"),
//                                fieldWithPath("response.startPrice").description("author"),
//                                fieldWithPath("response.startDateTime").description("author"),
//                                fieldWithPath("response.endDateTime").description("author"),
//                                fieldWithPath("response.viewCount").description("author"),
//                                fieldWithPath("response.auctions").description("author"),
//                                fieldWithPath("response.numOfLike").description("author"),
//                                fieldWithPath("response.isLike").description("author"),
//                                fieldWithPath("response.numOfAuctions").description("author"),
//                                fieldWithPath("response.numOfParticipant").description("author"),
//                                fieldWithPath("response.price").description("author"),
//                                fieldWithPath("response.isFinish").description("author"),
//                                fieldWithPath("error").description("result")
//                        ).and(
//                                subsectionWithPath("response.images").description("dd"),
//                                subsectionWithPath("response.categories").description("dd"))
//                ));
    }


    @Test
    @Order(7)
    @DisplayName("07. 단일 상품 실패 테스트 (존재하지 않는 ID)")
    public void findByIdFailureTest() throws Exception {

    }


}
