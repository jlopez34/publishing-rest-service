package com.ingerencia.rest.publishing.gateway.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Hit {
    public Date created_at;
    public Object title;
    public Object url;
    public String author;
    public Object points;
    public Object story_text;
    public String comment_text;
    public Object num_comments;
    public int story_id;
    public String story_title;
    public String story_url;
    public int parent_id;
    public int created_at_i;
    public List<String> _tags;
    public String objectID;
    public HighlightResult _highlightResult;
}
