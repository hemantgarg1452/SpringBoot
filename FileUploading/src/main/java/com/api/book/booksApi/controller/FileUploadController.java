package com.api.book.booksApi.controller;

import com.api.book.booksApi.helper.fileUploadhelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @Autowired
    private fileUploadhelper uploadhelper;

    @PostMapping("/UploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("picture")MultipartFile file){
//          System.out.println(file.getName());
//          System.out.println(file.getContentType());
        try {
            //Test Cases for Validation
            if(file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File must be contain");
            }
            if(!file.getContentType().equals("images/jpeg")) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("The Type must be JPEG");
            }

            //File Uploading using helper
            boolean uploaded = fileUploadhelper.uploadFile(file);
            if(uploaded){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Image uploaded successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Try Again!");
    }
}
