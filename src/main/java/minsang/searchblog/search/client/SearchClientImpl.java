package minsang.searchblog.search.client;

import minsang.searchblog.search.dto.KakaoBlogSearchResponse;
import minsang.searchblog.search.dto.KakaoDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Repository
public class SearchClientImpl implements SearchClient {

    private static final String KAKAO_API = "https://dapi.kakao.com/v2/search/blog";

    private final String key;
    private final RestTemplate restTemplate;

    public SearchClientImpl(@Value("${kakao.api.key}") String key, RestTemplate restTemplate) {
        this.key = key;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<String> getBlogByKeyword(String keyword) {
        var httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "KakaoAK " + key);
        var queryString = "";
        queryString = "?query=" + URLEncoder.encode(keyword, StandardCharsets.UTF_8);

        var entity = new HttpEntity<>(httpHeaders);

        var url = URI.create(KAKAO_API + queryString);
        var response = restTemplate.exchange(url, HttpMethod.GET, entity, KakaoBlogSearchResponse.class).getBody();
        return response.documents()
                       .stream()
                       .map(KakaoDocument::url)
                       .toList();
    }
}
