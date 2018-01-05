package com.susnick.andrea.computersciencequotes.controller;

import com.susnick.andrea.computersciencequotes.model.Quotes;
import com.susnick.andrea.computersciencequotes.service.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotesController {

    @Autowired
    private QuotesService quotesService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/quote/{quote}/{author}")
    public Quotes getQuote(@PathVariable String quote, @PathVariable String author) {
        return quotesService.getQuote(quote, author);
    }
}
