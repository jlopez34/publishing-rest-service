package com.ingerencia.rest.publishing.repository.dto;

import com.ingerencia.rest.publishing.gateway.dto.Hit;
import com.opengamma.strata.collect.ArgChecker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Document(collation = "articles")
public class Article implements Serializable {

    @Id
    private String id;
    public List<Hit> hits;

    public static Article of(com.ingerencia.rest.publishing.gateway.dto.Article article) {
        ArgChecker.notNull(article, "article");
        Article dto = new Article();
        BeanUtils.copyProperties(article, dto);
        return dto;
    }

}
