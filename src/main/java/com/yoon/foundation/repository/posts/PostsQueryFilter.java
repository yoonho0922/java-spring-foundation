package com.yoon.foundation.repository.posts;

import lombok.Data;

import java.util.List;

@Data
public class PostsQueryFilter {
    private List<Long> ids;
    private String titleKeyword;
    private String author;
}
