package com.ingerencia.rest.publishing.service.impl;

import com.ingerencia.rest.publishing.gateway.AlgoliaService;
import com.ingerencia.rest.publishing.gateway.dto.Article;
import com.ingerencia.rest.publishing.model.PublishingResponse;
import com.ingerencia.rest.publishing.repository.PublishingRepository;
import com.ingerencia.rest.publishing.service.PublishingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublishingServiceImpl implements PublishingService {
    private static final Logger LOGGER = Logger.getLogger(PublishingServiceImpl.class);

    @Autowired
    private AlgoliaService algoliaService;

    @Autowired
    private PublishingRepository publishingRepository;

    @Override
    public PublishingResponse searchNews() {
        Optional<List<com.ingerencia.rest.publishing.repository.dto.Article>> articles =
                Optional.of(publishingRepository.findAll());
        if(articles.isPresent()){

        }
        return null;
    }

    @Override
    public void upgradeNews() {
        Optional<Article> articles = Optional.ofNullable(algoliaService.upgradeArticle());
        if(articles.isPresent()){
             publishingRepository.save(com.ingerencia.rest.publishing.repository.dto.Article.of(articles.get()));
        }
    }
}
