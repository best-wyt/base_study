package com.wang.controller.file;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wang.utils.ZipUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * @author wyt
 * @date 2023/5/8 15:40
 * @description 生成json并进行zip压缩
 */
@RestController
@RequestMapping("/download1")
public class DownloadJsonController {


    @GetMapping("/test")
    public void test(HttpServletResponse response) {
        String fullPath = "/home/test" + File.separator + "test" + ".json";
        //例如：fullPath="D:/myroot/test.json"

        // 生成json格式文件
        try {
            // 保证创建一个新文件
            File file = new File(fullPath);
            // 如果父目录不存在，创建父目录
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            // 如果已存在,删除旧文件
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            //以下创建json格式内容
            //创建一个json对象，相当于一个容器
            JSONObject root = new JSONObject();
            root.put("MessageStatus", "0200");
            root.put("MessageSequence", 25);
            root.put("Remark", "正常");
            JSONObject ResponseParam = new JSONObject();
            root.put("ResponseParam" , ResponseParam);
            JSONArray ResourceInfos = new JSONArray();
            ResponseParam.put("ResourceInfos" , ResourceInfos);
            // todo 有多个body
            JSONObject ResourceInfosBody = new JSONObject();
            ResourceInfos.add(ResourceInfosBody);
            ResourceInfosBody.put("ResourceName" , "");
            JSONObject ResourceItems = new JSONObject();
            ResourceInfosBody.put("ResourceItems" , ResourceItems);
            JSONArray DataItems = new JSONArray();
            ResourceInfosBody.put("DataItems" , DataItems);

            // todo 有多个body
            JSONObject DataItemsBody = new JSONObject();
            DataItems.add(DataItemsBody);
            

            // 格式化json字符串
            String jsonString = formatJson(root.toString());

            // 将格式化后的字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(jsonString);
            write.flush();
            write.close();
            ZipUtil.zipDateFile(response,"/home/test" ,"zzz.zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 单位缩进字符串。
     */
    private static String SPACE = "   ";

    /**
     * 返回格式化JSON字符串。
     *
     * @param json 未格式化的JSON字符串。
     * @return 格式化的JSON字符串。
     */
    public static String formatJson(String json) {
        StringBuffer result = new StringBuffer();

        int length = json.length();
        int number = 0;
        char key = 0;

        // 遍历输入字符串。
        for (int i = 0; i < length; i++) {
            // 1、获取当前字符。
            key = json.charAt(i);

            // 2、如果当前字符是前方括号、前花括号做如下处理：
            if ((key == '[') || (key == '{')) {
                // （1）如果前面还有字符，并且字符为“：”，打印：换行和缩进字符字符串。
                if ((i - 1 > 0) && (json.charAt(i - 1) == ':')) {
                    result.append('\n');
                    result.append(indent(number));
                }

                // （2）打印：当前字符。
                result.append(key);

                // （3）前方括号、前花括号，的后面必须换行。打印：换行。
                result.append('\n');

                // （4）每出现一次前方括号、前花括号；缩进次数增加一次。打印：新行缩进。
                number++;
                result.append(indent(number));

                // （5）进行下一次循环。
                continue;
            }

            // 3、如果当前字符是后方括号、后花括号做如下处理：
            if ((key == ']') || (key == '}')) {
                // （1）后方括号、后花括号，的前面必须换行。打印：换行。
                result.append('\n');

                // （2）每出现一次后方括号、后花括号；缩进次数减少一次。打印：缩进。
                number--;
                result.append(indent(number));

                // （3）打印：当前字符。
                result.append(key);

                // （4）如果当前字符后面还有字符，并且字符不为“，”，打印：换行。
                if (((i + 1) < length) && (json.charAt(i + 1) != ',')) {
                    result.append('\n');
                }

                // （5）继续下一次循环。
                continue;
            }

            // 4、如果当前字符是逗号。逗号后面换行，并缩进，不改变缩进次数。
            if ((key == ',')) {
                result.append(key);
                result.append('\n');
                result.append(indent(number));
                continue;
            }

            // 5、打印：当前字符。
            result.append(key);
        }

        return result.toString();
    }

    /**
     * 返回指定次数的缩进字符串。每一次缩进三个空格，即SPACE。
     *
     * @param number 缩进次数。
     * @return 指定缩进次数的字符串。
     */
    private static String indent(int number) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < number; i++) {
            result.append(SPACE);
        }
        return result.toString();
    }


}
