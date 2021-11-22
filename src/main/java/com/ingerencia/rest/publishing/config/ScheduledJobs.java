package com.ingerencia.rest.publishing.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class ScheduledJobs {
    private final static Logger LOG = Logger.getLogger(ScheduledJobs.class);

    @Value("${jobs.enabled}")
    private boolean isEnabled;

    /**
     * A scheduled job controlled via application property. The job always
     * executes, but the logic inside is protected by a configurable boolean
     * flag.
     */
    @Scheduled(fixedDelay = 6000)
    public void findNewsPaper() {
        if(isEnabled) {
            LOG.info("Upgrading news java papers");
        }
    }
}
