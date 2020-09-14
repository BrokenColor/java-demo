package basetest.collections.map;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * hashMap 遍历方式性能测试
 *
 * @Author: bc
 * @DateTime: 2020/9/14 上午10:52
 * @Description: TODO
 * 使用 Oracle 官方提供的性能测试工具 JMH（Java Microbenchmark Harness，JAVA 微基准测试套件）
 * 测试一下这 7 种循环的性能。
 */
@BenchmarkMode(Mode.Throughput)// 测试类型：吞吐量
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)//// 预热 2 轮，每次 1s
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)// 测试 5 轮，每次 3s
@Fork(1)//fork 1 个线程
@State(Scope.Thread)// 每个测试线程一个实例
public class HashMapCycle {
    //初始化HashMap
    static Map<Integer, String> map = new HashMap() {{
        // 添加数据
        for (int i = 0; i < 10; i++) {
            put(i, "val:" + i);
        }
    }};

    public static void main(String[] args) throws RunnerException {
        //启动基准测试
        OptionsBuilder builder = new OptionsBuilder();
        builder.include(HashMapCycle.class.getSimpleName())// 要导入的测试类
                .output("log/jmh-map.log") // 输出测试结果的文件
                .build();
        new Runner(builder).run();// 执行测试
    }

    @Benchmark
    public void entrySet() {
        // 遍历
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    @Benchmark
    public void keySet() {
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }

    @Benchmark
    public void forEachEntrySet() {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    @Benchmark
    public void forEachKeySet() {
        for (Integer key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }

    @Benchmark
    public void lambda() {
        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }

    @Benchmark
    public void streamApi() {
        map.entrySet().stream().forEach((entry)->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }
    @Benchmark
    public void parallelStreamApi() {
        map.entrySet().parallelStream().forEach((entry)->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }
}
