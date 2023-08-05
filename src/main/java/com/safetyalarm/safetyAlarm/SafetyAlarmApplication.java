package com.safetyalarm.safetyAlarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SafetyAlarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafetyAlarmApplication.class, args);
	}

}
