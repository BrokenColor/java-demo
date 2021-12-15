package basetest.collections.list;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guwanli
 * @date 2021/12/15 17:46
 */
public class ListEquals {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.sort(String::compareTo);
        System.out.println(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("3");
        list2.add("2");
        list2.sort(String::compareTo);
        System.out.println(list2);
        System.out.println(ListUtils.isEqualList(list1, list2));
    }
}
