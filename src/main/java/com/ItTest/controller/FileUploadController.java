package com.ItTest.controller;

import com.ItTest.pojo.Result;
import com.ItTest.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class FileUploadController {
    @PostMapping
    public Result uploadFile(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        AliOssUtil aliOssUtil =new AliOssUtil();
        //file.transferTo(new File("E:\\filestore\\"+UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."))));
        return Result.success(aliOssUtil.upLoadFile(UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf(".")),
                file.getInputStream())) ;
    }

}
