package com.oraclewdp.jsonjavajsonlib;

import java.io.IOException;
import java.io.InputStream;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.IOUtils;
public class JSonParsing {
    public static void main(String[] args) throws IOException {
        // Read "sample-json.txt" file that contains JSON string.
        //我们读取文件的两种方式：一种通过文件，另外通过类加载方
        //下面就是类加载方式：就是到类路径去找，如果以"/",那么就到类根目录去找，若无会去尝试加
        //前缀 :首先尝试com/oraclewdp/jsonjavajsonlib/sample-json.txt
        InputStream is = JSonParsing.class.getResourceAsStream("sample-json.txt");
        //这个方法就是把文件内容转为一个字符串
        String jsonTxt = IOUtils.toString(is);
        // 转换 JSON字符串为JSONObject 对象
        //json文本-->json对象转换
        JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(jsonTxt);
        
        jsonObject.put("director", "Sang Shin"); // 添加键/值 对 
        System.out.println(jsonObject); // 显示JSON对象 
        
        
        double coolness = jsonObject.getDouble("coolness");//读取值并显示
        int altitude = jsonObject.getInt("altitude");
        JSONObject pilot = jsonObject.getJSONObject("pilot");
        String firstName = pilot.getString("firstName");
        String lastName = pilot.getString("lastName");
        System.out.println("Coolness: " + coolness);
        System.out.println("Altitude: " + altitude);
        System.out.println("Pilot: " + lastName);
        System.out.println("Director: " + jsonObject.getString("director"));
    }
}
