package com.safetyalarm.safetyAlarm.controller;

import com.safetyalarm.safetyAlarm.common.Result;
import com.safetyalarm.safetyAlarm.dto.JoinDto;
import com.safetyalarm.safetyAlarm.dto.user.LoginDto;
import com.safetyalarm.safetyAlarm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto) {
        try {
            Map<String, String> token = userService.login(loginDto);

            if (token == null) {
                return ResponseEntity.notFound()
                        .build();
            }

            HttpHeaders headers = new HttpHeaders();

            headers.add("X-Auth-Token", token.get("accessToken"));
            headers.add("X-Refresh-Token", token.get("refreshToken"));

            return ResponseEntity.ok()
                    .headers(headers)
                    .build();
        } catch (UsernameNotFoundException e) {
            return Result.error("password is not match", 404);
        }
    }

    @PostMapping("/join")
    public ResponseEntity join(@RequestBody JoinDto joinDto) {
        userService.join(joinDto);

        return Result.ok(null);
    }
}
