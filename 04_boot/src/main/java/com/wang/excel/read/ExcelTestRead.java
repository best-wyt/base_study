package com.wang.excel.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.wang.excel.IndexOrNameData;
import com.wang.excel.IndexOrNameDataListener;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author wyt
 * @date 2023/7/29 14:04
 * @description
 */

public class ExcelTestRead {
    public ExcelTestRead() throws FileNotFoundException {
    }

    String filePath;

    InputStream inputStream;

    {
        inputStream = this.getClass().getClassLoader().getResourceAsStream("excel/测试.xlsx");
        System.out.println(inputStream);

        // 文件地址前多一个‘/’
        inputStream = this.getClass().getResourceAsStream("/" + "excel/测试.xlsx");
        System.out.println(inputStream);
    }

    {
        try {
            // 获取resource下的路径
            // 第一种
            //注意getResource("")里面是空字符串
            filePath = this.getClass().getClassLoader().getResource("").getPath();
            System.out.println(filePath);
            filePath = filePath + "excel/测试.xlsx";
            System.out.println(filePath);

            // 第二种
            filePath = this.getClass().getClassLoader().getResource("excel/测试.xlsx").getPath();
            System.out.println(filePath);
            //如果路径中带有中文会被URLEncoder,因此这里需要解码
            filePath = URLDecoder.decode(filePath, "UTF-8");
            System.out.println(filePath);

            // 第三种
            filePath = this.getClass().getClassLoader().getResource("excel/测试.xlsx").getFile();
            System.out.println(filePath);
            //如果路径中带有中文会被URLEncoder,因此这里需要解码
            filePath = URLDecoder.decode(filePath, "UTF-8");
            System.out.println(filePath);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ExcelTestRead excelTest = new ExcelTestRead();
        excelTest.testReadByStreamManySheet();
    }

    /**
    * @Author: wyt
    * @Description: 通过地址进行读取
    * @DateTime: 2023/7/29 14:46
    */
    void testReadByPath() {

        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(filePath, IndexOrNameData.class, new IndexOrNameDataListener()).sheet().doRead();


    }

    /**
    * @Author: wyt
    * @Description: 通过stream读取
    * @DateTime: 2023/7/29 14:46
    */
    void testReadByStream() {

        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(inputStream, IndexOrNameData.class, new IndexOrNameDataListener()).sheet().doRead();

    }

    /**
    * @Author: wyt
    * @Description: 通过stream读取
    * @DateTime: 2023/7/29 14:46
    */
    void testReadByStreamManySheet() {

        // 写法1
        try (ExcelReader excelReader = EasyExcel.read(inputStream).build()) {
            // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
            ReadSheet readSheet1 =
                    EasyExcel.readSheet(0).head(IndexOrNameData.class).registerReadListener(new IndexOrNameDataListener()).build();
            ReadSheet readSheet2 =
                    EasyExcel.readSheet(1).head(IndexOrNameData.class).registerReadListener(new IndexOrNameDataListener()).build();
            // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
            excelReader.read(readSheet1, readSheet2);
        }
    }


}
