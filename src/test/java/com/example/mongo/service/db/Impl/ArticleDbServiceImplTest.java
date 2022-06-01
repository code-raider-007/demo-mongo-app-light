package com.example.mongo.service.db.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mongo.document.Article;
import com.example.mongo.document.Author;
import com.example.mongo.document.Category;
import com.example.mongo.util.ArticleTestHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class ArticleDbServiceImplTest {
	
	private final String title = "Test Article";
	private final String categoryName = "Spring Boot 2";
	private final String authorFirstName = "Article";
	
	Article article;
	
	@Autowired
	private ArticleDbServiceImpl articleDbServiceImpl;

	@BeforeEach
	void setUp() throws Exception {
		
		if(this.article == null) {
			Author author = ArticleTestHelper.generateAuthor(authorFirstName, "Tester", "Test");
			Category category = ArticleTestHelper.generateCategory(categoryName);
			this.article = ArticleTestHelper.generateArticle(title, "Article body", author, category);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		if(this.article != null) {
			this.article = null;
		}
	}

	@Test
	void testFindAll() throws Exception {
		List<Article> articles = this.articleDbServiceImpl.findAll();
		ObjectMapper objectMapper = new ObjectMapper();
		assertNotNull(articles);
		assertTrue(articles.size() > 0);
		
		String values = objectMapper.writeValueAsString(articles);
		System.out.println(values);
	}

	@Test
	void testFindById() {
		List<Article> articles = this.articleDbServiceImpl.findAll();
		
		Article singleArticle = this.articleDbServiceImpl.findById(articles.get(0).getId());
		
		assertNotNull(singleArticle);
	}

	@Test
	void testSave() throws Exception {
		
		System.out.println(this.article.toString());
		
		Article articleToBeSaved = this.articleDbServiceImpl.save(this.article);
		assertNotNull(articleToBeSaved);
		assertEquals(articleToBeSaved.getTitle(), this.title);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String value = objectMapper.writeValueAsString(articleToBeSaved);
		System.out.println(value);
		
		this.articleDbServiceImpl.delete(articleToBeSaved);
	}

	@Test
	void testDelete() {
		Article articleToBeSaved = this.articleDbServiceImpl.save(this.article);
		assertNotNull(articleToBeSaved);
		assertEquals(articleToBeSaved.getTitle(), this.title);
		
		this.articleDbServiceImpl.delete(articleToBeSaved);
		articleToBeSaved = this.articleDbServiceImpl.findById(articleToBeSaved.getId());
		assertNull(articleToBeSaved);
	}

	@Test
	void testFindByTitleLike() {
		Article articleToBeSaved = this.articleDbServiceImpl.save(this.article);
		
		List<Article> articles = this.articleDbServiceImpl.findByTitleLike("Test");
		assertNotNull(articles);
		assertTrue(articles.size() > 0);
		
		this.articleDbServiceImpl.delete(articleToBeSaved);
		articleToBeSaved = this.articleDbServiceImpl.findById(articleToBeSaved.getId());
		assertNull(articleToBeSaved);
	}

	@Test
	void testFindByCategoryName() {
		Article articleToBeSaved = this.articleDbServiceImpl.save(this.article);
		
		List<Article> articles = this.articleDbServiceImpl.findByCategoryName(this.categoryName);
		assertNotNull(articles);
		assertTrue(articles.size() > 0);
		
		this.articleDbServiceImpl.delete(articleToBeSaved);
		articleToBeSaved = this.articleDbServiceImpl.findById(articleToBeSaved.getId());
		assertNull(articleToBeSaved);
	}

	@Test
	void testFindByAuthorFirstName() {
		Article articleToBeSaved = this.articleDbServiceImpl.save(this.article);
		
		List<Article> articles = this.articleDbServiceImpl.findByAuthorFirstName(this.authorFirstName);
		assertNotNull(articles);
		assertTrue(articles.size() > 0);
		
		this.articleDbServiceImpl.delete(articleToBeSaved);
		articleToBeSaved = this.articleDbServiceImpl.findById(articleToBeSaved.getId());
		assertNull(articleToBeSaved);
	}

	@Test
	void testFindFirstArticle() {
		
		Article article1 = this.articleDbServiceImpl.findFirstArticle();
		assertNotNull(article1);
		
	}

}
