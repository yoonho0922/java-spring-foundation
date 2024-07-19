package com.yoon.foundation.service.member;


import com.yoon.foundation.common.response.CommonResponse;
import com.yoon.foundation.domain.member.Member;
import com.yoon.foundation.dto.member.FinishRequestDTO;
import com.yoon.foundation.dto.member.LoginRequestDTO;
import com.yoon.foundation.dto.member.FeedbackRequestDTO;
import com.yoon.foundation.dto.member.SatietyRequestDTO;
import com.yoon.foundation.repository.member.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public CommonResponse<String> findMemberSatiety(SatietyRequestDTO satietyRequestDTO) throws NoSuchFieldException {
        Member member = memberRepository.findMember(satietyRequestDTO.getMemberId());
        if(Objects.isNull(member)){
            throw new NoSuchFieldException("존재하지 않는 유저입니다.");
        }
        else{
            return CommonResponse.success("포만도 업데이트 성공");
        }
    }

    @Transactional
    public CommonResponse<Object> findMember(LoginRequestDTO loginRequestDTO){
        Member member = memberRepository.findMember(loginRequestDTO.getName(),loginRequestDTO.getEmail());
        if(Objects.isNull(member)){
            Member newMember = memberRepository.save(new Member(loginRequestDTO.getName(),loginRequestDTO.getEmail()));
            return CommonResponse.success(newMember);
        }else{
            return CommonResponse.success(member);
        }

    }

    @Transactional
    public CommonResponse<String> feedback (FeedbackRequestDTO feedbackRequestDTO){
        Member member = memberRepository.findMember(feedbackRequestDTO.getMemberId());
        if(Objects.isNull(member)){
            throw new EntityNotFoundException("존재하지 않는 유저입니다.");
        }else{
            if(Objects.nonNull( feedbackRequestDTO.getFeedback())){
                if(feedbackRequestDTO.getFeedback()) {
                    member.setServingSize(member.getServingSize() + 0.1);
                }else{
                    member.setServingSize(member.getServingSize()-0.1);
                }
            }
        }
        return CommonResponse.success("피드백이 정상적으로 반영되었습니다.");
    }

    @Transactional
    public CommonResponse<String> finish(FinishRequestDTO finishRequestDTO){
        Member member = memberRepository.findMember(finishRequestDTO.getMemberId());
        if(Objects.isNull(member)){
            throw new EntityNotFoundException("존재하지 않는 유저입니다.");
        }else{
            double carbonPledge = member.getCarbonPledge();
            member.setCarbonPledge( carbonPledge + finishRequestDTO.getCarbonPledge());
        }
        return CommonResponse.success("유저 탄소 배출 감소량 업데이트 성공");
    }
}
