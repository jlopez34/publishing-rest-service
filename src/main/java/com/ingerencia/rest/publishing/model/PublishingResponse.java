package com.ingerencia.rest.publishing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class PublishingResponse {

    private String id;
    public Date created_at;
    public String author;
    public String comment_text;
    public int story_id;
    public String story_title;
    public String story_url;
    public String objectID;
    public boolean removed;

    public PublishingResponse() {

    }
}
