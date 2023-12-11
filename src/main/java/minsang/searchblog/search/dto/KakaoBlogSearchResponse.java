package minsang.searchblog.search.dto;

import java.util.List;

public record KakaoBlogSearchResponse (
    KakaoMeta meta,
    List<KakaoDocument> documents
){
}
