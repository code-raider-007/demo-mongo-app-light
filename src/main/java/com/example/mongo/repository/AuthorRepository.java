package com.example.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.document.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {

}
