package com.example.mongo.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "article")
public class Article implements Serializable {
	
	private static final long serialVersionUID = 6038376999897289219L;

	@Id
	private String id;
	private String title;
	private String body;
	private Author author;
	private Category category;
}
