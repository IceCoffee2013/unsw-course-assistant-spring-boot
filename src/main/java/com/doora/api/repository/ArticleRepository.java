package com.doora.api.repository;

import com.doora.api.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by langley on 8/5/17.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByTitleContaining(String title);

}