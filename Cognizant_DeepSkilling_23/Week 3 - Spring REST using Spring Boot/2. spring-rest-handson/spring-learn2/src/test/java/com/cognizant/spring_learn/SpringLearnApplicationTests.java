package com.cognizant.spring_learn;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import com.cognizant.spring_learn.controller.CountryController;
@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CountryController countryController;
    @Test
    void contextLoads() {
        assertNotNull(countryController);
    }
    @Test
    void testGetCountry() throws Exception {
        mockMvc.perform(get("/country"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").exists())
                .andExpect(jsonPath("$.code").value("IN"))
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.name").value("India"));
    }
    @Test
    void testGetCountryException() throws Exception {

        mockMvc.perform(get("/countries/az"))
                .andExpect(status().isNotFound())
                .andExpect(status().reason("Country not found"));
    }
}