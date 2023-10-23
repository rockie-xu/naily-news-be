package com.rockie.news;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("news")
@CrossOrigin
@RequiredArgsConstructor
class NewsController {

    private final NewsService newsService;

    @GetMapping(value = "/tech", produces = "application/json")
    public List<MediaDto> getNewsGeneral() throws IOException {
        return newsService.getNews("general");
    }

    @GetMapping(value = "/general", produces = "application/json")
    public List<MediaDto> getNewsTech() throws IOException {
        return newsService.getNews("tech");
    }
}
