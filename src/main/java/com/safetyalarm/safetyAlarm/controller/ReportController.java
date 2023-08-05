package com.safetyalarm.safetyAlarm.controller;

import com.safetyalarm.safetyAlarm.common.Result;
import com.safetyalarm.safetyAlarm.domain.Report;
import com.safetyalarm.safetyAlarm.dto.WriteReportDto;
import com.safetyalarm.safetyAlarm.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/reports")
    public ResponseEntity reports() {
        List<Report> reports = reportService.getAllReport();

        return Result.ok(reports);
    }

    @GetMapping("/reports/{id}")
    public ResponseEntity reportOne(@PathVariable Long id) {
        Report report = reportService.getOneReport(id);
        return Result.ok(report);
    }


    @PostMapping("/my-report")
    public ResponseEntity myReports() {
        List<Report> reportByUserId = reportService.getReportByUserId();

        return Result.ok(reportByUserId);
    }

    @PostMapping("/write/report")
    public ResponseEntity writeReport(@RequestBody WriteReportDto writeReportDto) {
        reportService.writeReport(writeReportDto);

        return Result.ok(null);
    }
}
