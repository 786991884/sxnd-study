package com.oraclewdp.jsonjavaorgjson;

import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.json.JSONML;
import org.json.JSONObject;

public class ConvertJSONtoXML {

    public static void main(String[] args) throws Exception {
        // 读取 "sample-json.txt" 文件  
        InputStream is = ConvertJSONtoXML.class.getResourceAsStream("sample-json.txt");
        String jsonText = IOUtils.toString(is);
       
        
        JSONObject jsonObject = new JSONObject(jsonText);
        //json-->xml
        String xml = JSONML.toString(jsonObject);
        System.out.println(xml);
    }
}
