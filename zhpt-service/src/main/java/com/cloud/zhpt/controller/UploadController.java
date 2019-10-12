package com.cloud.zhpt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UploadController
 * @Description
 * @Author SW
 * @Date 2019/9/25 14:33
 **/
@RestController
public class UploadController {
    private static final String UPLOAD_PATH = "D:/home/qabot/";

    /**
     * 上传文件
     *
     * @param file
     * @param request
     * @param response
     * @return UploadResult
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map upload(@RequestParam("file") MultipartFile file, String savePath, HttpServletRequest request,
                      HttpServletResponse response) {
        Map retMap = new HashMap();
        //判断文件大小
        if (file.getSize() == 0) {
            retMap.put("msg", "对不起，不允许上传空文件");
            retMap.put("status", "failed");
        }
        // 判断文件后缀
        String originalFileName = file.getOriginalFilename();
        String dirPath = UPLOAD_PATH + savePath;

        // 根据当前时间创建存储路径
        File uploadDir = new File(dirPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String fileUrl = dirPath + "/" + originalFileName;
        // 上传文件至指定的目录
        File newFile = new File(fileUrl);
        try {
            file.transferTo(newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        retMap.put("path", fileUrl);
        retMap.put("fileName", originalFileName);
        return retMap;
    }
}
