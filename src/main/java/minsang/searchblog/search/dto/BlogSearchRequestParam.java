package minsang.searchblog.search.dto;

import lombok.Data;

@Data
public class BlogSearchRequestParam {
    String query;
    String sort;
    long page;
    long size;
}
