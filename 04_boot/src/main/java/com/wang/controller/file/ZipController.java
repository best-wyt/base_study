package com.wang.controller.file;

import com.wang.utils.ZipUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/zip")
public class ZipController {

    //OK
    @RequestMapping("/zip")
    @ResponseBody
    public void zip(HttpServletResponse response, @RequestBody String json) throws Exception {
        try {
            ZipUtil.zipDateFile(response,"E:\\war\\a\\a","zzz.zip");
        } catch (Exception e){
            log.error("异常了", e);
        }

    }
}
