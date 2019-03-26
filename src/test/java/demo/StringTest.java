package demo;

/**
 * 描述：String使用equals和==比较的区别
 * 对于==：如果是基本类型变量，则直接比较其存储的值，
 * 		如果是引用类型，则比较的是所指向的对象的地址
 * 对于equals：注意：equals不能用于基础数据类型的变量
 * 		如果未对equals方法重新的话，则比较的是引用类型所指向的对象的地址
 * 		String，Date等类对equals进行了重写，比较的是所指向对象的内容
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
		//String对equals进行了重写
		System.out.println(a == b); // false
		//string类对equals方法进行了重写，用来比较指向的字符串对象所存储的的字符串是否相等
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
