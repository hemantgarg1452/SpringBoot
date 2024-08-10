package com.api.book.booksApi.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class fileUploadhelper {
    public static final String UPLOAD_DIR="K:\\STS\\FileUploading\\src\\main\\resources\\static";

    public static boolean uploadFile(MultipartFile multipartFile){
        boolean status = false;

        try {
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            status = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }
}
