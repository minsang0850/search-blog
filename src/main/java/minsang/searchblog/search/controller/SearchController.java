package minsang.searchblog.search.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import minsang.searchblog.search.dto.BlogSearchRequestParam;
import minsang.searchblog.search.entity.SearchHistory;
import minsang.searchblog.search.service.SearchService;
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
