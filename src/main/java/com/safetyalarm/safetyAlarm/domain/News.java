package com.safetyalarm.safetyAlarm.domain;

import com.safetyalarm.safetyAlarm.domain.basicEntity.BasicEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class News extends BasicEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Long newsId;

    private String title;
    private String summary;
    private String description;
}
