package com.ingerencia.rest.publishing.gateway.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HighlightResult {
    public Author author;
    public CommentText comment_text;
    public StoryTitle story_title;
    public StoryUrl story_url;
}
