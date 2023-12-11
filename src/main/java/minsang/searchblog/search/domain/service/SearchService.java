package minsang.searchblog.search.domain.service;

import minsang.searchblog.search.presentation.dto.BlogSearchRequestParam;
import minsang.searchblog.search.domain.model.SearchHistory;

import java.util.List;

public interface SearchService {

    List<String> getBlogsByKeyword(BlogSearchRequestParam param);

    List<SearchHistory> getTop10SearchKeywords();
}
