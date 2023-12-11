package minsang.searchblog.search.domain.repository;

import minsang.searchblog.search.domain.model.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {

    SearchHistory findByKeyword(String keyword);

    // 많이 검색된 상위 10개 키워드 조회
    List<SearchHistory> findTop10ByOrderBySearchCountDesc();
}
