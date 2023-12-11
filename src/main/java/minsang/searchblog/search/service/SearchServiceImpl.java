package minsang.searchblog.search.service;

import lombok.RequiredArgsConstructor;
import minsang.searchblog.search.client.SearchClient;
import minsang.searchblog.search.dto.BlogSearchRequestParam;
import minsang.searchblog.search.dto.KakaoBlogSearchRequestParam;
import minsang.searchblog.search.entity.SearchHistory;
import minsang.searchblog.search.repository.SearchHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService{

    private final SearchClient searchClient;
    private final SearchHistoryRepository searchHistoryRepository;

    @Override
    public List<String> getBlogsByKeyword(BlogSearchRequestParam param) {
        saveOrUpdateSearchHistory(param.getQuery());
        return searchClient.getBlogByKeyword(KakaoBlogSearchRequestParam.of(param));
    }

    @Transactional
    public void saveOrUpdateSearchHistory(String keyword) {
        SearchHistory searchHistory = searchHistoryRepository.findByKeyword(keyword);

        if (searchHistory == null) {
            searchHistory = new SearchHistory();
            searchHistory.setKeyword(keyword);
        } else {
            searchHistory.setSearchCount(searchHistory.getSearchCount() + 1);
        }

        searchHistory.setTimestamp(LocalDateTime.now());

        searchHistoryRepository.save(searchHistory);
    }

    @Override
    public List<SearchHistory> getTop10SearchKeywords() {
        return searchHistoryRepository.findTop10ByOrderBySearchCountDesc();
    }
}
