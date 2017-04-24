package com.xubh01.test.dynamicompile;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.util.List;

/**
 * 测试java中的脚本引擎调用javascript脚本
 */
public class Demo02 {
    public static void main(String[] args) throws Exception {
        //获得脚本引擎
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");
        //定义变量
        engine.put("msg", "gaoqi is a good man!");// 向上下文中定义一个变量
        String str = "var user = {name:'gaoqi',age:18,schools:['清华大学','北京上学堂']}; ";
        str += "println(user.name);";
        //执行脚本
        engine.eval(str);
        engine.eval("msg='sxt is a good school';");
        System.out.println(engine.get("msg"));
        System.out.println("########################");

        // 定义函数
        engine.eval("function add (a, b) {var sum = a + b; return sum; }");
        // 取得调用接口
        Invocable jsInvoke = (Invocable) engine;
        //执行脚本中定义的方法
        Object result1 = jsInvoke.invokeFunction("add", new Object[]{13, 20});
        System.out.println(result1);

        // 导入其他java包,使用其他包中的java类
        String jsCode = "importPackage(java.util); var list = Arrays.asList([\"北京上学堂\",\"清华大学\",\"北京大学\"]); ";
        engine.eval(jsCode);
        List<String> list2 = (List<String>) engine.get("list");
        for (String temp : list2) {
            System.out.println(temp);
        }

        //执行一个js文件(我们将a.js至于项目的src下即可)
        URL is = Demo02.class.getClassLoader().getResource("a.js");
        Reader r = new FileReader(is.getPath());
        engine.eval(r);

    }
}
