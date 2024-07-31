package io.youngwon.app.api;


import io.youngwon.app.api.dto.ProductListResponse;
import io.youngwon.app.api.dto.ProductResponse;
import io.youngwon.app.api.dto.ProductsStateType;
import io.youngwon.app.domain.products.service.ProductsSearchService;
import io.youngwon.app.domain.products.service.ProductsService;
import io.youngwon.app.security.JwtAuthentication;
import io.youngwon.app.utils.paging.PageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static io.youngwon.app.utils.ApiUtils.ApiResult;
import static io.youngwon.app.utils.ApiUtils.success;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductsApiController {

    private final ProductsService productsService;
    private final ProductsSearchService productsSearchService;

    @GetMapping("/api/products")
    public ApiResult<Page<ProductListResponse>> getAll(
            @RequestParam(required = false) ProductsStateType type,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content,
            final PageRequest pageable,
            @AuthenticationPrincipal JwtAuthentication authentication) {

        return success(productsSearchService.getAll(
                null,
                title,
                content,
                type,
                authentication.id,
                pageable.of()));
    }

    @GetMapping("/api/products/{id}")
    public ApiResult<ProductResponse> getOne(
            @PathVariable Long id,
            @AuthenticationPrincipal JwtAuthentication authentication) {
        return success(productsService.getOne(id, authentication.id));
    }
}
