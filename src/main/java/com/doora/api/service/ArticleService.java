package com.doora.api.service;


import com.doora.api.model.Article;
import java.util.List;

public interface ArticleService {

    Article addArticle(Article article);

    Article updateArticle(Article article);

    void deleteArticle(Long id);

    Article findArticleById(Long id);

    List<Article> findArticleByTitle(String title);

    List<Article> findAllArticle();

}