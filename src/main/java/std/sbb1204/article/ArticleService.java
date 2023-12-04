package std.sbb1204.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import std.sbb1204.DataNotFoundException;
import std.sbb1204.user.SiteUser;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return this.articleRepository.findAll();
    }

    public Article getArticle(Integer id) {
        Optional<Article> article = this.articleRepository.findById(id);
        if (article.isPresent()) {
            return article.get();
        } else {
            throw new DataNotFoundException("article not found");
        }
    }

    public void create(String subject, String content, SiteUser user) {
        Article q = new Article();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(user);
        this.articleRepository.save(q);
    }

    public void modify(Article article, String subject, String content) {
        article.setSubject(subject);
        article.setContent(content);
        article.setModifyDate(LocalDateTime.now());
        this.articleRepository.save(article);
    }
    public void delete(Article article) {
        this.articleRepository.delete(article);
    }
}