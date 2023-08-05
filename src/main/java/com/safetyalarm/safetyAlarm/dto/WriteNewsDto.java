package com.safetyalarm.safetyAlarm.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WriteNewsDto {

    private String title;
    private String description;
    private String summary;
}
