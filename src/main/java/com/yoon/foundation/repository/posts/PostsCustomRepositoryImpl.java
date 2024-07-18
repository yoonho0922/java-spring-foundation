package com.yoon.foundation.repository.posts;


import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yoon.foundation.domain.posts.Posts;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.yoon.foundation.domain.posts.QPosts.posts;


@Repository
@AllArgsConstructor
public class PostsCustomRepositoryImpl implements PostsCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Posts> findPosts(PostsQueryFilter filter) {
        JPAQuery<Posts> query = queryWithFilter(filter);
        return Optional.ofNullable(query.fetchOne());
    }

    @Override
    public List<Posts> findPostsList(PostsQueryFilter filter) {
        return null;
    }

    @Override
    public List<Posts> findPostsPage(Pageable pageable, PostsQueryFilter filter) {
        JPAQuery<Posts> query = queryWithFilter(filter);

        for (Sort.Order order : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(posts.getType(), posts.getMetadata());
            query.orderBy(new OrderSpecifier<>(order.isAscending() ? Order.ASC : Order.DESC, pathBuilder.get(order.getProperty())));
        }

        int offset = (pageable.getPageNumber() - 1) * pageable.getPageSize(); // 페이지네이션 Offset 계산

        return query
                .offset(offset)
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Long countPosts(PostsQueryFilter filter) {
        JPAQuery<Posts> query = queryWithFilter(filter);
        return query.fetchCount();
    }

    private JPAQuery<Posts> queryWithFilter(PostsQueryFilter filter) {
        JPAQuery<Posts> query = queryFactory.select(posts)
                .from(posts)
                .where(
                        filter.getIds() != null ? posts.id.in(filter.getIds()) : null,
                        filter.getTitleKeyword() != null ? posts.title.like("%" + filter.getTitleKeyword() +"%") : null,
                        filter.getAuthor() != null ? posts.author.eq(filter.getAuthor()) : null
                );
        return query;
    }
}
