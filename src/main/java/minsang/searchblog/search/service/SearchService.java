package minsang.searchblog.search.service;

import java.util.List;

public interface SearchService {

    List<String> getBlogsByKeyword(String keywords);
}
