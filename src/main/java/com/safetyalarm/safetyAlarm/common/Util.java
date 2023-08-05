package com.safetyalarm.safetyAlarm.common;

import com.safetyalarm.safetyAlarm.config.security.userDetails.PrincipalDetails;
import com.safetyalarm.safetyAlarm.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Util {

    public static User getLoginMember() {
        try {
            PrincipalDetails user = (PrincipalDetails) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();
            return user.getUser();
        } catch (Exception e) {
            return null;
        }
    }
}
