package minsang.searchblog.search.infrastructure;

import minsang.searchblog.search.presentation.dto.KakaoBlogSearchRequestParam;

import java.util.List;

public interface SearchClient {
    List<String> getBlogByKeyword(KakaoBlogSearchRequestParam keywords);
}
