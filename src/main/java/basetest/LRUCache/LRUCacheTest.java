package basetest.LRUCache;

/**
 * Description:
 * LRU算法的思想是：如果一个数据在最近一段时间没有被访问到，那么可以认为在将来它被访问的可能性也很小。
 * 因此，当空间满时，最久没有访问的数据最先被置换（淘汰）。
 * <p>
 * Author: GWL
 * Date: Create in 11:22 2020/8/17
 */
public class LRUCacheTest {
    private static LRUCache<String, Integer> cache = new LRUCache<>(10);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            cache.put("k" + i, i);
        }
        System.out.println("all cache :" + cache );
        cache.get("k3");
        System.out.println("get k3 :" + cache );
        cache.get("k4");
        System.out.println("get k4:" + cache );
        cache.get("k4");
        System.out.println("get k4  :" + cache );
        cache.put("k" + 10, 10);
        System.out.println("After running the LRU algorithm cache :" + cache );
    }
}
