package io.youngwon.app.api.admin;

import io.youngwon.app.api.dto.ProductRegisterRequest;
import io.youngwon.app.api.dto.ProductResponse;
import io.youngwon.app.api.dto.ProductUpdateRequest;
import io.youngwon.app.domain.products.service.ProductsService;
import io.youngwon.app.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static io.youngwon.app.utils.ApiUtils.success;

@RequiredArgsConstructor
@RestController
public class ProductAdminApiController {
    private final ProductsService productsService;

    @PostMapping("/admin/api/v1/products")
    public ApiUtils.ApiResult<ProductResponse> register(
            @Valid @RequestBody ProductRegisterRequest request) {
        Long id = productsService.register(
                request.title(),
                request.content(),
                request.startPrice(),
                request.categories(),
                request.startDateTime(),
                request.endDateTime()
        );
        return success(productsService.getOne(id, 0L));
    }

    @PutMapping("/admin/api/v1/products/{id}")
    public ApiUtils.ApiResult<ProductResponse> update(
            @PathVariable Long id,
            @RequestBody ProductUpdateRequest request) {

        productsService.update(
                id,
                request.title(),
                request.content(),
                request.startPrice(),
                request.startDate(),
                request.endDateTime()
        );
        return success(productsService.getOne(id, 0L));
    }

    @DeleteMapping("/admin/api/v1/products/{id}")
    public ApiUtils.ApiResult<Boolean> delete(@PathVariable Long id) {
        productsService.delete(id);
        return success(true);
    }
}
