/*
DESIGN A DATA STRUCTURE THAT WORKS LIKE A LRU CACHE. HERE CAP DENOTES THE CAPACITY OF
THE CACHE AND Q DENOTES THE NUMBER OF QUERIES. QUERY CAN BE OF TWO TYPES:
 */
package salesforce.stack_and_queue;
import java.util.*;

class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


public class problem4 {
    
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public problem4(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private void insertNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            insertNode(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            insertNode(node);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insertNode(newNode);
            if (cache.size() > cap) {
                Node tailNode = tail.prev;
                removeNode(tailNode);
                cache.remove(tailNode.key);
            }
        }
    }
}
