package io.youngwon.app.api;


import io.youngwon.app.api.dto.ProductsListResponseDto;
import io.youngwon.app.api.dto.ProductsResponseDto;
import io.youngwon.app.api.dto.ProductsSaveRequestDto;
import io.youngwon.app.api.dto.ProductsStateType;
import io.youngwon.app.api.dto.ProductsUpdateRequestDto;
import io.youngwon.app.domain.products.service.ProductsSearchService;
import io.youngwon.app.domain.products.service.ProductsService;
import io.youngwon.app.security.JwtAuthentication;
import io.youngwon.app.utils.paging.PageRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.youngwon.app.utils.ApiUtils.ApiResult;
import static io.youngwon.app.utils.ApiUtils.success;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/products")
public class ProductsApiController {

    private final ProductsService productsService;

    private final ProductsSearchService productsSearchService;

    @GetMapping
    public ApiResult<Page<ProductsListResponseDto>> findAll(
            @RequestParam(name = "type", defaultValue = "ALL", required = false) ProductsStateType type,
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "content", required = false) String content,
            final PageRequest pageable,
            @AuthenticationPrincipal JwtAuthentication authentication) {


        return success(productsSearchService.findAll(
                null,
                title,
                content,
                type,
                authentication.id,
                pageable.of()));
    }


    // 페이징 지원 필요
    @GetMapping("categories/{id}")
    public ApiResult<List<ProductsListResponseDto>> findByCategories(
            @PathVariable Long id,
            @AuthenticationPrincipal JwtAuthentication authentication) {
        return success(productsService.findByCategories(id, authentication.id));
    }


    @GetMapping("{id}")
    public ApiResult<ProductsResponseDto> findById(
            @PathVariable Long id,
            @AuthenticationPrincipal JwtAuthentication authentication) {
        return success(productsService.findById(id, authentication.id));
    }


    /**
     * 상품 등록
     *
     * @param requestDto
     * @return
     */
    @PostMapping
    public ApiResult<ProductsResponseDto> save(
            @Valid @RequestBody ProductsSaveRequestDto requestDto,
            @AuthenticationPrincipal JwtAuthentication authentication) {


        Long id = productsService.save(requestDto, authentication.id);
        return success(productsService.findById(id, authentication.id));
    }


    @PutMapping("{id}")
    public ApiResult<ProductsResponseDto> update(
            @PathVariable Long id,
            @RequestBody ProductsUpdateRequestDto requestDto,
            @AuthenticationPrincipal JwtAuthentication authentication) {

        productsService.update(id, requestDto);
        return success(productsService.findById(id, authentication.id));
    }

    @DeleteMapping("{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        productsService.delete(id);
        return success(true);
    }

    @PatchMapping("{id}/onsale")
    public ApiResult<Boolean> onsale() {
        return null;
    }

    @PatchMapping("{id}/soldout")
    public ApiResult<Boolean> soldout() {
        return null;
    }

}
