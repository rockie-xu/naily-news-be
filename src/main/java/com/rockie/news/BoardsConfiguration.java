package com.rockie.news;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@PropertySource("classpath:boards.yaml")
public class BoardsConfiguration {

    @Value("${boardName}")
    private String boardName;

    @Value("${icon}")
    private String icon;

    @Value("${feeds}")
    private List<FeedDto> feeds;

}