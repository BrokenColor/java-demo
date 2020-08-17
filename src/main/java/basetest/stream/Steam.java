package basetest.stream;

import java.util.stream.IntStream;

/**
 * Description: 验证stream流的处理方式
 * <p>
 * Author: GWL
 * Date: Create in 9:56 2020/7/28
 */
public class Steam {

    /**
     * 中间操作是懒惰的，也就是中间操作不会对数据做任何操作，直到遇到了最终操作。
     * 而最终操作，都是比较热情的。他们会往前回溯所有的中间操作。
     * 也就是当执行到最后的forEach操作的时候，它会回溯到它的上一步中间操作，
     * 上一步中间操作，又会回溯到上上一步的中间操作，...，直到最初的第一步。
     * <p>
     * A1B1C1
     * A2B2C2
     * A3B3C3
     *
     * @param args
     */
    public static void main(String[] args) {
        IntStream.range(1, 10)
                .peek(x -> System.out.print("\nA" + x))
                .limit(3)
                .peek(x -> System.out.print("B" + x))
                .forEach(x -> System.out.print("C" + x));
    }
}
