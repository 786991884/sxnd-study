package com.xubh01.test.dynamicompile;


import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 测试java的动态编译
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {

        //通过IO流操作，将字符串存储成一个临时文件(Hi.java)，然后调用动态编译方法！
        String str = "public class Hi {public static void main(String[] args){System.out.println(\"HaHa,sxt!\");}}";

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "c:/myjava/HelloWorld.java");
        System.out.println(result == 0 ? "编译成功" : "编译失败");


        //通过Runtime调用执行类
//		Runtime run = Runtime.getRuntime();
//        Process process = run.exec("java -cp  c:/myjava    HelloWorld");
//
//        InputStream in = process.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//		String info = "";
//		while((info=reader.readLine())!=null){
//			System.out.println(info);
//		}


        try {
            URL[] urls = new URL[]{new URL("file:/" + "C:/myjava/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("HelloWorld");
            //调用加载类的main方法
            Method m = c.getMethod("main", String[].class);
            m.invoke(null, (Object) new String[]{});
            //由于可变参数是JDK5.0之后才有。
            //m.invoke(null, (Object)new String[]{});会编译成:m.invoke(null,"aa","bb"),就发生了参数个数不匹配的问题。
            //因此，必须要加上(Object)转型，避免这个问题。
            //public static void main(String[] args)

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
