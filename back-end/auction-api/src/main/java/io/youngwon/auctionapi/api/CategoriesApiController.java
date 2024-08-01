package io.youngwon.auctionapi.api;


import io.youngwon.auctionapi.api.dto.CategoriesListResponseDto;
import io.youngwon.auctionapi.common.ApiUtils;
import io.youngwon.auctioncore.domain.products.service.CategoriesService;
import io.youngwon.auctioncore.exception.NotImplementedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CategoriesApiController {

    private final CategoriesService categoriesService;

    @GetMapping("/api/categories")
    public ApiUtils.ApiResult<List<CategoriesListResponseDto>> findRoots() {
//        return ApiUtils.success(categoriesService.findRoots());

        throw new NotImplementedException();
    }
}
