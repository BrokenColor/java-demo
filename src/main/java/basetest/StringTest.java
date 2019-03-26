package basetest;

import java.util.UUID;

/**
 * 描述：string test
 * 
 * @author BrokenColor
 * @date 2019年1月16日
 */
public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//截取测试
		String str0 = "A12300000";
		String str1 = "A12300000-12";
		str0.length();
		String[] strs0 = str0.split("-");
		String[] strs1 = str1.split("-");
		System.out.println("strs0 " +strs0.length);
		System.out.println("strs1 " +strs1.length);
		System.out.println(Integer.parseInt(strs1[1])+"1");
		
		//uuid测试
		String struuid = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(struuid.length());
		System.out.println(struuid);
		
		//TODO 不懂为何
		System.out.println("====================================");
		String s1 = new StringBuilder("go").append("od").toString();
		System.out.println(s1.intern() == s1);
		String s2 = new StringBuilder("ja").append("va").toString();
		System.out.println(s2.intern() == s2);
	}

}
