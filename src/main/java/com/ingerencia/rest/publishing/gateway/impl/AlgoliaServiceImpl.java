package com.ingerencia.rest.publishing.gateway.impl;

import com.ingerencia.rest.publishing.config.ConfigurationProperties;
import com.ingerencia.rest.publishing.exception.AlgoliaException;
import com.ingerencia.rest.publishing.gateway.AlgoliaService;
import com.ingerencia.rest.publishing.gateway.dto.Article;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Repository
public class AlgoliaServiceImpl implements AlgoliaService {

    private static final Logger LOGGER = Logger.getLogger(AlgoliaServiceImpl.class);

    @Autowired
    private ConfigurationProperties properties;

    public Article upgradeArticle() {
        Article article = null;
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add(properties.getHeaderName(), properties.getHeaderValue());
            HttpEntity entity = new HttpEntity(headers);

            ResponseEntity<Article> response = restTemplate.exchange(properties.getAlgoliaServiceEndPoint(), HttpMethod.GET, entity, Article.class);

            if (response.getStatusCodeValue() == 200) {
                article = response.getBody();
            }
        } catch (AlgoliaException exception) {
            LOGGER.error("Fail occurred trying to consume algolia service: ", exception);
            throw new AlgoliaException(exception.getMessage());
        }
        return article;
    }
}
