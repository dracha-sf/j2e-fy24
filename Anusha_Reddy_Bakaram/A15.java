import java.util.*;
class A15{
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
        pq.add(nums[i]);
        }
        for(int i=0;i<=nums.length-k-1;i++){
       pq.remove();
        } 
        return pq.peek();
    }
}
