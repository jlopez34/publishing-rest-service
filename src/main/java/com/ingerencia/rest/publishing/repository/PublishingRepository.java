package com.ingerencia.rest.publishing.repository;

import com.ingerencia.rest.publishing.repository.dto.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublishingRepository extends MongoRepository<Article, String> {
}
