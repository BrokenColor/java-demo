package concurrenttest.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: bc
 * @DateTime: 2019/12/11 上午9:49
 * @Description: AtomicInteger Method Test
 */
public class AtomicIntegerMethodTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        //获取当前的值
        System.out.println("get():" + atomicInteger.get());
        //获取当前的值，并设置新的值
        System.out.println("getAndSet(1):" + atomicInteger.getAndSet(1) + ",current" + atomicInteger);
        //获取当前的值，并自增
        System.out.println("getAndIncrement():" + atomicInteger.getAndIncrement() + ",current" + atomicInteger);
        //获取当前的值，并自减
        System.out.println("getAndDecrement():" + atomicInteger.getAndDecrement() + ",current" + atomicInteger);
        //获取当前的值，并加上预期的值
        System.out.println("getAndAdd(1):" + atomicInteger.getAndAdd(1) + ",current" + atomicInteger);
        //如果输入的数值等于预期值，则以原子方式将该值设置为输入值（update）
        System.out.println("compareAndSet(2, 3):" + atomicInteger.compareAndSet(2, 3) + ",current" + atomicInteger);
        //最终设置为newValue,使用 lazySet 设置之后可能导致其他线程在之后的一小段时间内还是可以读到旧的值。
        atomicInteger.lazySet(2);
        System.out.println("lazySet:" + atomicInteger.get());
        //自增,返回自增后的结果
        System.out.println("incrementAndGet():" + atomicInteger.incrementAndGet() + ",current:" + atomicInteger);
        //自减,返回自减后的结果
        System.out.println("decrementAndGet():" + atomicInteger.decrementAndGet() + ",current:" + atomicInteger);
    }
}
