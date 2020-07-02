package main.services;

import models.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ArticleService {
    private List<Article> articleList = new ArrayList<Article>(Arrays.asList(
            new Article("1", "Java Spring", "Java Spring Description"),
            new Article("2", "Java Spring", "Java Spring Description"),
            new Article("3", "Java Spring", "Java Spring Description")
    ));

    public List<Article> getArticleList() {
        return articleList;
    }

    public Article getArticle(String id) {
        return articleList
                .stream()
                .filter(t -> t.getId().equals(id))
                .findFirst().get();
    }

    public void addArticle(Article model) {
        this.articleList.add(model);
    }

    public void updateArticle(String id, Article model) {
        for (int i = 0; i< articleList.size(); i++) {
            Article article = articleList.get(i);
            if (article.getId().equals(id)){
                articleList.set(i, model);
            }
        }
    }

    public void deleteArticle(String id) {
        articleList.removeIf(a-> a.getId().equals(id));
    }
}
