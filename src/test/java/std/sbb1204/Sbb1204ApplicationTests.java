package std.sbb1204;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import std.sbb1204.article.Article;
import std.sbb1204.article.ArticleRepository;

import java.time.LocalDateTime;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void testJpa() {
        Article q1 = new Article();
        q1.setSubject("첫번째 게시글 입니다");
        q1.setContent("첫번째 내용 입니다");
        q1.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(q1);  // 첫번째 질문 저장

        Article q2 = new Article();
        q2.setSubject("두번째 게시글 입니다.");
        q2.setContent("두번째 내용 입니다");
        q2.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(q2);  // 두번째 질문 저장
    }
}