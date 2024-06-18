package com.springboot.backend.controller;

import com.springboot.backend.common.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("")
public class FileUploadController {

    @PostMapping("/upload")
    public R<String> upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return R.error("File is empty");
        }

        String originalFilename = file.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + fileExtension;

        File dest = new File("/path/to/upload/directory/" + newFileName);
        try {
            file.transferTo(dest);
            return R.success("File uploaded successfully", "/path/to/upload/directory/" + newFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.error("Failed to upload file");
    }
}
