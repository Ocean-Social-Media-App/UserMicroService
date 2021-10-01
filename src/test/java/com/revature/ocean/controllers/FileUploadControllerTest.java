package com.revature.ocean.controllers;

import com.revature.ocean.models.Response;
import com.revature.ocean.services.S3Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FileUploadControllerTest {
    FileUploadController fileUploadController;

    @Mock
    S3Service s3Service;

    @BeforeEach
    void setUp() {
        this.fileUploadController = new FileUploadController(s3Service);
    }

    @Test
    void uploadProfileImage() {
        //Assign
        FileUploadController mockFileUploadController = Mockito.spy(this.fileUploadController);
        Response expectedResponse = new Response(true, "image uploaded","https://teamwaterbucket.s3.us-east-2.amazonaws.com/");

        //MultipartFile mockFile = Mockito.mock(MultipartFile.class);
        MockMultipartFile mockFile = new MockMultipartFile("user-file","sample.txt",
                "text/plain", "test data".getBytes());

        //Mockito.doReturn(expectedResponse).when(mockFileUploadController.uploadProfileImage(mockFile));
        Mockito.when(s3Service.uploadProfileImage(mockFile)).thenReturn(expectedResponse);

        //Act
        ResponseEntity<Response> actualResponse = this.fileUploadController.uploadProfileImage(mockFile);

        //Assert
        assertEquals(expectedResponse, actualResponse.getBody());
    }
}