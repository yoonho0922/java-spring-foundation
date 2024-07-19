package com.yoon.foundation.repository.member;

import com.yoon.foundation.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberCustomRepository {
}
