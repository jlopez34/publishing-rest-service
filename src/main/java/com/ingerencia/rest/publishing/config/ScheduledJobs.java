package com.ingerencia.rest.publishing.config;

import com.ingerencia.rest.publishing.service.PublishingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class ScheduledJobs {
    private final static Logger LOGGER = Logger.getLogger(ScheduledJobs.class);

    @Autowired
    private PublishingService publishingService;

    @Value("${jobs.enabled}")
    private boolean isEnabled;

    /**
     * A scheduled job controlled via application property. The job always
     * executes, but the logic inside is protected by a configurable boolean
     * flag.
     */
    @Scheduled(fixedDelayString = "${jobs.delay}")
    public void findNewsPaper() {
        if(isEnabled) {
            LOGGER.info("Init - Upgrading news java papers");
            publishingService.upgradeNews();
            LOGGER.info("End - Upgrading news java papers");
        }
    }
}
