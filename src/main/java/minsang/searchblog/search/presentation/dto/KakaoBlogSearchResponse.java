package minsang.searchblog.search.presentation.dto;

import java.util.List;

public record KakaoBlogSearchResponse (
    KakaoMeta meta,
    List<KakaoDocument> documents
){
}
