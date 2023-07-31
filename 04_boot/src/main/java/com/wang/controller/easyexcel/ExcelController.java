package com.wang.controller.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.MapUtils;
import com.alibaba.fastjson.JSON;
import com.wang.excel.IndexOrNameData;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.*;

/**
 * @author wyt
 * @date 2023/5/5 18:03
 * @description
 */
@Api(tags = "excel相关")
@RestController
@RequestMapping("/excel")
public class ExcelController {


    /**
    * @Author: wyt
    * @Description: 动态head
    * @DateTime: 2023/7/29 15:47
    */
    @GetMapping("/download")
    public void download (HttpServletResponse response) throws IOException {

        //定义表头
        List<List<String>> headList = new ArrayList<>();
        headList.add(Collections.singletonList("姓名"));
        headList.add(Collections.singletonList("年龄"));
        headList.add(Collections.singletonList("操作时间"));

        //定义数据体
        List<List<Object>> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Object> data = new ArrayList<>();
            data.add("张三" + i);
            data.add(20 + i);
            data.add(new Date(System.currentTimeMillis() + i));
            dataList.add(data);
        }

        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName= URLEncoder.encode("测试","UTF-8").replaceAll("\\+","%20");
        response.setHeader("Content-disposition","attachment;filename*=utf-8''"+fileName+".xlsx");
        EasyExcel.write(response.getOutputStream()).sheet("模板").head(headList).doWrite(dataList);
//        ExcelWriter writer = EasyExcel.getWriter(response.getOutputStream(), ExcelTypeEnum.XLSX, true);
//        Sheet sheet = new Sheet(1, 0, BaseRowModel.class, "0", headList);
//        writer.write1(dataList , sheet);
//        writer.finish();
    }


    @GetMapping("/download1")
    public void download1 (HttpServletResponse response) throws IOException {
        try {
            // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName= URLEncoder.encode("测试", StandardCharsets.UTF_8).replaceAll("\\+","%20");
            response.setHeader("Content-disposition","attachment;filename*=utf-8''"+fileName+ Instant.now().getEpochSecond() +".xlsx");

            EasyExcel.write(response.getOutputStream(), IndexOrNameData.class).sheet("模板").doWrite(data());
        } catch (IOException e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = MapUtils.newHashMap();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(JSON.toJSONString(map));
        }
    }


    List<IndexOrNameData> data() {

        List<IndexOrNameData> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            IndexOrNameData indexOrNameData = new IndexOrNameData();
            indexOrNameData.setName("张三" + i);
            indexOrNameData.setIdNumber("000" + i);
            indexOrNameData.setAge(i);
            data.add(indexOrNameData);
        }
        return data;
    }




}
