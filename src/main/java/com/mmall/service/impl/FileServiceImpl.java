package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("iFileService")
@Slf4j
public class FileServiceImpl implements IFileService {

    public String upload(MultipartFile file,String path){
        //拿到上传文件的原始文件名
        String fileName = file.getOriginalFilename();
        //获取扩展名
        //abc.jpg
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        //防止两次上传图片的文件名相同。例如：第一次传A:abc.jpg, 第二次传B:abc.jpg, 这样第二次会覆盖第一次的图片
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName ;
        log.info("开始上传文件，上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

        //创建目录
        File fileDir = new File(path);
        if (!fileDir.exists()){
            //赋予权限，可写
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        //创建文件
        File targetFile = new File(path,uploadFileName);

        try {
            //保存文件，把内存图片写入磁盘中
            //没有这句话，生成的文件就是一个文件夹。有了以后，就会在path路径下，生成一个文件
            //文件已经上传成功了
            file.transferTo(targetFile);
            //将targetFile上传到我们的FTP服务器上
            //已经上传到ftp服务器上
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //上传完之后，删除upload下面的文件
            targetFile.delete();
        } catch (IOException e) {
            log.error("上传文件异常",e);
            return null;
        }
        return targetFile.getName();
    }
}
