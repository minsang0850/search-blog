package minsang.searchblog.search.domain.service;

import lombok.RequiredArgsConstructor;
import minsang.searchblog.search.infrastructure.SearchClient;
import minsang.searchblog.search.presentation.dto.BlogSearchRequestParam;
import minsang.searchblog.search.presentation.dto.KakaoBlogSearchRequestParam;
import minsang.searchblog.search.domain.model.SearchHistory;
import minsang.searchblog.search.domain.repository.SearchHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService {

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
