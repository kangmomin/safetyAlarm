package com.safetyalarm.safetyAlarm.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WriteReportDto {

    private String title;
    private String description;
    private List<String> images;
}
