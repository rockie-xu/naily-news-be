package com.rockie.news;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MediaDto {

        private String name;
        private List<NewsDto> news;
}
