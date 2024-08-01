package io.youngwon.auctioncore.domain.products.service;

import io.youngwon.auctioncore.domain.products.repository.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

//    @Transactional
//    public Long save(CategoriesSaveRequestDto requestDto) {
//        return categoriesRepository.save(requestDto.toEntity()).getId();
//    }
//
//    @Transactional
//    public Long update(Long id, CategoriesUpdateRequestDto requestDto) {
//        Categories categories = categoriesRepository
//                .findById(id)
//                .orElseThrow(() -> new NotFoundException("Could not found product for " + id));
//
//        categories.update(requestDto.getTitle());
//        return id;
//    }
//
//    @Transactional
//    public void delete(Long id) {
//        Categories categories = categoriesRepository
//                .findById(id)
//                .orElseThrow(() -> new NotFoundException("Could not found product for " + id));
//
//        categoriesRepository.delete(categories);
//    }
//
//
//    @Transactional(readOnly = true)
//    public List<CategoriesListResponseDto> findRoots() {
//        return categoriesRepository.findRoots()
//                .stream()
//                .map(CategoriesListResponseDto::new)
//                .collect(Collectors.toList());
//    }
//
//
//    @Transactional(readOnly = true)
//    public CategoriesResponseDto findById(Long id) {
//        return categoriesRepository.findById(id)
//                .map(CategoriesResponseDto::new)
//                .orElseThrow(() -> new NotFoundException("Could not found product for " + id));
//
//    }

}
