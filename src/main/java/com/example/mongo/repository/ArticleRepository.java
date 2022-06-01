package com.example.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.document.Article;

public interface ArticleRepository extends MongoRepository<Article, String> {

	List<Article> findByTitleLike(String title);
	List<Article> findByCategoryName(String categoryName);
	List<Article> findByAuthorFirstName(String authorName);
	Article findFirstByIdNotNull();
}
