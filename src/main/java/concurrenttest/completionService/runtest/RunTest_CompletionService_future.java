package concurrenttest.completionService.runtest;

import java.util.concurrent.CompletionService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import concurrenttest.completionService.callabledemo.Runable_TestUserinfo;
import concurrenttest.completionService.callabledemo.UserInfo;

/**
 * 描述：测试Future<V> 的submit(Runnable task, V result)
 * 	参数v是submit方法的返回值
 * @author BrokenColor
 * @date 2018年12月20日
 */
public class RunTest_CompletionService_future {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UserInfo userInfo = new UserInfo();
			Runable_TestUserinfo runable =new Runable_TestUserinfo(userInfo);
			Executor executor = Executors.newCachedThreadPool();
			CompletionService<UserInfo> cs = new ExecutorCompletionService<>(executor);
			Future<UserInfo> future = cs.submit(runable,userInfo);
			System.out.println(future.get().getUsername()+" "+future.get().getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
