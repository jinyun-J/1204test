package std.sbb1204.article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  ArticleRepository extends JpaRepository <Article, Integer> {
}