package com.rockie.news;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final BoardsProperties boardsConfiguration;

    List<MediaDto> getNews(String category) {

        BoardsProperties.BoardBO board = getBoard(category);

        List<MediaDto> mediaDtoList = new ArrayList<>();

        board.getFeeds().forEach(feed -> {
            System.out.println(feed.getFeedName());
            System.out.println(feed.getUrl());

            try {
                URL feedSource = new URL(feed.getUrl());
                SyndFeedInput input = new SyndFeedInput();
                SyndFeed syndFeed = input.build(new XmlReader(feedSource));

                List<NewsDto> feeds = new ArrayList<>();
                syndFeed.getEntries().forEach(entry -> feeds.add(new NewsDto(entry.getTitle(), entry.getLink())));
                mediaDtoList.add(new MediaDto(feed.getFeedName(), feeds));
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        return mediaDtoList;
    }

    private BoardsProperties.BoardBO getBoard(String category) {
        return boardsConfiguration.getBoards().stream()
                .filter(board -> board.getBoardName().equals(category))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Board not found"));
    }
}
