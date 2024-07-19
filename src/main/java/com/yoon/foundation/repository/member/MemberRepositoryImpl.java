package com.yoon.foundation.repository.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yoon.foundation.domain.member.Member;
import com.yoon.foundation.domain.member.QMember;
import com.yoon.foundation.dto.member.SatietyRequestDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public Member findMember(String name, String email) {
        return queryFactory.select(QMember.member)
                .from(QMember.member)
                .where(QMember.member.name.eq(name).and(QMember.member.email.eq(email)))
                .fetchOne();
    }

    @Override
    public Member findMember(Long memberId) {
        return queryFactory.select(QMember.member)
                .from(QMember.member)
                .where(QMember.member.id.eq(memberId))
                .fetchOne();
    }

}
