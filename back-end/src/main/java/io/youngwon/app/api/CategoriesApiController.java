package io.youngwon.app.api;


import io.youngwon.app.api.dto.CategoriesListResponseDto;
import io.youngwon.app.api.dto.CategoriesResponseDto;
import io.youngwon.app.api.dto.CategoriesSaveRequestDto;
import io.youngwon.app.api.dto.CategoriesUpdateRequestDto;
import io.youngwon.app.domain.products.service.CategoriesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.youngwon.app.utils.ApiUtils.ApiResult;
import static io.youngwon.app.utils.ApiUtils.success;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/categories")
public class CategoriesApiController {

    private final CategoriesService categoriesService;

    @GetMapping
    public ApiResult<List<CategoriesListResponseDto>> findRoots() {
        return success(categoriesService.findRoots());
    }

    @PostMapping
    public ApiResult<CategoriesResponseDto> post(@Valid @RequestBody CategoriesSaveRequestDto requestDto) {
        Long id = categoriesService.save(requestDto);
        return success(categoriesService.findById(id));
    }

    @PutMapping(path = "{id}")
    public ApiResult<CategoriesListResponseDto> put(@PathVariable Long id, @Valid @RequestBody CategoriesUpdateRequestDto requestDto) {
        categoriesService.update(id, requestDto);
        return null;
    }

    @DeleteMapping(path = "{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return null;
    }


}
