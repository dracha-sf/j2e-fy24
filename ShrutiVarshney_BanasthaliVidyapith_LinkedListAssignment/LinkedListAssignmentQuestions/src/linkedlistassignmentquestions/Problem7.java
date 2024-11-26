package linkedlistassignmentquestions;
class MyCircularDeque 
{
    private int[] deque;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public MyCircularDeque(int k) 
    {
        deque = new int[k];
        front = 0;
        rear = 0;
        capacity = k;
        count = 0;
    }

    public boolean insertFront(int value) 
    {
        if (isFull()) 
        {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        count++;
        return true;
    }

    public boolean insertLast(int value) 
    {
        if (isFull()) 
        {
            return false;
        }
        deque[rear] = value;
        rear = (rear + 1) % capacity;
        count++;
        return true;
    }

    public boolean deleteFront()
    {
        if (isEmpty()) 
        {
            return false;
        }
        front = (front + 1) % capacity;
        count--;
        return true;
    }

    public boolean deleteLast() 
    {
        if (isEmpty()) 
        {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        count--;
        return true;
    }

    public int getFront() 
    {
        if (isEmpty()) 
        {
            return -1;
        }
        return deque[front];
    }

    public int getRear() 
    {
        if (isEmpty()) 
        {
            return -1;
        }
        return deque[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() 
    {
        return count == 0;
    }

    public boolean isFull() 
    {
        return count == capacity;
    }

    public static void main(String[] args) 
    {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1)); // return true
        System.out.println(myCircularDeque.insertLast(2)); // return true
        System.out.println(myCircularDeque.insertFront(3)); // return true
        System.out.println(myCircularDeque.insertFront(4)); // return false, the queue is full.
        System.out.println(myCircularDeque.getRear()); // return 2
        System.out.println(myCircularDeque.isFull()); // return true
        System.out.println(myCircularDeque.deleteLast()); // return true
        System.out.println(myCircularDeque.insertFront(4)); // return true
        System.out.println(myCircularDeque.getFront()); // return 4
    }
}

