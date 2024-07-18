package com.yoon.foundation.controller.posts;

import com.yoon.foundation.common.CommonResponse;
import com.yoon.foundation.common.PageQueryRequest;
import com.yoon.foundation.domain.posts.Posts;
import com.yoon.foundation.dto.posts.PostsPageResponse;
import com.yoon.foundation.dto.posts.PostsQueryResponse;
import com.yoon.foundation.repository.posts.PostsQueryFilter;
import com.yoon.foundation.service.posts.PostsQueryService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/posts")
public class PostsQueryController {
    private final PostsQueryService postsQueryService;

    @GetMapping("{postsId}")
    public CommonResponse<PostsQueryResponse> queryOne(
            @PathVariable("postsId") Long postsId
    ) {
        Posts posts = postsQueryService.queryOne(postsId);
        return CommonResponse.success(new PostsQueryResponse(posts));
    }

    @GetMapping("page")
    public CommonResponse<PostsPageResponse> queryPage(
            @ParameterObject PostsQueryFilter filter,
            @ParameterObject PageQueryRequest pageQueryRequest
    ) {
        PostsPageResponse postsPageResponse = postsQueryService.queryPage(
                pageQueryRequest.toPageable(),
                filter
        );
        return CommonResponse.success(postsPageResponse);
    }
}
