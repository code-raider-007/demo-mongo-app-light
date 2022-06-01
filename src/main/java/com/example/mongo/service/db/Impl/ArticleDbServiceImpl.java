package com.example.mongo.service.db.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mongo.document.Article;
import com.example.mongo.repository.ArticleRepository;
import com.example.mongo.service.db.ArticleDbService;

@Service
public class ArticleDbServiceImpl implements ArticleDbService {
	
	private final ArticleRepository articleRepository;
	
	public ArticleDbServiceImpl(ArticleRepository articleRepository) {
		super();
		this.articleRepository = articleRepository;
	}

	@Override
	public List<Article> findAll() {
		List<Article> articles = new ArrayList<>();
		this.articleRepository.findAll().forEach(article -> {
			articles.add(article);
		});
		return articles;
	}

	@Override
	public Article findById(String id) {
		return this.articleRepository.findById(id).orElse(null);
	}

	@Override
	public Article save(Article article) {
		return this.articleRepository.save(article);
	}

	@Override
	public void delete(Article article) {
		Optional<Article> optional = Optional.ofNullable(this.articleRepository.findById(article.getId()).orElse(null));
		if(optional.isPresent()) {
			this.articleRepository.delete(article);
		}
	}

	@Override
	public List<Article> findByTitleLike(String title) {
		return this.articleRepository.findByTitleLike(title);
	}

	@Override
	public List<Article> findByCategoryName(String categoryName) {
		return this.articleRepository.findByCategoryName(categoryName);
	}

	@Override
	public List<Article> findByAuthorFirstName(String authorName) {
		return this.articleRepository.findByAuthorFirstName(authorName);
	}

	@Override
	public Article findFirstArticle() {
		return this.articleRepository.findFirstByIdNotNull();
	}

}
