package com.safetyalarm.safetyAlarm.service;

import com.safetyalarm.safetyAlarm.domain.News;
import com.safetyalarm.safetyAlarm.dto.WriteNewsDto;
import com.safetyalarm.safetyAlarm.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public List<News> findNews() {
        return newsRepository.findAllByOrderByNewsIdDesc();
    }

    public void writeNews(WriteNewsDto writeNewsDto) {
        News news = News.builder()
                .description(writeNewsDto.getDescription())
                .title(writeNewsDto.getTitle())
                .summary(writeNewsDto.getSummary())
                .build();
        newsRepository.save(news);
    }
}
