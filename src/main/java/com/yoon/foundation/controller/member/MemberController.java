package com.yoon.foundation.controller.member;

import com.yoon.foundation.common.response.CommonResponse;
import com.yoon.foundation.dto.member.FinishRequestDTO;
import com.yoon.foundation.dto.member.LoginRequestDTO;
import com.yoon.foundation.dto.member.FeedbackRequestDTO;
import com.yoon.foundation.dto.member.SatietyRequestDTO;
import com.yoon.foundation.service.member.MemberQueryService;
import com.yoon.foundation.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/member")
public class MemberController {

    private final MemberService memberService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/login")
    public CommonResponse<Object> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return memberService.findMember(loginRequestDTO);
    }

    @PostMapping("/satiety")
    public CommonResponse<String> updateSatiety(@RequestBody SatietyRequestDTO satietyRequestDTO) throws NoSuchFieldException {
        return memberService.findMemberSatiety(satietyRequestDTO);
    }

    @PostMapping("/feedback")
    public CommonResponse<String> feedback(@RequestBody FeedbackRequestDTO feedbackRequestDTO){
        return memberService.feedback(feedbackRequestDTO);
    }

    @PostMapping("/finish")
    public CommonResponse<String> finish(@RequestBody FinishRequestDTO finishRequestDTO){
        return memberService.finish(finishRequestDTO);
    }



}
