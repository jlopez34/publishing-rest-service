package com.ingerencia.rest.publishing.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class ConfigurationProperties {

    @Value("${services.algolia.endpoint}")
    private String AlgoliaServiceEndPoint;

    @Value("${services.algolia.headers.name}")
    private String headerName;

    @Value("${services.algolia.headers.value}")
    private String headerValue;
}
