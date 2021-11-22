package com.ingerencia.rest.publishing.controller;

import com.ingerencia.rest.publishing.model.PublishingResponse;
import com.ingerencia.rest.publishing.service.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/news")
public class PublishingController {

    @Autowired
    private PublishingService publishingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PublishingResponse> searchNews() {
        return publishingService.searchNews();
    }

    @DeleteMapping("/remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean removeArticleById(@PathVariable String id) {
        return publishingService.removeArticleById(id);
    }

    @GetMapping("/article")
    @ResponseStatus(HttpStatus.GONE)
    public void searchNewsArticle() {
         publishingService.upgradeNews();
    }

}
