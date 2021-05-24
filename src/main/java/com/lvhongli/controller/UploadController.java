package com.lvhongli.controller;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.dao.UploadFileRepository;
import com.lvhongli.model.UploadFile;
import com.lvhongli.util.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.Optional;

@Api("文件上传api")
@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {

    @Autowired
    private UploadFileRepository uploadFileRepository;

    @Autowired
    private UploadUtil uploadUtil;

    @PostMapping()
    @ApiOperation(value = "上传文件", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = ResultMsg.class),
            @ApiResponse(code = 201, message = "失败", response = ResultMsg.class)
    })
    public ResultMsg upload(@RequestBody MultipartFile file){
        Object[] objects = uploadUtil.upload(file);
        if (!(Boolean)objects[0]){
            return ResultMsg.fail(objects[1].toString());
        }
        UploadFile uploadFile = new UploadFile();
        uploadFile.setName(file.getOriginalFilename());
        uploadFile.setValid(true);
        uploadFile.setCreateTime(new Date());
        uploadFile.setUpdateTime(new Date());
        String fileName=file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
        uploadFile.setSuffix(suffix);
        uploadFile.setType(file.getContentType());
        uploadFile.setPath(objects[1].toString());
        uploadFileRepository.saveAndFlush(uploadFile);
        return ResultMsg.success(uploadFile.getId());
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "获取文件", notes = "")
    public void upload(@PathVariable("id") String id, HttpServletResponse response) {
        Optional<UploadFile> optional = uploadFileRepository.findById(id);
        if (!optional.isPresent()){
            log.info("找不到文件：{}",id);
            response.setStatus(404);
        }
        //1、设置response 响应头
        response.reset(); //设置页面不缓存,清空buffer
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType(optional.get().getType()); //二进制传输数据
        //设置响应头

        try (BufferedInputStream  input =new BufferedInputStream(new FileInputStream(optional.get().getPath()));
             BufferedOutputStream out = new BufferedOutputStream( response.getOutputStream())){
            byte[] buff =new byte[1024];
            int index=0;
            //4、执行 写出操作
            while((index= input.read(buff))!= -1){
                out.write(buff, 0, index);
                out.flush();
            }
        } catch (Exception e) {
           log.error("获取文件失败：{}",e);
        }
    }
}
