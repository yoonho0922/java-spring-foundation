package com.yoon.foundation.service.member;

import com.yoon.foundation.common.response.CommonResponse;
import com.yoon.foundation.domain.member.Member;
import com.yoon.foundation.dto.member.LoginRequestDTO;
import com.yoon.foundation.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberQueryService {
    private final MemberRepository memberRepository;

}
