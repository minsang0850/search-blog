package minsang.searchblog.search.service;

import minsang.searchblog.search.dto.BlogSearchRequestParam;
import minsang.searchblog.search.entity.SearchHistory;

import java.util.List;

public interface SearchService {

    List<String> getBlogsByKeyword(BlogSearchRequestParam param);

    List<SearchHistory> getTop10SearchKeywords();
}
