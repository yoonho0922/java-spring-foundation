package com.yoon.foundation.dto.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequest {
    private String title;
    private String content;
}
