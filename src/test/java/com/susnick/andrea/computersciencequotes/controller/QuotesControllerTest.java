package com.susnick.andrea.computersciencequotes.controller;

import com.susnick.andrea.computersciencequotes.model.Quotes;
import com.susnick.andrea.computersciencequotes.service.QuotesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = QuotesController.class, secure = false)
public class QuotesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuotesService quotesService;

    @InjectMocks
    private QuotesController quotesController = new QuotesController();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(quotesController).build();
    }

    @Test
    public void getQuoteTest() throws Exception {
        Quotes mockQuote = new Quotes ("Test test test", "Bill Gates");

        Mockito.when(quotesService.getQuote(Mockito.anyString(), Mockito.anyString())).thenReturn(mockQuote);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/quote/quote/author")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{\"quote\":\"Test test test\",\"author\":\"Bill Gates\"}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}
