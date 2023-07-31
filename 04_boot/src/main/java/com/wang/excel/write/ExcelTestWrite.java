package com.wang.excel.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.wang.excel.IndexOrNameData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyt
 * @date 2023/7/29 15:48
 * @description
 */
public class ExcelTestWrite {

    String filePath;
    {
        try {
            // 获取resource下的路径
            // 第一种
            //注意getResource("")里面是空字符串
            filePath = this.getClass().getClassLoader().getResource("").getPath();
            System.out.println(filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ExcelTestWrite excelTestWrite = new ExcelTestWrite();
//        excelTestWrite.testWrite("excel/测试1");
        excelTestWrite.testWriteManySheet("excel/测试2.xlsx");
    }

    /**
    * @Author: wyt
    * @Description: 导出excel
    * @DateTime: 2023/7/29 16:52
    */
    void testWrite(String fileName) {
// 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(filePath + fileName, IndexOrNameData.class).sheet("模板").doWrite(data());
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


    /**
    * @Author: wyt
    * @Description: 一次写入多个sheet
    * @DateTime: 2023/7/29 17:00
    */
    void testWriteManySheet (String fileName){
        // 这里 指定文件
        try (ExcelWriter excelWriter = EasyExcel.write(filePath + fileName).build()) {
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
            for (int i = 0; i < 5; i++) {
                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class
                // 实际上可以一直变
                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).head(IndexOrNameData.class).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<IndexOrNameData> data = data();
                excelWriter.write(data, writeSheet);
            }
        }
    }


}
