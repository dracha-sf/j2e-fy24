package linkedlistassignmentquestions;
import java.util.HashMap;
import java.util.Map;

class Node 
{
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) 
    {
        this.key = key;
        this.value = value;
    }
}

class LRUCache 
{
    private final int capacity;
    private final Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public int get(int key) 
    {
        if (cache.containsKey(key)) 
        {
            Node node = cache.get(key);
            removeNode(node);
            addNodeToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) 
    {
        if (cache.containsKey(key)) 
        {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addNodeToHead(node);
        } 
        else 
        {
            if (cache.size() == capacity) 
            {
                cache.remove(tail.key);
                removeNode(tail);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNodeToHead(newNode);
        }
    }

    private void addNodeToHead(Node node) 
    {
        node.next = head;
        node.prev = null;
        if (head != null) 
        {
            head.prev = node;
        } 
        else 
        {
            tail = node;
        }
        head = node;
    }

    private void removeNode(Node node) 
    {
        if (node.prev != null) 
        {
            node.prev.next = node.next;
        }
        else 
        {
            head = node.next;
        }

        if (node.next != null)
        {
            node.next.prev = node.prev;
        } 
        else
        {
            tail = node.prev;
        }
    }

    public static void main(String[] args) 
    {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // cache is {1=1}
        lruCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lruCache.get(1)); // return 1
        lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lruCache.get(2)); // returns -1 (not found)
        lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lruCache.get(1)); // return -1 (not found)
        System.out.println(lruCache.get(3)); // return 3
        System.out.println(lruCache.get(4)); // return 4
    }
}
