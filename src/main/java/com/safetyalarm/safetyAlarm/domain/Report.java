package com.safetyalarm.safetyAlarm.domain;

import com.safetyalarm.safetyAlarm.domain.basicEntity.BasicEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report extends BasicEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long reportId;

    private String title;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Images> images;

    public void setImages(List<Images> images) {
        images.forEach(e -> {
            e.setReport(this);
        });

        this.images = images;
    }
}
