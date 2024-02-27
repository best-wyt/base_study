package com.wang.socket.encryption;

import cn.hutool.json.JSONObject;

/**
 * @author wyt
 * @date 2023/9/27 10:31
 * @description
 */
public class TestSM4 {


    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.putOpt("userName" , "zs");
        jsonObject.putOpt("passWord" , "123456");
        String secretKey = "shsgaj_gabrk_jch";
        String iv = "__jch_sgbh5_iv__";
        System.out.println(SM4Utils.encryptData_CBC(jsonObject.toString(), secretKey, iv));
    }

}
