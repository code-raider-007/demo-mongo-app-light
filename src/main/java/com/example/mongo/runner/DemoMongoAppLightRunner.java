package com.example.mongo.runner;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.mongo.document.Article;
import com.example.mongo.document.Author;
import com.example.mongo.document.Category;
import com.example.mongo.service.db.ArticleDbService;

@Component
public class DemoMongoAppLightRunner implements CommandLineRunner {
	
	private final ArticleDbService articleDbService;
	
	public DemoMongoAppLightRunner(ArticleDbService articleDbService) {
		super();
		this.articleDbService = articleDbService;
	}

	@Override
	public void run(String... args) throws Exception {
		this.saveArticle();
	}
	
	private void saveArticle() {
		
		Article article = this.articleDbService.findFirstArticle();
		if(article == null) {
			Author author = this.generateAuthor("James", "Kirk", "Jim");
			Category category = this.generateCategory("Spring Boot");
			
			this.articleDbService.save(this.generateArticle("First article", "Lopsum lorum, etc...", author, category));
			this.articleDbService.save(this.generateArticle("Second article", "Of mice and men", author, category));
			this.articleDbService.save(this.generateArticle("Third article", "All we have to fear is fear itself", author, category));
		}
	}
	
	private Article generateArticle(String title, String articleBody, Author author, Category category) {
		
		return Article.builder()
				.id(UUID.randomUUID().toString())
				.title(title)
				.body(articleBody)
				.author(author)
				.category(category)
				.build();
	}
	
	private Author generateAuthor(String firstName, String lastName, String alias) {
		return Author.builder()
				.id(UUID.randomUUID().toString())
				.firstName(firstName)
				.lastName(lastName)
				.alias(alias)
				.build();
	}
	
	private Category generateCategory(String name) {
		return Category.builder()
				.id(UUID.randomUUID().toString())
				.name(name)
				.build();
	}

}
