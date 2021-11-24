package com.ingerencia.rest.publishing.service;

import com.ingerencia.rest.publishing.model.PublishingResponse;

import java.util.List;

public interface PublishingService {
    List<PublishingResponse> searchNews();

    void upgradeNews();

    boolean removeArticleById(String id);
}
