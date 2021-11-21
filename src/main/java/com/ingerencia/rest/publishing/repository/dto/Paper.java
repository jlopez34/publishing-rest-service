package com.ingerencia.rest.publishing.repository.dto;

import com.ingerencia.rest.publishing.model.PublishingResponse;
import com.opengamma.strata.collect.ArgChecker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@Document(collection = "article")
public class Paper implements Serializable {

    @Id
    private String id;

    public Date created_at;
    public String author;
    public String comment_text;
    public int story_id;
    public String story_title;
    public String story_url;
    public String objectID;
    public boolean removed;

    public Paper() {
    }

    public static Paper of(com.ingerencia.rest.publishing.gateway.dto.Hit article) {
        ArgChecker.notNull(article, "article");
        Paper dto = new Paper();
        BeanUtils.copyProperties(article, dto);
        return dto;
    }

    public static PublishingResponse ofModel(Paper paper) {
        ArgChecker.notNull(paper, "paper");
        PublishingResponse dto = new PublishingResponse();
        BeanUtils.copyProperties(paper, dto);
        return dto;
    }

}
