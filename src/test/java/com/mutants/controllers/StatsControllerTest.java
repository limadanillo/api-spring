package com.mutants.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mutants.controllers.StatsController;
import com.mutants.models.Stats;
import com.mutants.services.StatsService;

@RunWith(SpringRunner.class)
@WebMvcTest(StatsController.class)
public class StatsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private StatsService statsService;
    
    @Test
    public void deveRetornarHttpStatusOk() throws Exception {
    	when(statsService.getStats()).thenReturn(Stats.builder().build());
        this.mockMvc.perform(get("/stats")).andExpect(status().isOk());
    }
    
    @Test
    public void deveRetornarHttpStatusInternalServerError() throws Exception {
    	when(statsService.getStats()).thenThrow(RuntimeException.class);
        this.mockMvc.perform(get("/stats")).andExpect(status().isInternalServerError());
    }
    
}