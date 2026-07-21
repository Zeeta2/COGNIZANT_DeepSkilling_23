package com.mockito.demo;


import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



public class FileServiceTest {


    @Test
    public void testServiceWithMockFileIO() {


        // Create mock objects

        FileReader mockFileReader = mock(FileReader.class);

        FileWriter mockFileWriter = mock(FileWriter.class);



        // Fake file content

        when(mockFileReader.read())
                .thenReturn("Mock File Content");



        // Inject mocks

        FileService fileService =
                new FileService(mockFileReader, mockFileWriter);



        // Execute method

        String result = fileService.processFile();



        // Verify output

        assertEquals(
                "Processed Mock File Content",
                result
        );


    }

}