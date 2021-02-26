package basetest;

import com.google.common.base.Splitter;

import java.util.List;

public class GuavaSplitter {
    public static void main(String[] args) {
        String str ="12";
        List list =Splitter.on(',').splitToList(str);
        System.out.println(list.size());
        System.out.println(list);
    }
}
