package minsang.searchblog.search.presentation.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import minsang.searchblog.search.presentation.dto.BlogSearchRequestParam;
import minsang.searchblog.search.domain.model.SearchHistory;
import minsang.searchblog.search.domain.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/search/blog")
    public List<String> getBlogs(HttpServletRequest request){
        var param = BlogSearchRequestParam.of(request);
        if(StringUtils.isEmpty(param.getQuery())){
            return Collections.emptyList();
        }
        return searchService.getBlogsByKeyword(param);
    }

    @GetMapping("/keywords")
    public List<SearchHistory> getKeywords(){
        return searchService.getTop10SearchKeywords();
    }
}
