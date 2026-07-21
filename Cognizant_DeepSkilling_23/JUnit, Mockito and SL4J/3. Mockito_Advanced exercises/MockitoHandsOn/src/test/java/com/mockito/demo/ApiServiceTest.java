package com.mockito.demo;


import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class ApiServiceTest {


    @Test
    public void testServiceWithMockRestClient() {


        // Create mock REST client

        RestClient mockRestClient = mock(RestClient.class);



        // Stub API response

        when(mockRestClient.getResponse())
                .thenReturn("Mock Response");



        // Inject mock into service

        ApiService apiService = new ApiService(mockRestClient);



        // Call method

        String result = apiService.fetchData();



        // Verify result

        assertEquals(
                "Fetched Mock Response",
                result
        );

    }

}