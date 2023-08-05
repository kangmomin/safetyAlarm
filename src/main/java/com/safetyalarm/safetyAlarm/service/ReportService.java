package com.safetyalarm.safetyAlarm.service;

import com.safetyalarm.safetyAlarm.common.Util;
import com.safetyalarm.safetyAlarm.domain.Images;
import com.safetyalarm.safetyAlarm.domain.Report;
import com.safetyalarm.safetyAlarm.domain.User;
import com.safetyalarm.safetyAlarm.dto.WriteReportDto;
import com.safetyalarm.safetyAlarm.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;

    public List<Report> getAllReport() {
        List<Report> reports = reportRepository.findAll();

        return reports;
    }

    public Report getOneReport(Long id){
        return reportRepository.findById(id).orElseThrow(
                IllegalAccessError::new
        );
    }

    public List<Report> getReportByUserId() {
        User loginMember = Util.getLoginMember();

        return reportRepository.findAllByCreatedBy(loginMember.getUserId());
    }

    public void writeReport(WriteReportDto writeReportDto) {
        List<Images> images = writeReportDto.getImages().stream().map(e -> {
            Images image = Images.builder()
                    .imageUrl(e)
                    .build();

            return image;
        }).toList();

        Report report = Report.builder()
                .title(writeReportDto.getTitle())
                .description(writeReportDto.getDescription())
                .build();

        report.setImages(images);

        reportRepository.save(report);
    }
}
