package basetest.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:简单用LinkedHashMap来实现的LRU算法的缓存
 * <p>
 * Author: GWL
 * Date: Create in 11:14 2020/8/17
 */

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRUCache(int cacheSize) {
        //如果accessOrder为true的话，则会把访问过的元素放在链表后面，放置顺序是访问的顺序
        //如果accessOrder为flase的话，则按插入顺序来遍历
        super(16, (float) 0.75, true);
        this.cacheSize = cacheSize;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}
