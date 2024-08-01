package io.youngwon.auctionapi.api;


import io.youngwon.auctionapi.api.dto.ProductListResponse;
import io.youngwon.auctionapi.api.dto.ProductRegisterRequest;
import io.youngwon.auctionapi.api.dto.ProductResponse;
import io.youngwon.auctionapi.api.dto.ProductUpdateRequest;
import io.youngwon.auctionapi.api.dto.ProductsStateType;
import io.youngwon.auctionapi.common.ApiUtils;
import io.youngwon.auctionapi.security.UserPrincipal;
import io.youngwon.auctioncore.domain.products.service.ProductService;
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
        return ApiUtils.success(
                ProductResponse.of(productService.getOne(id, 0L), false));
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
        return ApiUtils.success(
                ProductResponse.of(productService.getOne(id, 0L), false));
    }

    @DeleteMapping("/api/v1/products/{id}")
    public ApiUtils.ApiResult<Boolean> delete(@PathVariable Long id) {
        productService.delete(id);
        return ApiUtils.success(true);
    }

    @GetMapping("/api/v1/products")
    public ApiUtils.ApiResult<Page<ProductListResponse>> getAll(
            @RequestParam(required = false) ProductsStateType type,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content,
            @AuthenticationPrincipal UserPrincipal principal,
            final Pageable pageable) {
        return ApiUtils.success(productService.getAll(
                null,
                title,
                content,
                pageable,
                principal.getIdAsLong()).map(e -> ProductListResponse.of(e, false)));
    }

    @GetMapping("/api/v1/products/{id}")
    public ApiUtils.ApiResult<ProductResponse> getOne(
            @PathVariable Long id,
            @AuthenticationPrincipal UserPrincipal principal) {
        return ApiUtils.success(
                ProductResponse.of(productService.getOne(id, principal.getIdAsLong()), false));
    }
}
