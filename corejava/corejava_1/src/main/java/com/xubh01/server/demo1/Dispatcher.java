package com.xubh01.server.demo1;

import com.xubh01.util.CloseUtil;

import java.io.IOException;
import java.net.Socket;

/**
 * 一个请求与响应 就一个此对象
 */
public class Dispatcher implements Runnable {
    private Socket client;
    private Request req;
    private Response rep;
    private int code = 200;

    Dispatcher(Socket client) {
        this.client = client;
        try {
            req = new Request(client.getInputStream());
            rep = new Response(client.getOutputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            code = 500;
            return;
        }
    }


    @Override
    public void run() {
        Servlet serv = new Servlet();
        serv.service(req, rep);
        try {
            rep.pushToClient(code); //推送到客户端
        } catch (IOException e) {
            //e.printStackTrace();

        }
        try {
            rep.pushToClient(500);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CloseUtil.closeSocket(client);
    }

}
