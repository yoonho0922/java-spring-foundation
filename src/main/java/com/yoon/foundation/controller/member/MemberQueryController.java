package com.yoon.foundation.controller.member;

import com.yoon.foundation.service.member.MemberQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/member")
public class MemberQueryController {

    private final MemberQueryService memberQueryService;

}
