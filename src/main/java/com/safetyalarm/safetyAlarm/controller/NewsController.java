package com.safetyalarm.safetyAlarm.controller;

import com.safetyalarm.safetyAlarm.common.Result;
import com.safetyalarm.safetyAlarm.dto.WriteNewsDto;
import com.safetyalarm.safetyAlarm.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news")
    public ResponseEntity findNews() {
        return Result.ok(newsService.findNews());
    }

    @PostMapping("/write/news")
    public ResponseEntity writeNews(@RequestBody WriteNewsDto writeNewsDto) {
        newsService.writeNews(writeNewsDto);
        return Result.ok(null);
    }
}
