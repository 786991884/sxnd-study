package com.xubh01.server.demo1.demo1;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装request
 */
public class Request {
    //请求方式
    private String method;
    //请求资源
    private String url;
    //请求参数
    private Map<String, List<String>> parameterMapValues;

    //内部
    public static final String CRLF = "\r\n";
    private InputStream is;
    private String requestInfo;

    public Request() {
        method = "";
        url = "";
        parameterMapValues = new HashMap<String, List<String>>();
        requestInfo = "";
    }

    public Request(InputStream is) {
        this();
        this.is = is;
        try {
            byte[] data = new byte[20480];
            int len = is.read(data);
            requestInfo = new String(data, 0, len);
        } catch (Exception e) {
            return;
        }
        //分析请求信息
        parseRequestInfo();
    }

    /**
     * 分析请求信息
     */
    private void parseRequestInfo() {
        if (null == requestInfo || (requestInfo = requestInfo.trim()).equals("")) {
            return;
        }
        /**
         * =====================================
         * 从信息的首行分解出 :请求方式    请求路径   请求参数(get可能存在)
         *   如:GET /index.html?name=123&pwd=5456 HTTP/1.1
         *
         * 如果为post方式，请求参数可能在 最后正文中
         *
         * 思路:
         * 1)请求方式 :找出第一个/  截取即可
         * 2)请求资源:找出第一个/   HTTP/
         * =====================================
         */
        String paramString = ""; //接收请求参数

        //1、获取请求方式
        String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
        int idx = requestInfo.indexOf("/"); // /的位置
        this.method = firstLine.substring(0, idx).trim();
        String urlStr = firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();
        if (this.method.equalsIgnoreCase("post")) {
            this.url = urlStr;
            paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();

        } else if (this.method.equalsIgnoreCase("get")) {
            if (urlStr.contains("?")) { //是否存在参数
                String[] urlArray = urlStr.split("\\?");
                this.url = urlArray[0];
                paramString = urlArray[1];//接收请求参数
            } else {
                this.url = urlStr;
            }
        }


        //2、将请求参数封装到Map中
    }


}
