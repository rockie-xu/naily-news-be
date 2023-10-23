package com.rockie.news;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
class NewsController {

    private final NewsService newsService;

    @GetMapping(value = "/get-news", produces = "application/json")
    public List getAllNews() throws IOException {
        return newsService.getNews();
    }
}
