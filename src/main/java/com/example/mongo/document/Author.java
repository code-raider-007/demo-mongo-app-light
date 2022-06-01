package com.example.mongo.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "author")
public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4289498747380412335L;
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String alias;

}
