package com.yoon.foundation.dto.member;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SatietyRequestDTO {
    private Long memberId;
    private Integer satiety;
}
