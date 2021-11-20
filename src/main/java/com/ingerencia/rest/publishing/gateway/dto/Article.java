package com.ingerencia.rest.publishing.gateway.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Article {
    public List<Hit> hits;
    public int nbHits;
    public int page;
    public int nbPages;
    public int hitsPerPage;
    public boolean exhaustiveNbHits;
    public boolean exhaustiveTypo;
    public String query;
    public String params;
    public RenderingContent renderingContent;
    public int processingTimeMS;
}
