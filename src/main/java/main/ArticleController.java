package main;

import models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/articles")
    public List<Article> getArticles() {
        return articleService.getArticleList();
    }

    @RequestMapping("/articles/{id}")
    public Article getArticle(@PathVariable String id) {
        return articleService.getArticle(id);
    }

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public void addArticle(@RequestBody Article model) {
        this.articleService.addArticle(model);
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.PUT)
    public void updateArticle(@RequestBody Article model, @PathVariable String id) {
        this.articleService.updateArticle(id, model);
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    public void deleteArticle(@PathVariable String id) {
        this.articleService.deleteArticle(id);
    }
}
