package com.example.mongo.service.db;

import java.util.List;

import com.example.mongo.document.Article;

public interface ArticleDbService {

	List<Article> findAll();
	Article findById(String id);
	Article save(Article article);
	void delete(Article article);
	
	List<Article> findByTitleLike(String title);
	List<Article> findByCategoryName(String categoryName);
	List<Article> findByAuthorFirstName(String authorName);
	Article findFirstArticle();
}
