package java.demo;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
import java.util.OtherUtil;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

/**
 * @author bc
 * @date 2018年7月3日下午4:15:10
 * @tags
 */
public class dom4jTest {

	public static final String USER_HOME = System.getProperty("user.home") + File.separator + "bonc_template"
			+ File.separator;

	/**
	 * @param args
	 * @throws DocumentException
	 * @throws MalformedURLException
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Document document = OtherUtil.readFile(USER_HOME + "/temp.xml");
		Element root = document.getRootElement();
		System.out.println(root.getNodeTypeName());
		System.out.println(root.elementText("folder"));
		List<Element> temps = root.elements();// 模板
		for (Element temp : temps) {
			System.out.println("---" + temp.attributeValue("name"));
			System.out.println("---" + temp.attributeValue("id"));
			System.out.println("---" + temp.attributeValue("description"));
			isFolder(temp);
		}

	}

	// 是否为文件夹
	@SuppressWarnings("unchecked")
	public static String isFolder(Element element) {
		System.out.println("+++++++" + element.getName());
		List<Element> elms = element.elements();
		for (Element elm : elms) {
			if ("folder".equals(elm.getName())) {
				System.out.println("folder:" + elm.attributeValue("name"));
				return isFolder(elm);
			} else if ("file".equals(elm.getName())) {
				System.out.println("file-name:" + elm.attributeValue("name"));
				System.out.println("file-path:" + elm.attributeValue("path"));
				System.out.println("file-description:" + elm.attributeValue("description"));
				List<Element> fileArgs = elm.elements();
				for (Element arg : fileArgs) {
					System.out.println("arg:" + arg.attributeValue("name"));
					System.out.println("value:" + arg.getStringValue());
				}
			}

		}
		return "";
	}

}
