package basetest;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * <p>
 * Author: GWL
 * Date: Create in 15:47 2021/7/6
 */
public class LinkedTest {

    public static void main(String[] args) {
        Map map = new HashMap<String,String>();

    }

    public void m1(Node node){
        Node pre = null, next = null;
        while (node != null){
            next = node.next;

            node.next = pre;

            pre = node;

            node = next;
        }
    }

}



class Node{
    int val;
    Node next;
}
