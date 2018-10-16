package concurrenttest.threadpoolexecutor.threaddemo;

/**
 * 描述：线程
 * 
 * @author BrokenColor
 * @date 2018年10月15日
 */
public class RunnableTest03 implements Runnable {
	private String name;
	
	public RunnableTest03(String name) {
		this.name = name;
	}
	
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
		System.out.println(this.name +" 任务成功完成!");
	}

	public String getName() {
		return name;
	}

}
