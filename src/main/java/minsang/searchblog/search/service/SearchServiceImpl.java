package minsang.searchblog.search.service;

import lombok.RequiredArgsConstructor;
import minsang.searchblog.search.client.SearchClient;
import minsang.searchblog.search.entity.SearchKeywordEntity;
import minsang.searchblog.search.repository.KeywordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService{

    private final SearchClient searchClient;
    private final KeywordRepository keywordRepository;

    @Override
    public List<String> getBlogsByKeyword(String keyword) {
        var searchKeywordEntity = new SearchKeywordEntity();
        keywordRepository.save(searchKeywordEntity);
        return searchClient.getBlogByKeyword(keyword);
    }
}
