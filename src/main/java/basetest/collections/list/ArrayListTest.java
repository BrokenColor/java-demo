package basetest.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: bc
 * @DateTime: 2019/12/11 下午4:53
 * @Description: ArrayList Test
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.get(0));
        System.out.println(list.get(4));
        System.out.println(list.size());

        System.out.println("==========");
        String[] strings = new String[5];
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        System.out.println("++++++++++");
        int n = 8;
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                lists.get(i).add(".");
            }
        }
        AtomicInteger atomi = new AtomicInteger();
        lists.forEach(item -> {
            System.out.print(atomi.getAndIncrement()+":");
            item.forEach(System.out::print);
            System.out.println();
        });

        System.out.println("---------");
        List<String> listq = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                stringBuilder.append(".");
            }
            listq.add(stringBuilder.toString());
        }
        listq.forEach(System.out::println);
    }
}