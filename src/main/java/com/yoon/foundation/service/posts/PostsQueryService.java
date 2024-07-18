package com.yoon.foundation.service.posts;

import com.yoon.foundation.common.PageInfoResponse;
import com.yoon.foundation.domain.posts.Posts;
import com.yoon.foundation.dto.posts.PostsPageResponse;
import com.yoon.foundation.repository.posts.PostsQueryFilter;
import com.yoon.foundation.repository.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostsQueryService {
    private final PostsRepository postsRepository;

    public Posts queryOne(Long postsId){
        return postsRepository.findById(postsId)
                .orElseThrow(NoSuchElementException::new);
    }

    public Posts queryOne(PostsQueryFilter filter){
        return postsRepository.findPosts(filter)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Posts> query(PostsQueryFilter filter) {
        return postsRepository.findPostsList(filter);
    }

    // queryPage 함수를 내부 코드에서 의존하면 안됨 (Controller에서만 사용)
    public PostsPageResponse queryPage(Pageable pageable, PostsQueryFilter request) {
        long page = pageable.getOffset();
        long size = pageable.getPageSize();

        List<Posts> posts = postsRepository.findPostsPage(pageable, request);
        long count = postsRepository.countPosts(request);

        long totalPage = (long) Math.ceil((double) count / size);
        boolean isHaveNext = page < totalPage;

        PageInfoResponse pageInfo = PageInfoResponse.builder()
                .page(page)
                .pageSize(size)
                .totalPages(totalPage)
                .totalElements(count)
                .haveNext(isHaveNext)
                .build();

        return new PostsPageResponse(pageInfo, posts);
    }
}
