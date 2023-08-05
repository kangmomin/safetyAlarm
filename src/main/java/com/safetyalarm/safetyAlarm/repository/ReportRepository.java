package com.safetyalarm.safetyAlarm.repository;

import com.safetyalarm.safetyAlarm.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findAllByCreatedBy(Long createdBy);
}
