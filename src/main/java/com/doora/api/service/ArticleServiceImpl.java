package com.doora.api.service;

import com.doora.api.model.Article;
import com.doora.api.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by langley on 8/10/17.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article addArticle(Article article) {
        return this.articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Article article) {
        return this.articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        this.articleRepository.delete(id);
    }

    @Override
    public Article findArticleById(Long id) {
        return this.articleRepository.findOne(id);
    }

    @Override
    public List<Article> findArticleByTitle(String title) {
        return this.articleRepository.findByTitleContaining(title);
    }

    @Override
    public List<Article> findAllArticle() {
        return this.articleRepository.findAll();
    }
}
