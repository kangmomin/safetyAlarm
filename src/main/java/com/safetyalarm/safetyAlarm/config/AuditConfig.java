package com.safetyalarm.safetyAlarm.config;

import com.safetyalarm.safetyAlarm.common.Util;
import com.safetyalarm.safetyAlarm.domain.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class AuditConfig implements AuditorAware<Long> {

    @NonNull
    @Override
    public Optional<Long> getCurrentAuditor() {
        User loginMember = Util.getLoginMember();

        if (loginMember == null) return Optional.empty();

        return Optional.ofNullable(loginMember.getUserId());
    }
}