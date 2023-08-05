package com.safetyalarm.safetyAlarm.dto;

import lombok.*;

@Data
@Builder @AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JoinDto {

    private String email;
    private String password;
}
