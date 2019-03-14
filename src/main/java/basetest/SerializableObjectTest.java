package basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 描述：序列化，反序列化测试
 *  得到的结果：
 * 1、序列化之后保存的是类的信息
 * 2、被声明为transient的属性不会被序列化，这就是transient关键字的作用
 * 3、被声明为static的属性不会被序列化，这个问题可以这么理解，序列化保存的是对象的状态，
 * 但是static修饰的变量是属于类的而不是属于变量的，因此序列化的时候不会序列化它
 * 
 * @author BrokenColor
 * @date 2019年3月6日
 */
public class SerializableObjectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		File file = new File("d:" + File.separator + "s.test");
		// 序列化
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(new SerializableObject("str0", "str1"));
		System.out.println("对象序列化成功");
		oos.close();

		// 反序列化
		InputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		SerializableObject so = (SerializableObject) ois.readObject();
		System.out.println("对象属性Str0:" + so.getStr0());
		System.out.println("对象属性Str1:" + so.getStr1());
		ois.close();
	}

}
