package com.oraclewdp.jsonjavaorgjson;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;


public class JSonParsing {
    public static void main(String[] args) throws IOException, JSONException {
        // Read "sample-json.txt" file that contains JSON string.
        InputStream is = JSonParsing.class.getResourceAsStream("sample-json.txt");
        
        String jsonTxt = IOUtils.toString(is);
        // 转换 JSON字符串为JSONObject 对象
        // 把json文本-->jsonObject
        JSONObject jsonObject=new JSONObject(jsonTxt);
        jsonObject.put("director", "Sang Shin"); // 添加键/值 对 
        System.out.println(jsonObject); // 显示JSON对象   
        double coolness = jsonObject.getDouble("coolness");//读取值并显示
        int altitude = jsonObject.getInt("altitude");
        JSONObject  pilot = jsonObject.getJSONObject("pilot");
        String firstName = pilot.getString("firstName");
        String lastName = pilot.getString("lastName");
        System.out.println("Coolness: " + coolness);
        System.out.println("Altitude: " + altitude);
        System.out.println("Pilot: " + lastName);
        System.out.println("Director: " + jsonObject.getString("director"));
    }
}
