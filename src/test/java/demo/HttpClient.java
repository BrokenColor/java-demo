package demo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * httpclient-test
 * 
 * @author bc
 * @date 2018年7月18日下午3:49:53
 * @tags
 */
public class HttpClient {

	public static void readParse(String urlPath, String str) throws Exception {

		// JSONObject obj = new JSONObject();
		// obj.put("ids", "[15410,15402]");
		// obj.put("app_ip", "10.21.243.234");
		// obj.put("app_port", 8080);
		// obj.put("app_type", "001");
		// obj.put("app_area", "asd");

		System.out.println(str);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int len = 0;

		URL url = new URL(urlPath);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 设置传递方式
		conn.setRequestMethod("POST");
		// 代理
		conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		conn.setRequestProperty("Content-Type", "application/json");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		// 设置不用缓存
		conn.setUseCaches(false);
		// 权限
		conn.setRequestProperty("Authorization", " Bearer fc58be57c46b32f9a2c32e5393684ac0");

		// 开始连接请求
		conn.connect();
		OutputStream out = conn.getOutputStream();
		// 写入请求的字符串
		out.write((str).getBytes());
		out.flush();
		out.close();

		// 请求返回的状态
		if (conn.getResponseCode() == 200) {
			System.out.println("连接成功");
			// 请求返回的数据
			InputStream in = conn.getInputStream();
			String a = null;
			try {
				byte[] data1 = new byte[in.available()];
				in.read(data1);
				// 转成字符串
				a = new String(data1);
				System.out.println(a);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			System.out.println(conn.getResponseCode() + ":no++");
		}

	}

	public static void main(String[] args) throws Exception {
		// 参数url化
		// String city = java.net.URLEncoder.encode("北京", "utf-8");
		// //拼地址
		// String apiUrl =
		// String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s",city);
		// readParse(apiUrl, "");
		// 地址
		String url = "http://127.0.0.0:81/cloudiipdata/v0.1/datapointsLatestVals";
		// 查询参数
		String str = "{\"ids\":[15410,15402]}";
		readParse(url, str);

	}
}
