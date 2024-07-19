package com.yoon.foundation.dto.member;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FeedbackRequestDTO {
    Long memberId;
    Boolean feedback;
}
