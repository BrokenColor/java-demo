package demo;

/**
 * 描述：String使用equals和==比较的区别
 * 
 * @author BrokenColor
 * @date 2018年10月18日
 */
public class StringTest {

	public static void main(String[] args) {
		// String作为一个对象来使用
		// 例子一：对象不同，内容相同，"=="返回false，equals返回true
		String a = new String("java");
		String b = new String("java");
		System.out.println("=============");
		System.out.println(a == b); // false
		System.out.println(a.equals(b)); // true

		// 例子二：同一对象，"=="和equals结果相同
		String c = new String("java");
		String d = c;
		System.out.println("=============");
		System.out.println(c == d); // true
		System.out.println(c.equals(d)); // true

		// -------------------------------------
		// String作为一个基本类型来使用

		// 如果String缓冲池内不存在与其指定值相同的String对象，那么此时虚拟机将为此创建新的String对象，并存放在String缓冲池内。
		// 如果String缓冲池内存在与其指定值相同的String对象，那么此时虚拟机将不为此创建新的String对象，而直接返回已存在的String对象的引用。
		String str1 = "java";
		String str2 = "java";
		System.out.println("=============");
		System.out.println(str1 == str2); // true
		System.out.println(str1.equals(str2)); // true
		
		//-------------
		
		String s1 = new String ("java");
		String s2 = "java";
		System.out.println("=============");
		System.out.println(s1==s2); //false
		System.out.println(s1.equals(s2)); //true
	}
}
