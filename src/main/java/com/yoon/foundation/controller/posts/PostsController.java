package com.yoon.foundation.controller.posts;

import com.yoon.foundation.dto.posts.PostsCreateRequest;
import com.yoon.foundation.service.posts.PostsService;
import com.yoon.foundation.dto.posts.PostsUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/posts")
public class PostsController {
    private final PostsService postsService;

    @PostMapping
    public Long save(
            @RequestBody PostsCreateRequest request
    ) {
        return postsService.create(request);
    }

    @PutMapping("{postsId}")
    public Long update(
            @PathVariable("postsId") Long postsId,
            @RequestBody PostsUpdateRequest request
    ) {
        return postsService.update(postsId, request);
    }

    @DeleteMapping("{postsId}")
    public void delete(
            @PathVariable("postsId") Long postsId
    ) {
        postsService.delete(postsId);
    }
}
