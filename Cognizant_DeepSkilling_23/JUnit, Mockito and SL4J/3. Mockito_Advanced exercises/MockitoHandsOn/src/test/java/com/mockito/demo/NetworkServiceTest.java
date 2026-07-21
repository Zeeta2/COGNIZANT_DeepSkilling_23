package com.mockito.demo;


import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



public class NetworkServiceTest {


    @Test
    public void testServiceWithMockNetworkClient() {


        // Create Mock Network Client

        NetworkClient mockNetworkClient =
                mock(NetworkClient.class);



        // Stub network response

        when(mockNetworkClient.connect())
                .thenReturn("Mock Connection");



        // Inject mock

        NetworkService networkService =
                new NetworkService(mockNetworkClient);



        // Call method

        String result =
                networkService.connectToServer();



        // Verify result

        assertEquals(
                "Connected to Mock Connection",
                result
        );


    }

}