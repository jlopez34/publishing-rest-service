package com.ingerencia.rest.publishing.repository;

import com.ingerencia.rest.publishing.repository.dto.Paper;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PublishingRepository extends MongoRepository<Paper, String> {
    List<Paper> findByObjectIDAndRemoved(String objectID, boolean removed);
    List<Paper> findByRemoved(boolean removed);
}
