package com.bai.ding.goods.controller;

import com.bai.ding.common.Result;
import com.bai.ding.common.constant.BackendModulesConstant;
import com.bai.ding.common.util.FastdfsClientUtil;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @author BaiDing
 * @date 2020/3/27 13:42
 */
@RestController
public class PictureController {

    private static final String FASTDFS_UPLOAD_URL = BackendModulesConstant.getFastdfsUploadUrl();

    @PostMapping("/uploadImage")
    public Result uploadImage(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {

        File targetFile = null;
        String url = "";
        String fileName = file.getOriginalFilename();
        String extraName = fileName.substring(fileName.lastIndexOf("."));

        //图片访问的URI
        // request.getScheme() : http,request.getServerName(): localhost, request.getServerPort(): 19090, request.getContextPath(): interface
        String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/static/";
        // 文件临时存储位置
        String path = request.getSession().getServletContext().getRealPath("") + "upload" + File.separator + "imgs";

        //新的文件名
        fileName = System.currentTimeMillis() + "_" + new Random().nextInt(1000) + extraName;


        //先判断文件是否存在
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String fileAdd = sdf.format(new Date());
        //获取文件夹路径
        path = path + File.separator + fileAdd + File.separator;
        File file1 = new File(path);
        //如果文件夹不存在则创建
        if (!file1.exists() && !file1.isDirectory()) {
            file1.mkdirs();
        }
        //将图片存入文件夹
        targetFile = new File(file1, fileName);
        try {
            //将上传的文件写到服务器上指定的文件。
            file.transferTo(targetFile);
            String projectPath = System.getProperty("user.dir");
            //文件复制
            String src = path + fileName;
            //根据自己系统的resource 目录所在位置进行自行配置
            String destDir = projectPath + File.separator + "spring-boot-modules-goods" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator;
            copyFile(src, destDir, fileName);

            url = returnUrl + fileName;
            Map<String, Object> map = Maps.newHashMap();
            map.put("url", url);
            return new Result.Builder().ok().setMessage("图片上传成功").setData(map).build();
        } catch (Exception e) {
            e.printStackTrace();
            return new Result.Builder().error().setMessage("图片上传失败").build();
        }
    }

    /**
     * 文件复制
     *
     * @param src
     * @param destDir
     * @param fileName
     * @throws IOException
     */
    public void copyFile(String src, String destDir, String fileName) throws IOException {
        FileInputStream in = new FileInputStream(src);
        File fileDir = new File(destDir);
        if (!fileDir.isDirectory()) {
            fileDir.mkdirs();
        }
        File file = new File(fileDir, fileName);

        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file);
        int c;
        byte[] buffer = new byte[1024];
        while ((c = in.read(buffer)) != -1) {
            for (int i = 0; i < c; i++) {
                out.write(buffer[i]);
            }

        }
        in.close();
        out.close();
    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadFile")
    public Result uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // 获取原文件名
            String origFileName = file.getOriginalFilename();
            // 获取扩展名
            String extName = origFileName.substring(origFileName.lastIndexOf(".") + 1);
            // 获取文件存储路径
            String fileId = FastdfsClientUtil.uploadFile(file.getBytes(), extName);
            Map<String, Object> map = Maps.newHashMap();
            map.put("fileId", fileId);
            map.put("url", FASTDFS_UPLOAD_URL + fileId);
            return new Result.Builder().ok().setMessage("图片上传成功").setData(map).build();
        } catch (Exception e) {
            e.printStackTrace();
            return new Result.Builder().error().setMessage("图片上传失败").build();
        }
    }
}

