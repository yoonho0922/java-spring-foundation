package com.yoon.foundation.dto.posts;

import com.yoon.foundation.common.PageInfoResponse;
import com.yoon.foundation.common.PageResponse;
import com.yoon.foundation.domain.posts.Posts;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class PostsPageResponse extends PageResponse {
    private List<PostsQueryResponse> posts;

    public PostsPageResponse(
            PageInfoResponse pageInfo,
            List<Posts> posts
    ){
        super(pageInfo);
        this.posts = posts.stream()
                .map(PostsQueryResponse::new)
                .toList();
    }
}