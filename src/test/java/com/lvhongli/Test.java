package com.lvhongli;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\localSoftware\\chromeDownloads\\BaiduMap_cityCenter\\BaiduMap_cityCenter.json"))));
        StringBuilder sb=new StringBuilder();
        String str=null;
        while ((str=br.readLine())!=null){
            sb.append(new String(str.getBytes(StandardCharsets.UTF_8),"utf-8"));
        }
        Map map = JSONObject.parseObject(sb.toString(), Map.class);
        JSONArray provinces = (JSONArray) map.get("provinces");
        JSONArray other = (JSONArray) map.get("other");
        JSONArray municipalities = (JSONArray) map.get("municipalities");

    }


    public  void  test(JSONObject jsonObject){
        Object cites = jsonObject.get("cites");
    }
}
