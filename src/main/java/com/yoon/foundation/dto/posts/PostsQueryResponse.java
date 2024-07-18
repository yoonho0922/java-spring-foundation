package com.yoon.foundation.dto.posts;

import com.yoon.foundation.domain.posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostsQueryResponse {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modified_time;
    private LocalDateTime created_time;

    public PostsQueryResponse(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.author = posts.getAuthor();
        this.modified_time = posts.getModifiedDate();
        this.created_time = posts.getCreatedDate();
    }
}
