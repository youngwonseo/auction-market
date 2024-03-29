package io.youngwon.app.domain.comments.api;

import io.youngwon.app.domain.comments.service.CommentsService;
import io.youngwon.app.domain.comments.dto.CommentsListResponseDto;
import io.youngwon.app.domain.comments.dto.CommentsSaveRequestDto;
import io.youngwon.app.domain.comments.dto.CommentsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.youngwon.app.utils.ApiUtils.ApiResult;
import static io.youngwon.app.utils.ApiUtils.success;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/products")
public class CommentsApiController {

    private final CommentsService commentsService;

    @GetMapping("{id}/comments")
    public ApiResult<List<CommentsListResponseDto>> findByProduct(@PathVariable Long id){
        return success(commentsService.findByProduct(id));
    }


    @PostMapping("{id}/comments")
    public ApiResult save(@PathVariable Long id,
                          @RequestBody CommentsSaveRequestDto requestDto) {
        return success(commentsService.save(id, requestDto));
    }


    @PutMapping("{id}/comments/{cid}")
    public ApiResult update(@PathVariable Long id,
                            @PathVariable Long cid,
                            @RequestBody CommentsUpdateRequestDto requestDto) {
        commentsService.update(id, cid, requestDto);
        return null;
    }


    @DeleteMapping("{id}/comments/{cid}")
    public ApiResult delete(@PathVariable Long id,
                            @PathVariable Long cid) {

        commentsService.delete(id, cid);
        return null;
    }

}
