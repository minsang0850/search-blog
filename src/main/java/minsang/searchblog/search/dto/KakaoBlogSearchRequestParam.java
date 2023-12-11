package minsang.searchblog.search.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KakaoBlogSearchRequestParam {
    String query;
    String sort;
    long page;
    long size;

    public static KakaoBlogSearchRequestParam of(BlogSearchRequestParam param) {

        return KakaoBlogSearchRequestParam.builder()
                                          .query(param.getQuery())
                                          .sort(param.getSort())
                                          .page(param.getPage())
                                          .size(param.getSize())
                                          .build();
    }
}