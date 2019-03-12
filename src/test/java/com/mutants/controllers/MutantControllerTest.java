package com.mutants.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mutants.controllers.MutantController;
import com.mutants.models.Humano;
import com.mutants.services.HumanoService;
import com.mutants.services.MutantService;

@RunWith(SpringRunner.class)
@WebMvcTest(MutantController.class)
public class MutantControllerTest {

	private Humano humano;
	
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MutantService mutationService;
    
    @MockBean
    private HumanoService humanoService;
    
    @Before
    public void setUp() {
    	humano = Humano.builder()
    			.id(1L)
    			.mutation(true)
    			.dna(new String[]{"AAAA","AAAA","AAAA","AAAA"})
    			.build();
    }
    
    @Test
    public void deve_retornar_http_status_ok() throws Exception {
    	String dna = "[ \"AAAA\", \"AAAA\", \"AAAA\", \"AAAA\" ]";
        
    	when(mutationService.isMutant(any())).thenReturn(true);
    	when(humanoService.save(any())).thenReturn(humano);
        
        this.mockMvc.perform(post("/mutants").contentType(
                MediaType.APPLICATION_JSON).content(dna)).andExpect(status().isCreated());
    }
    
    @Test
    public void deve_retornar_http_status_bad_request() throws Exception {
    	String dna = "[ \"AAAA\", \"AAAA\" ]";
        
    	when(mutationService.isMutant(any())).thenThrow(ArrayIndexOutOfBoundsException.class);
        
        this.mockMvc.perform(post("/mutants").contentType(
                MediaType.APPLICATION_JSON).content(dna)).andExpect(status().isBadRequest());
    }
    
    @Test
    public void eve_retornar_http_status_internal_server_error() throws Exception {
    	String dna = "[ \"AAAA\", \"AAAA\" ]";
        
    	when(mutationService.isMutant(any())).thenThrow(RuntimeException.class);
        
    	this.mockMvc.perform(post("/mutants").contentType(
                MediaType.APPLICATION_JSON).content(dna)).andExpect(status().isInternalServerError());
    }

}