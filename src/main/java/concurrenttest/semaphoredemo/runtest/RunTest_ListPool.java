package concurrenttest.semaphoredemo.runtest;

import concurrenttest.semaphoredemo.pojo.Thread_ListPool;
import concurrenttest.semaphoredemo.serviceImp.Semaphore_ListPool;

/**
 * 描述:创建pool池
 *
 * @author bc
 * @create 2018-09-11 15:31
 */
public class RunTest_ListPool {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Semaphore_ListPool service = new Semaphore_ListPool();

        Thread_ListPool[] arr = new Thread_ListPool[12];
        for (int i = 0; i < arr.length; i++) {
        	arr[i] = new Thread_ListPool(service);
        }
        for (int i = 0; i < arr.length; i++) {
        	arr[i].start();
		}
    }
}
