package com.ingerencia.rest.publishing.service;

import com.ingerencia.rest.publishing.model.PublishingResponse;

public interface PublishingService {
    PublishingResponse searchNews();

    void upgradeNews();
}
