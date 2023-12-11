package minsang.searchblog.search.service;

import lombok.RequiredArgsConstructor;
import minsang.searchblog.search.client.SearchClient;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService{

    private final SearchClient searchClient;

    @Override
    public List<String> getBlogsByKeywords(List<String> keywords) {
        return searchClient.getBlogByKeywords(keywords);
    }
}
