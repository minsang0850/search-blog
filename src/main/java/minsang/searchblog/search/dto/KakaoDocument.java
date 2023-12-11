package minsang.searchblog.search.dto;

public record KakaoDocument(
    String title,
    String contents,
    String url,
    String blogname,
    String thumbnail,
    String dateTime
) {
}
