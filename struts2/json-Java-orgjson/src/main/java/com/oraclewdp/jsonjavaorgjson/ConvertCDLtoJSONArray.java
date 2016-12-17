package com.oraclewdp.jsonjavaorgjson;

import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.json.CDL;
import org.json.JSONArray;

public class ConvertCDLtoJSONArray {
    
    public static void main(String[] args) throws Exception {
        InputStream is = ConvertCDLtoJSONArray.class.getResourceAsStream("samp_cdl2.txt");
        String cdl1 = IOUtils.toString(is);
        /**
         *  
            id,userName,pwd,age
            1,zhangsan,123,24 
            2,lisi,123,32
            3,wangwu,456,46
            * 
            注意该文件的换行符不能为\r\n，否则异常
         */
        //
        JSONArray jsonObject = CDL.toJSONArray(cdl1); 
        System.out.println(jsonObject.toString(2));
    }
}
