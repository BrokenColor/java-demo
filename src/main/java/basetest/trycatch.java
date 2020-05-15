package basetest;

/**
 * 描述：try-catch -finally 测试
 * finally块中的代码一定会执行
 * 
 * @author BrokenColor
 * @date 2019年1月10日
 */
public class trycatch {

	public static void main(String[] args) {
		try {
			System.out.println("aaa");
//			throw new Exception("我报错了");
			return ;
//			System.out.println("bb");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally");
		}

	}

}
