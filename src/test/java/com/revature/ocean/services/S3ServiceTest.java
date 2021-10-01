package com.revature.ocean.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class S3ServiceTest {
    S3Service s3Service;
/*
    @BeforeEach
    public void Setup(){
        s3Service = new S3Service();
    }

    @Test
    public void uploadImageTest(){
        s3Service.uploadImage();
    }

    @Test
    public void uploadProfileImageTest(){
        s3Service.uploadProfileImage();
    }*/
}
