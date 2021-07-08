package basetest.LRUCache;

import java.util.HashMap;
import java.util.Map;
/**
 * Description:
 * <p>
 * Author: GWL
 * Date: Create in 18:39 2021/7/8
 */

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int capacity;
    private DLinkedNode head; //头节点
    private DLinkedNode tail; //尾节点

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        moveToHead(node);
        //返回值
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null){//不存在
            //创建一个节点
            node = new DLinkedNode(key, value);
            //添加到表头
            addHead(node);
            //添加到map中
            cache.put(key,node);
            if (cache.size() > capacity){
                //删除队尾元素
                int deleteTailKey = deleteTail();
                //map中删除元素
                cache.remove(deleteTailKey);
            }
        }else{//存在该节点
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 添加node节点到链表头
     * @param node
     */
    public void addHead(DLinkedNode node){
        if (node == null) return;

        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 移动节点到链表头
     * @param node
     */
    public void moveToHead(DLinkedNode node){
        //删除节点
        deteleNode(node);
        //添加到表头
        addHead(node);
    }

    /**
     * 删除node节点
     * @param node
     */
    public void deteleNode(DLinkedNode node){
        if (node == null) return;

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int deleteTail(){
        if (head.next == tail) return -1;

        int DeletKey = tail.prev.key;
        deteleNode(tail.prev);
        return DeletKey;
    }



}
//定义节点
class DLinkedNode{
    DLinkedNode next;
    DLinkedNode prev;
    int key;
    int value;

    public DLinkedNode(){}
    public DLinkedNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
