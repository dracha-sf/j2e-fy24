package stackandqueueassignment;
import java.util.*;
    class LRUCache 
    {
    private Map<Integer, Integer> cache;
    private Deque<Integer> lruQueue;
    private int capacity;

    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        cache = new HashMap<>();
        lruQueue = new LinkedList<>();
    }

    public int get(int key) 
    {
        if (cache.containsKey(key)) 
        {
            // Move the key to the front of the queue (recently used)
            lruQueue.remove(key);
            lruQueue.addFirst(key);
            return cache.get(key);
        }
        return -1;
    }

    public void set(int key, int value) 
    {
        if (cache.containsKey(key)) 
        {
            // Update the existing key
            cache.put(key, value);
            // Move the key to the front of the queue (recently used)
            lruQueue.remove(key);
            lruQueue.addFirst(key);
        } 
        else 
        {
            if (lruQueue.size() == capacity) 
            {
                // Cache is full, remove the least recently used key
                int lastKey = lruQueue.removeLast();
                cache.remove(lastKey);
            }
            // Add the new key to the cache and front of the queue
            cache.put(key, value);
            lruQueue.addFirst(key);
        }
    }
    public static void main(String[] args) 
    {
        LRUCache cache = new LRUCache(2);

        cache.set(1, 2);
        System.out.println(cache.get(1)); // Output: 2
        
        cache.set(1, 2);
        cache.set(2, 3);
        cache.set(1, 5);
        cache.set(4, 5);
        cache.set(6, 7);
        System.out.println(cache.get(4)); // Output: 5

        cache.set(1, 2);
        System.out.println(cache.get(3)); // Output: -1
    }
}
