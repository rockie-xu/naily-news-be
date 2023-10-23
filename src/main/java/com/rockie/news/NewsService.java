package com.rockie.news;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NewsService {

    private String mediaUrl = "https://meduza.io/rss/all";

    private final BoardsConfiguration boardsConfiguration;

    List getNews() throws IOException {
        URL feedSource = new URL(mediaUrl);
        SyndFeedInput input = new SyndFeedInput();
        try {
            SyndFeed feed = input.build(new XmlReader(feedSource));
            List<Map<String, String>> news = new ArrayList<>();
            feed.getEntries().forEach(entry -> {
                Map<String, String> newsItem = new HashMap<>();
                newsItem.put("title", entry.getTitle());
                newsItem.put("url", entry.getLink());
                news.add(newsItem);
            });
            return news;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return List.of();
    }
}
