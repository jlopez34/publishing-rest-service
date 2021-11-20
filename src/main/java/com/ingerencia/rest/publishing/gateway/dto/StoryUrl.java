package com.ingerencia.rest.publishing.gateway.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StoryUrl {
    public String value;
    public String matchLevel;
    public List<Object> matchedWords;
}