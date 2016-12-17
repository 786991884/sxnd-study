package day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpConnTest {
	public static void main(String[] args) throws Exception {
		// 创建URl对象
		URL url = new URL("http://www.javaeye.com");
		// 用URL创建HttpURLConnection对象
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 打开连接
		conn.connect();
		// 打印请求响应的头部信息
		Map<String, List<String>> header = conn.getHeaderFields();
		for (String key : header.keySet()) {
			System.out.println(key + ":" + header.get(key));
		}
		// 打印响应内容
		BufferedReader br = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "utf-8"));
		String str = null;
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		conn.disconnect();// 断开连接
	}
}
