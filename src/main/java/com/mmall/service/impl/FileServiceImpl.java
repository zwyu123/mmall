package com.mmall.service.impl;

import com.mmall.service.IFileService;
import org.springframework.web.multipart.MultipartFile;

public class FileServiceImpl implements IFileService {

    public String upload(MultipartFile file,String path){
        //拿到上传文件的原始文件名
        String fileName = file.getOriginalFilename();
        //获取扩展名
        //abc.jpg
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
    }
}
