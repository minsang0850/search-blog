package minsang.searchblog.search.repository;

import minsang.searchblog.search.entity.SearchKeywordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<SearchKeywordEntity, Long> {
}
