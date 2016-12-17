package com.oraclewdp.jsonjavajsonlib;

import java.io.InputStream;
import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.io.IOUtils;

public class ConvertJSONtoXMLNoHints {

    public static void main(String[] args) throws Exception {
        InputStream is = ConvertJSONtoXMLNoHints.class.getResourceAsStream("sample-json.txt");
        String jsonData = IOUtils.toString(is);
        JSON json = JSONSerializer.toJSON(jsonData);

        XMLSerializer serializer = new XMLSerializer();
        //是否在xml中输出类型信息
        serializer.setTypeHintsEnabled(false);
        String xml = serializer.write(json);
        System.out.println(xml);

    }
}
