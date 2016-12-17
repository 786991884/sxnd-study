package com.oraclewdp.jsonjavajsonlib;

import net.sf.json.JSONObject;

public class GeneratingJson {

    public static void main(String[] args) throws Exception {
       //编程方式创建json对象
        JSONObject json = new JSONObject();
        json.put("aircraft", "A320");// 放入简单元素    
        JSONObject pilot = new JSONObject(); // 添加 JSON对象
        pilot.put("firstName", "John");
        pilot.put("lastName", "Adams");
        json.put("pilot", pilot);
        // 添加数组累计值
        json.accumulate("passenger", "George Washington");
        json.accumulate("passenger", "Thomas Jefferson");

        // 给toString()传递数字来缩进 
        //json--->json文本转换方式
        System.out.println("JSON: " + json.toString(2));
    }
}
