package basetest;

import java.io.Serializable;

/**
 * 描述：序列化，反序列化测试
 * 
 * 序列化：将一个对象转换成一串二进制表示的字节数组，通过保存或转移这些字节数据来达到持久化的目的。
 * 反序列化：将字节数组重新构造成对象。
 * 
 * @author BrokenColor
 * @date 2019年3月6日
 */
public class SerializableObject implements Serializable {
	/**
	 * 序列化只需要实现java.io.Serializable接口就可以了。
	 * 序列化的时候有一个serialVersionUID参数，Java序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。
	 *  在进行反序列化，Java虚拟机会把传过来的字节流中的serialVersionUID和本地相应实体类的serialVersionUID进行比较，
	 *   如果相同就认为是一致的实体类，可以进行反序列化，否则Java虚拟机会拒绝对这个实体类进行反序列化并抛出异常。
	 *   serialVersionUID有两 种生成方式：
	 * 1、默认的1L
	 * 2、根据类名、接口名、成员方法以及属性等来生成一个64位的Hash字段
	 */
	private static final long serialVersionUID = 1L;
	
	private String str0;
	private transient String str1;
	private static String str2 = "abc";
	
	/**	
	 * @param str0
	 * @param str1
	 */
	public SerializableObject(String str0, String str1) {
		this.str0 = str0;
		this.str1 = str1;
	}

	public String getStr0() {
		return str0;
	}

	public String getStr1() {
		return str1;
	}
}
