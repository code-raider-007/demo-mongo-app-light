package com.example.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.document.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
