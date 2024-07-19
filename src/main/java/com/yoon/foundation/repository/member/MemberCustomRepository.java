package com.yoon.foundation.repository.member;

import com.yoon.foundation.domain.member.Member;
import com.yoon.foundation.dto.member.SatietyRequestDTO;

public interface MemberCustomRepository {
    Member findMember(Long memberId);
    Member findMember(String name, String email);
}
