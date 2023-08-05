package com.safetyalarm.safetyAlarm.config.security.userDetails;

import com.safetyalarm.safetyAlarm.domain.User;
import com.safetyalarm.safetyAlarm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);

        if (user.isEmpty()) throw new UsernameNotFoundException("user not found");

        return new PrincipalDetails(user.get());
    }
}
