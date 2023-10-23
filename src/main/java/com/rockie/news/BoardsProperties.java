package com.rockie.news;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "boards")
public class BoardsProperties {

    private List<BoardBO> boards;

    @Data
    public static class BoardBO {
        private String boardName;
        private String icon;
        private List<FeedBO> feeds;
    }

    @Data
    public static class FeedBO {
        private String feedName;
        private String url;
    }
}