package com.example.mongo.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "category")
public class Category implements Serializable{
	
	private static final long serialVersionUID = 812788140471364088L;

	@Id
	private String id;
	private String name;
}
