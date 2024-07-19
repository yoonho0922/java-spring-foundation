package com.yoon.foundation.dto.member;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FinishRequestDTO {
    private Long memberId;
    private double carbonPledge;

}
