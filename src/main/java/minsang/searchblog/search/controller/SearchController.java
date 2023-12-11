package minsang.searchblog.search.controller;

import lombok.RequiredArgsConstructor;
import minsang.searchblog.search.service.SearchService;
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
    public List<String> getBlogs(@RequestParam(required = false, value = "keywords") List<String> keywords){
        if(CollectionUtils.isEmpty(keywords)){
            return Collections.emptyList();
        }
        return searchService.getBlogsByKeywords(keywords);
    }
}
