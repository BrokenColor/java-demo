package basetest;

/**
 * 描述：try-catch -finally 测试
 * finally块中的代码一定会执行
 * 
 * @author BrokenColor
 * @date 2019年1月10日
 */
public class TrycatchTest {

	public static void main(String[] args) {

		TrycatchTest test = new TrycatchTest();
		System.out.println(test.test());
	}

	public int test(){
		String str="init";
		int a=0;
		try {
			str="doing";
			Integer q=1;
			q.intValue();
//			return str;
			return a+1;
//			throw new Exception("我报错了");
//			System.out.println("bb");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			str="finally";
			return a+2;
		}
	}

}
