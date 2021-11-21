package com.ingerencia.rest.publishing.service.impl;

import com.ingerencia.rest.publishing.exception.PublishingException;
import com.ingerencia.rest.publishing.gateway.AlgoliaService;
import com.ingerencia.rest.publishing.gateway.dto.Article;
import com.ingerencia.rest.publishing.gateway.dto.Hit;
import com.ingerencia.rest.publishing.model.PublishingResponse;
import com.ingerencia.rest.publishing.repository.PublishingRepository;
import com.ingerencia.rest.publishing.repository.dto.Paper;
import com.ingerencia.rest.publishing.service.PublishingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublishingServiceImpl implements PublishingService {
    private static final Logger LOGGER = Logger.getLogger(PublishingServiceImpl.class);

    @Autowired
    private AlgoliaService algoliaService;

    @Autowired
    private PublishingRepository publishingRepository;

    @Override
    public List<PublishingResponse> searchNews() {
        List<PublishingResponse> publishingResponse = null;
        Optional<List<Paper>> articles = Optional.of(publishingRepository.findByRemoved(false));
        if(articles.isPresent()){
            publishingResponse = buildNews(articles.get());
        }
        return publishingResponse;
    }

    private List<PublishingResponse> buildNews(List<Paper> papers) {
        List<PublishingResponse> publishingResponses;
        try{
            publishingResponses = papers.stream().map(Paper::ofModel).collect(Collectors.toList());
        }catch (PublishingException exception){
            throw new PublishingException(exception.getMessage());
        }
        return publishingResponses;
    }

    @Override
    public void upgradeNews() {
        Optional<Article> articles = Optional.ofNullable(algoliaService.upgradeArticle());
        if(articles.isPresent()){
            for (Hit hit:articles.get().hits) {
                Paper paper = Paper.of(hit);
                handlerStock(paper);
            }
        }
    }

    private void handlerStock(Paper paper) {
        try{
            Optional<List<Paper>> papers = Optional.ofNullable(publishingRepository.findByObjectIDAndRemoved(paper.objectID, false));
            if(papers.get().size()==0){
                publishingRepository.save(paper);
            }
        }catch (PublishingException exception){
            throw new PublishingException(exception.getMessage());
        }
    }

    @Override
    public boolean removeArticleById(String id) {
        try{
            Optional<Paper> optionalPaper = publishingRepository.findById(id);

            if (optionalPaper.isPresent()) {
                Paper _paper = optionalPaper.get();
                _paper.setRemoved(true);
                _paper = publishingRepository.save(_paper);
                return _paper.isRemoved() ;
            }
        }catch (PublishingException exception){
            throw new PublishingException(exception.getMessage());
        }

        return false;
    }
}
