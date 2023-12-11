package minsang.searchblog.search.dto;

public record KakaoMeta(
    long total_count,
    long pageable_count,
    Boolean is_end
) {
}
