package com.doora.api.controllers;

import com.doora.api.model.Article;
import com.doora.api.model.Question;
import com.doora.api.model.User;
import com.doora.api.service.ArticleService;
import com.doora.api.service.QuestionService;
import com.doora.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by langley on 13/9/17.
 */
@RestController
@RequestMapping("/api/article")
public class ExperienceController {

    private final ArticleService articleService;
    private final UserService userService;

    @Autowired
    public ExperienceController(ArticleService articleService, UserService userService) {
        this.articleService = articleService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllArticles(@RequestParam(value = "searchText", required = false) String searchText,
                                            HttpServletRequest httpServletRequest) {

        List<Article> articles = new ArrayList<>();
        if (searchText != null && !searchText.isEmpty()) {
            System.out.println("query article: " + searchText);
            articles = articleService.findArticleByTitle(searchText);
        } else {
            articles = articleService.findAllArticle();
        }
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getArticleById(@PathVariable Long id) {
        Article article = articleService.findArticleById(id);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewArticle(@RequestBody Article article) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(username).get();
        article.setAuthor(user.getNickname());
        article.setPostTime(new Date());
        Article newArticle = articleService.addArticle(article);
        return new ResponseEntity<>(newArticle, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateArticle(@RequestBody Article article) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(username).get();
        article.setAuthor(user.getNickname());
        article.setPostTime(new Date());
        Article newArticle = articleService.addArticle(article);
        return new ResponseEntity<>(newArticle, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteArticleById(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
