package com.lvhongli.util;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.pojo.UploadFileType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties("upload")
@Data
@Slf4j
public class UploadUtil {

    // 获取存放位置
    private Map<String, String> location;

    // 单个文件大小
    private Map<String,Long> singleFileSize;

    // 单个默认文件大小
    private long defaultSingleFileSize;

    //多个文件大小
    private Map<String,Long> multipleFilesSize;

    // 多个文件默认大小
    private long defaultMultipleFileSize;


    private Map<String,String> fileTypes;

    public String getBasePath() {
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")) {
            return  this.getLocation().get("windows");
        }
        return this.getLocation().get("linux");
    }


    public Object[] upload(MultipartFile file){
       //1.验证文件是否为空
        if (file.isEmpty()){
         return new Object[]{false,"请上传文件"};
       }

        //2.验证图片大小
       String fileName=file.getOriginalFilename();
       String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
       if (singleFileSize.get(suffix)!=null){
           if (file.getSize()>singleFileSize.get(suffix)){
               return new Object[]{false,"上传文件超过限制大小"};
           }
       }else {
           if (file.getSize()>defaultSingleFileSize){
               return new Object[]{false,"上传文件超过限制大小"};
           }
       }

       //存储图片
       StringBuilder sb=new StringBuilder();
       sb.append(getBasePath())
           .append("/")
           .append(DateUtil.getDay())
            .append("/");
        try {
            File targetFile = new File(sb.toString());
            if (!targetFile.exists()) {
                targetFile.setWritable(true, false);
                targetFile.mkdirs();
            }
            sb.append(SystemClockUtil.get()).append(file.getOriginalFilename());
            file.transferTo(new File(sb.toString()));
        } catch (IOException e) {
            log.error("图片上传失败:",e);
            return new Object[]{false,"图片上传失败"};
        }
        return new Object[]{true,sb.toString()};
    }

    public Object[] upload(MultipartFile[] files){
        //1.验证文件是否为空
        if (files==null||files.length==0){
            return new Object[]{false,"请上传文件"};
        }

        List<String> list=new LinkedList<>();
        for (MultipartFile file : files) {
            //2.验证图片大小
            String fileName=file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
            if (singleFileSize.get(suffix)!=null){
                if (file.getSize()>singleFileSize.get(suffix)){
                    return new Object[]{false,"上传文件超过限制大小"};
                }
            }else {
                if (file.getSize()>defaultSingleFileSize){
                    return new Object[]{false,"上传文件超过限制大小"};
                }
            }

            //存储图片
            StringBuilder sb=new StringBuilder();
            sb.append(getBasePath())
                    .append("/")
                    .append(DateUtil.getDay())
                    .append("/");
            try {
                File targetFile = new File(sb.toString());
                if (!targetFile.exists()) {
                    targetFile.setWritable(true, false);
                    targetFile.mkdirs();
                }
                Files.copy(file.getInputStream(), Paths.get(sb.toString(), sb.append(SystemClockUtil.get()).append(file.getOriginalFilename()).toString()),
                        StandardCopyOption.REPLACE_EXISTING);
                list.add(sb.toString());
            } catch (IOException e) {
                log.error("图片上传失败:",e);
                return new Object[]{false,"图片上传失败"};
            }
        }
        return new Object[]{true,list};
    }


    public UploadFileType parse(String suffix){
        String name = fileTypes.get(suffix);
        if (name==null)
            return null;
        return UploadFileType.ofValue(name);
    }
    private String getKB(long b){
      return   String.format("%.2dKB",b/1024.0);
    }

    private String getMB(long b){
        return   String.format("%.2dMB",b/1024.0/1024);
    }

}
