package com.rockie.news;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsDto {
    private String title;
    private String url;
}
