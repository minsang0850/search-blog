package minsang.searchblog.search.client;

import java.util.List;

public interface SearchClient {
    List<String> getBlogByKeyword(String keywords);
}
