package java.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.MalformedURLException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class OtherUtil {
	public static final String UTF8 = "utf-8";
	public static String path(String path) {
		return path.replaceAll("\\\\", "\\/");
	}
		
	public static String getUserHomePath() {
//		String userHome = System.getProperty("user.home");
	
	    String userHome= System.getProperty("user.dir");
	 
		String temPath=GetTemplatesDir.getTemplatesDir(userHome+"/features","com.bonc.ares");//myfeature为feature项目名
		System.out.println("userHome:"+userHome);
		return path(temPath);
	}
	
	public static String readFileAsString(String fileName) {
		String content = "";
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				return content;
			}
			content = new String(readFileBinary(fileName), UTF8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return content;
	}
	public static byte[] readFileBinary(String fileName) {
		byte[] rst = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(fileName);
			rst = readFileBinary(fin);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return rst;
	}
	public static byte[] readFileBinary(InputStream streamIn) throws IOException {
		BufferedInputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			in = new BufferedInputStream(streamIn);
			out = new ByteArrayOutputStream(10240);
			int len;
			byte buf[] = new byte[1024];
			while ((len = in.read(buf)) >= 0)
				out.write(buf, 0, len);
			byte[] rst = out.toByteArray();
			return rst;
		} finally {
			try {
				if (null != in)
					in.close();
			} catch (IOException e) {
			}
			try {
				if (null != out)
					out.close();
			} catch (IOException e) {
			}
		}
	}
	public static Document readFile(String fileName) throws MalformedURLException, DocumentException {
		return loadXml(OtherUtil.readFileAsString(fileName));
	}
	public static String format(Document doc) {
		doc.setXMLEncoding("utf-8");
		Writer stringWriter = new StringWriter();
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(stringWriter, format);
		try {
			xmlWriter.write(doc);
			return stringWriter.toString().replace("?>\n", "?>");
		} catch (IOException e) {
			e.printStackTrace();
			return doc.asXML();
		} finally {
			try {
				if (null != xmlWriter) {
					xmlWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//loadXml 通过字符串生成Dom4J.Document
	public static Document loadXml(String text) throws MalformedURLException, DocumentException {
		if (StringUtil.isEmpty(text)) {
			return null;
		}
		return DocumentHelper.parseText(text);
	}
	public static void main(String[] args) {		
	      String sysPro = System.getProperty("user.dir");
	      System.out.println(sysPro);
	
}
	
}
