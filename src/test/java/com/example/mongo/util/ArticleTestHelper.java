package com.example.mongo.util;

import java.util.UUID;

import com.example.mongo.document.Article;
import com.example.mongo.document.Author;
import com.example.mongo.document.Category;

public class ArticleTestHelper {

	public static Article generateArticle(String title, String articleBody, Author author, Category category) {
		
		return Article.builder()
				.id(UUID.randomUUID().toString())
				.title(title)
				.body(articleBody)
				.author(author)
				.category(category)
				.build();
	}
	
	public static Author generateAuthor(String firstName, String lastName, String alias) {
		return Author.builder()
				.id(UUID.randomUUID().toString())
				.firstName(firstName)
				.lastName(lastName)
				.alias(alias)
				.build();
	}
	
	public static Category generateCategory(String name) {
		return Category.builder()
				.id(UUID.randomUUID().toString())
				.name(name)
				.build();
	}
}
