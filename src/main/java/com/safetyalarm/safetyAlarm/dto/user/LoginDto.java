package com.safetyalarm.safetyAlarm.dto.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginDto {

    @NotEmpty
    @Size(min = 5)
    private String email;

    @NotEmpty @Size(min = 8)
    private String password;
}