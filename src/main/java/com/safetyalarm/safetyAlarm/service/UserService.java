package com.safetyalarm.safetyAlarm.service;

import com.safetyalarm.safetyAlarm.config.security.jwt.JwtConfig;
import com.safetyalarm.safetyAlarm.domain.User;
import com.safetyalarm.safetyAlarm.dto.JoinDto;
import com.safetyalarm.safetyAlarm.dto.user.LoginDto;
import com.safetyalarm.safetyAlarm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtConfig jwtConfig;

    // null를 리턴하면 계정이 없다.
    public Map<String, String> login(LoginDto loginDto) {
        Optional<User> user = userRepository.findByEmail(loginDto.getEmail());
        if (user.isEmpty()) return null;

        if (!passwordEncoder.matches(loginDto.getPassword(), user.get().getPassword()))
            throw new UsernameNotFoundException("비밀번호가 일치하지 않습니다.");

        String accessToken = jwtConfig.createToken(user.get().getEmail());
        String refreshToken = jwtConfig.createRefreshToken(user.get().getEmail());

        return Map.of("accessToken", accessToken,"refreshToken", refreshToken);
    }

    public void join(JoinDto joinDto) {
        String encodedPassword = passwordEncoder.encode(joinDto.getPassword());

        User user = User.builder()
                .email(joinDto.getEmail())
                .password(encodedPassword)
                .build();

        userRepository.save(user);
    }
}
