package com.susnick.andrea.computersciencequotes.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuotesServiceTest {
    private String quote;
    private String author;
    QuotesService quotesService;

    @Before
    public void setUp() throws Exception {
        quote = "Test test test";
        author = "Bill Gates";
        quotesService = new QuotesService();
    }

    @Test
    public void getQuoteTest() throws Exception {
        Assert.assertTrue(this.quotesService.getQuote(quote, author) != null);
    }
}
