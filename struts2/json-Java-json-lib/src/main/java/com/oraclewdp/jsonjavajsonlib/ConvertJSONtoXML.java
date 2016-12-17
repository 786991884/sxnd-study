package com.oraclewdp.jsonjavajsonlib;

import java.io.InputStream;
import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.io.IOUtils;
public class ConvertJSONtoXML {
    public static void main(String[] args) throws Exception {      
        // 读取 "sample-json.txt" 文件  
        InputStream is =  ConvertJSONtoXML.class.getResourceAsStream("sample-json.txt");
        String jsonText = IOUtils.toString(is);
        
        JSON json = JSONSerializer.toJSON( jsonText );
        //json对象--》xml转换
        XMLSerializer xmlSerializer = new XMLSerializer();
        String xml = xmlSerializer.write( json );         
        System.out.println(xml);                  
    } 
}
