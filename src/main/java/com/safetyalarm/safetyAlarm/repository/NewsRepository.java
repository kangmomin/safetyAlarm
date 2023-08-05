package com.safetyalarm.safetyAlarm.repository;

import com.safetyalarm.safetyAlarm.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllByOrderByNewsIdDesc();
}
