package com.yoon.foundation.service.posts;

import com.yoon.foundation.domain.posts.Posts;
import com.yoon.foundation.dto.posts.PostsCreateRequest;
import com.yoon.foundation.dto.posts.PostsUpdateRequest;
import com.yoon.foundation.repository.posts.PostsRepository;
import jakarta.persistence.EntityListeners;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@EntityListeners(AuditingEntityListener.class)
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long create(PostsCreateRequest request) {
        return postsRepository.save(request.toEntity()).getId();
    }

    @Transactional
    public Long update(Long postsId, PostsUpdateRequest request) {
        Posts posts = postsRepository.findById(postsId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id=" + postsId));

        posts.update(request.getTitle(), request.getContent());

        return postsId;
    }

    @Transactional
    public void delete(Long postsId) {
        Posts posts = postsRepository.findById(postsId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id=" + postsId));

        postsRepository.delete(posts);
    }
}
