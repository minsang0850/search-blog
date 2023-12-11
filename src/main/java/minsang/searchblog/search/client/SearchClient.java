package minsang.searchblog.search.client;

import minsang.searchblog.search.dto.BlogSearchRequestParam;
import minsang.searchblog.search.dto.KakaoBlogSearchRequestParam;

import java.util.List;

public interface SearchClient {
    List<String> getBlogByKeyword(KakaoBlogSearchRequestParam keywords);
}
