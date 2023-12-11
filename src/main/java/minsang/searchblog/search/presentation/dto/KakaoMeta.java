package minsang.searchblog.search.presentation.dto;

public record KakaoMeta(
    long total_count,
    long pageable_count,
    Boolean is_end
) {
}
