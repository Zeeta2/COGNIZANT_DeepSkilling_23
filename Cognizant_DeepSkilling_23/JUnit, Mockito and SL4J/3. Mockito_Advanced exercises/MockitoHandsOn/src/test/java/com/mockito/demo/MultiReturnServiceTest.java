package com.mockito.demo;


import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



public class MultiReturnServiceTest {


    @Test
    public void testServiceWithMultipleReturnValues() {


        // Create mock repository

        Repository mockRepository =
                mock(Repository.class);



        // Return different values for consecutive calls

        when(mockRepository.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");



        // Inject mock repository

        Service service =
                new Service(mockRepository);



        // First method call

        String firstResult =
                service.processData();



        // Second method call

        String secondResult =
                service.processData();



        // Verify results

        assertEquals(
                "Processed First Mock Data",
                firstResult
        );


        assertEquals(
                "Processed Second Mock Data",
                secondResult
        );


    }

}