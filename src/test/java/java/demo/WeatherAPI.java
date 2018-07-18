package Demo.Test;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class WeatherAPI {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WeatherAPI.json("北京");
		//3秒后继续执行
		Thread.sleep(3000); 
		WeatherAPI.xml("东京");
	}
	public static void json(String strcity) throws Exception{
		//参数url化
		String city = java.net.URLEncoder.encode(strcity, "utf-8");
		//拼地址
		String apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s",city);
		//开始请求
		URL url= new URL(apiUrl);
		URLConnection open = url.openConnection();
		InputStream input = open.getInputStream();
		//这里转换为String，带上包名，怕你们引错包
		String result = org.apache.commons.io.IOUtils.toString(input,"utf-8");
		//输出
		System.out.println(result);
	}

	public static void xml(String strcity) throws Exception{
		//参数url化
		String city = java.net.URLEncoder.encode(strcity, "utf-8");
		//拼地址
		String apiUrl = String.format("https://www.sojson.com/open/api/weather/xml.shtml?city=%s",city);
		//开始请求
		URL url= new URL(apiUrl);
		URLConnection open = url.openConnection();
		InputStream input = open.getInputStream();
		//这里转换为String，带上包名，怕你们引错包
		String result = org.apache.commons.io.IOUtils.toString(input,"utf-8");
		//输出
		System.out.println(result);
	}
}
