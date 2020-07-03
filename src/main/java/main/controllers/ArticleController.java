package main.controllers;

import main.services.ArticleService;
import models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/articles")
    public List<Article> getArticles() {
        return articleService.getArticleList();
    }

    @RequestMapping("/articles/{id}")
    public Article getArticle(@PathVariable(required = true) String id) {
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

    //http://localhost:3002/?articleId=2
    @GetMapping
    public List<Article> getAllArticle(@RequestParam(required = false) String articleId) {
        if (articleId != null) {
            return articleService.getArticleList().stream()
                    .filter(order -> articleId.equals(order.getId()))
                    .collect(Collectors.toList());
        }

        return articleService.getArticleList();
    }
}

