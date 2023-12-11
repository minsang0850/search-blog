package minsang.searchblog.search.dto;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.Data;

import static org.apache.commons.lang3.StringUtils.defaultString;
import static org.apache.commons.lang3.math.NumberUtils.toLong;

@Builder
@Data
public class BlogSearchRequestParam {
    private static final String DEFAULT_SORT_METHOD = "accuracy";
    private static final long DEFAULT_PAGE = 1;
    private static final long DEFAULT_SIZE = 10;

    String query;
    String sort;
    long page;
    long size;

    public static BlogSearchRequestParam of(HttpServletRequest request) {
        var sb = BlogSearchRequestParam.builder();
        sb.query(defaultString(request.getParameter("query")));
        sb.sort(defaultString(request.getParameter("sort"), DEFAULT_SORT_METHOD));
        sb.page(toLong(request.getParameter("page"), DEFAULT_PAGE));
        sb.size(toLong(request.getParameter("size"), DEFAULT_SIZE));
        return sb.build();
    }
}
