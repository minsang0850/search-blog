package minsang.searchblog.search.service;

import minsang.searchblog.search.dto.BlogSearchRequestParam;

import java.util.List;

public interface SearchService {

    List<String> getBlogsByKeyword(BlogSearchRequestParam param);
}
