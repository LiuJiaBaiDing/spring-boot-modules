package com.bai.ding.common.controller;

import com.bai.ding.common.util.RandomCharTool;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author BaiDing
 * @date 2020/3/9 23:58
 */
public class BaseController {

    /**
     * 获取Request对象
     */
    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
    }

    public String getUserNameFromSession(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("name");
    }

    /**
     * 获取Response对象
     */
    public HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
    }

    /**
     * 获取session对象
     */
    public HttpSession getSession() {
        return this.getRequest().getSession();
    }


    /**
     * 得到文件的后缀名
     * @param fileName
     * @return
     */
    public String getExtraName(String fileName){
        int i = fileName.lastIndexOf(".");
        String extraName = "";
        if (i > 0) {
            // 含有后缀名的文件
            extraName = fileName.substring(i+1);
        }
        return extraName;
    }

    /**
     * @param excelName
     *            要生成的文件名字
     * @param isAppend
     *            是否追加{时间戳}_8位字母数字组合随机数
     * @return
     * @throws IOException
     */
    public ServletOutputStream generateResponseExcel(String excelName, boolean isAppend) throws IOException {
        excelName = excelName == null || "".equals(excelName) ? "excel" : URLEncoder.encode(excelName, "UTF-8");
        if (isAppend) {
            excelName = excelName.concat("_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_")
                    .concat(RandomCharTool.getRandomCharAndNumr(8));
        }

        HttpServletResponse response = getResponse();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + excelName + ".xlsx");

        return response.getOutputStream();
    }

    /**
     * @param rowNo
     *            插入的数据的行号
     * @param vals
     *            插入的数据值
     * @return
     * @throws IOException
     */
    public void createExcel(XSSFSheet sheet, int rowNo, String[] vals) throws IOException {
        if (vals.length > 0) {
            XSSFRow row = sheet.createRow(rowNo);
            for (int i = 0; i < vals.length; i++) {
                String val = vals[i];
                XSSFCell cell = row.createCell(i);
                cell.setCellValue(val);
            }
        }
    }
}
