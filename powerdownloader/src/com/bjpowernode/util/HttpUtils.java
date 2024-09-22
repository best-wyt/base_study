package com.bjpowernode.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author wyt
 * @date 2024/2/27 21:21
 * @description
 */
public class HttpUtils {


    public static HttpURLConnection getHttpURLConnection(String url) throws IOException {
        URL httpUrl = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
        httpURLConnection.setRequestProperty("User-Agent" , "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");
        return httpURLConnection;
    }


    public static String getHttpFileName(String url) {
        int index = url.lastIndexOf("/");
        return url.substring(index + 1);
    }

}
