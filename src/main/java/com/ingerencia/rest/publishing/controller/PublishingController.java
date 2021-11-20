package com.ingerencia.rest.publishing.controller;

import com.ingerencia.rest.publishing.model.PublishingResponse;
import com.ingerencia.rest.publishing.service.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/news")
public class PublishingController {

    @Autowired
    private PublishingService publishingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PublishingResponse searchNews() {
        return publishingService.searchNews();
    }

    @GetMapping("/article")
    @ResponseStatus(HttpStatus.OK)
    public void searchNewsArticle() {
         publishingService.upgradeNews();
    }

}
