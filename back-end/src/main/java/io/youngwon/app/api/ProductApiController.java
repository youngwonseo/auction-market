package io.youngwon.app.api;


import io.youngwon.app.api.dto.ProductListResponse;
import io.youngwon.app.api.dto.ProductRegisterRequest;
import io.youngwon.app.api.dto.ProductResponse;
import io.youngwon.app.api.dto.ProductUpdateRequest;
import io.youngwon.app.api.dto.ProductsStateType;
import io.youngwon.app.domain.products.service.ProductService;
import io.youngwon.app.security.UserPrincipal;
import io.youngwon.app.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static io.youngwon.app.utils.ApiUtils.ApiResult;
import static io.youngwon.app.utils.ApiUtils.success;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;

    @PostMapping("/api/v1/products")
    public ApiUtils.ApiResult<ProductResponse> register(
            @Valid @RequestBody ProductRegisterRequest request,
            @AuthenticationPrincipal UserPrincipal principal) {
        Long id = productService.register(
                request.title(),
                request.content(),
                request.startPrice(),
                request.category(),
                request.startDateTime(),
                request.endDateTime(),
                principal.getIdAsLong()
        );
        return success(productService.getOne(id, 0L));
    }

    @PutMapping("/api/v1/products/{id}")
    public ApiUtils.ApiResult<ProductResponse> update(
            @PathVariable Long id,
            @RequestBody ProductUpdateRequest request) {

        productService.update(
                id,
                request.title(),
                request.content(),
                request.startPrice(),
                request.startDate(),
                request.endDateTime()
        );
        return success(productService.getOne(id, 0L));
    }

    @DeleteMapping("/api/v1/products/{id}")
    public ApiUtils.ApiResult<Boolean> delete(@PathVariable Long id) {
        productService.delete(id);
        return success(true);
    }

    @GetMapping("/api/v1/products")
    public ApiResult<Page<ProductListResponse>> getAll(
            @RequestParam(required = false) ProductsStateType type,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content,
            @AuthenticationPrincipal UserPrincipal principal,
            final Pageable pageable) {
        return success(productService.getAll(
                null,
                title,
                content,
                pageable,
                principal.getIdAsLong()));
    }

    @GetMapping("/api/v1/products/{id}")
    public ApiResult<ProductResponse> getOne(
            @PathVariable Long id,
            @AuthenticationPrincipal UserPrincipal principal) {
        return success(productService.getOne(id, principal.getIdAsLong()));
    }
}
