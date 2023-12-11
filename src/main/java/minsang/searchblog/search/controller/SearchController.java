package minsang.searchblog.search.controller;

import lombok.RequiredArgsConstructor;
import minsang.searchblog.search.dto.BlogSearchRequestParam;
import minsang.searchblog.search.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/search/blog")
    public List<String> getBlogs(BlogSearchRequestParam param){
        if(StringUtils.isEmpty(param.getQuery())){
            return Collections.emptyList();
        }
        return searchService.getBlogsByKeyword(param);
    }
}
