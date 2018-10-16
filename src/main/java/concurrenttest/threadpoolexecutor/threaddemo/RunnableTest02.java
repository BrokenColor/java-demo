package concurrenttest.threadpoolexecutor.threaddemo;

/**
 * 描述：线程
 * 
 * @author BrokenColor
 * @date 2018年10月15日
 */
public class RunnableTest02 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
			String newstring = new String();
			Math.random();
			Math.random();
			Math.random();
			Math.random();
			Math.random();
			Math.random();
			// 使用该方法将中断所有的任务（包括正在执行和还未执行的任务）
			// if (Thread.currentThread().isInterrupted()) {
			// System.out.println("任务没有完成，就中断了！");
			// throw new InterruptedException();
			// }
		}
		System.out.println(Thread.currentThread().getName()+" 任务成功完成!");
	}

}
