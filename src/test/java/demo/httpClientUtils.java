package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * 
 * 描述：HttpClient工具类
 * 
 * @author BrokenColor
 * @date 2018年10月26日
 */
public class httpClientUtils {

	// private static Logger logger = Logger.getLogger(httpClientUtils.class);

	/**
	 * get请求
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String doGet(String url, Map<String, String> map) throws Exception {

		url += "?";
		// 拼装参数
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			url += entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "utf-8") + "&";

		}

		// 1.使用默认的配置的httpclient
		CloseableHttpClient client = HttpClients.createDefault();
		// 2.使用get方法
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Content-type", "application/json");
		CloseableHttpResponse response = null;

		try {
			// 3.执行请求，获取响应
			response = client.execute(httpGet);

			// 看请求是否成功，这儿打印的是http状态码
			System.out.println(response.getStatusLine().getStatusCode());
			// 4.获取响应的实体内容，就是我们所要抓取得网页内容
			HttpEntity entity = response.getEntity();

			// 5.将其打印到控制台上面
			// 方法一：使用EntityUtils
			if (entity != null) {
				String json_String = EntityUtils.toString(entity, "utf-8");
				return json_String;
			}
			EntityUtils.consume(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * post请求(用于key-value格式的参数)
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, Map params) {

		BufferedReader in = null;
		try {
			// 定义HttpClient
			CloseableHttpClient client = HttpClients.createDefault();
			// 实例化HTTP方法
			HttpPost request = new HttpPost();
			request.setURI(new URI(url));
			request.setHeader("Content-type", "application/json");

			// 设置参数
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String value = String.valueOf(params.get(name));
				nvps.add(new BasicNameValuePair(name, value));

				// System.out.println(name +"-"+value);
			}
			request.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

			HttpResponse response = client.execute(request);
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) { // 请求成功
				in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
				StringBuffer sb = new StringBuffer("");
				String line = "";
				String NL = System.getProperty("line.separator");
				while ((line = in.readLine()) != null) {
					sb.append(line + NL);
				}

				in.close();

				return sb.toString();
			} else { //
				System.out.println("状态码：" + code);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	/**
	 * put map传参
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doput(String url, Map params) {
		BufferedReader in = null;
		try {
			// 定义HttpClient
			CloseableHttpClient client = HttpClients.createDefault();
			// 实例化HTTP方法
			HttpPut request = new HttpPut();
			request.setURI(new URI(url));
			request.setHeader("Content-type", "application/json");

			// 设置参数
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String value = String.valueOf(params.get(name));
				nvps.add(new BasicNameValuePair(name, value));

				// System.out.println(name +"-"+value);
			}
			request.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

			HttpResponse response = client.execute(request);
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) { // 请求成功
				in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
				StringBuffer sb = new StringBuffer("");
				String line = "";
				String NL = System.getProperty("line.separator");
				while ((line = in.readLine()) != null) {
					sb.append(line + NL);
				}

				in.close();

				return sb.toString();
			} else { //
				System.out.println("状态码：" + code);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	/**
	 * 删除
	 * 
	 * @param url
	 * @param dataForm
	 * @return
	 */
	public static String DELETE(String url, Map<String, String> dataForm) {
		HttpClient httpClient = new HttpClient();
		DeleteMethod deleteMethod = new DeleteMethod(url);

		List<org.apache.commons.httpclient.NameValuePair> data = new ArrayList<org.apache.commons.httpclient.NameValuePair>();
		if (dataForm != null) {
			Set<String> keys = dataForm.keySet();
			for (String key : keys) {
				org.apache.commons.httpclient.NameValuePair nameValuePair = new org.apache.commons.httpclient.NameValuePair(
						key, (String) dataForm.get(key));
				data.add(nameValuePair);
			}
		}
		deleteMethod.setQueryString(data.toArray(new org.apache.commons.httpclient.NameValuePair[0]));
		try {
			int statusCode = httpClient.executeMethod(deleteMethod);
			if (statusCode != HttpStatus.SC_OK) {
				return "Method failed: " + deleteMethod.getStatusLine();
			}

			// Read the response body.
			byte[] responseBody = deleteMethod.getResponseBody();
			// Deal with the response.
			// Use caution: ensure correct character encoding and is not binary data
			return new String(responseBody);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			deleteMethod.releaseConnection();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {

		// 测试put传参方法 (map)
		Map<String, String> map = new HashMap<>();

		map.put("aaa", "111");
		map.put("ccc", "111");
		map.put("sss", "111");
		map.put("fff", "111");
//
		String get = doGet("http://localhost:8080/get", map);
		System.out.println("测试get map 2  " + get);

		String post = doPost("http://localhost:8080/post", map);
		System.out.println("测试post map 2  " + post);

		String mapS = doput("http://localhost:8080/put", map);
		System.out.println("测试put map 2  " + mapS);

		// delete测试
		String delete = DELETE("http://localhost:8080/users/user/4", null);
		System.out.println("测试delete map 2  " + delete);

	}
}
