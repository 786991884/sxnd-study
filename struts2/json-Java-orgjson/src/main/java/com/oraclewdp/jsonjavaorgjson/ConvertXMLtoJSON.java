package com.oraclewdp.jsonjavaorgjson;

import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.json.JSONML;
import org.json.JSONObject;

public class ConvertXMLtoJSON {
    
    public static void main(String[] args) throws Exception {
        InputStream is = ConvertXMLtoJSON.class.getResourceAsStream("sample-xml.xml");
        String xml = IOUtils.toString(is);
        //xml-->json
        JSONObject jsonObject = JSONML.toJSONObject(xml);
        
        System.out.println(jsonObject.toString(2));
    }
}
