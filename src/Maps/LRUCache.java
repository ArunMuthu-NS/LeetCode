package Maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    static class LRUCache_1 {
        private int size;
        private LinkedHashMap<Integer, Integer> map;

        public LRUCache_1(int capacity) {
            this.size = capacity;
            this.map = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            if(map.get(key) == null) return -1;
            int value = map.remove(key);
            map.put(key, value);
            return value;
        }

        public void put(int key, int value) {
            if(map.get(key) != null) {
                map.remove(key);
                map.put(key, value);
            }
            else if(map.size() == size) {
                Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
                map.remove(entry.getKey());
                map.put(key, value);
            }
            else
                map.put(key, value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

    public static void main(String args[]) {
        LRUCache_1 cache = new LRUCache_1(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);
    }
}
