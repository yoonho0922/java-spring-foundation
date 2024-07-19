package com.yoon.foundation.dto.member;

import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginRequestDTO {
    private  String name;
    private String email;

}
