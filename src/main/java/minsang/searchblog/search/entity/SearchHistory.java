package minsang.searchblog.search.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class SearchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String keyword;

    private long searchCount;

    private LocalDateTime timestamp;

    public static SearchHistory of(String keyword) {
        var entity = new SearchHistory();
        entity.setKeyword(keyword);
        entity.setTimestamp(LocalDateTime.now());
        return entity;
    }
}
