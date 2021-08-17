package basetest.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guwanli
 * @date 2021/8/16 8:43 下午
 */
public class StreamEmpty {
    public static void main(String[] args) {
        //list为空会报错吗
        List<String> list = new ArrayList<>();
        list.forEach(System.out::println);
    }
}
