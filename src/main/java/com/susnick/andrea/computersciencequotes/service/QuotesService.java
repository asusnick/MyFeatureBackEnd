package com.susnick.andrea.computersciencequotes.service;

import com.susnick.andrea.computersciencequotes.model.Quotes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuotesService {

    private Logger logger = LoggerFactory.getLogger(QuotesService.class);

    public Quotes getQuote(String quote, String author) {
        final String uri = "http://quotes.stormconsultancy.co.uk/random.json";

        RestTemplate restTemplate = new RestTemplate();
        Quotes quotes = restTemplate.getForObject(uri, Quotes.class);
        logger.info("Quote: " + quotes.getQuote() + " Author: " + quotes.getAuthor());

        return quotes;
    }
} 
