/*
Given a non-empty array of integers, return the third maximum number in this array. 
If it does not exist, return the maximum number. The time complexity must be in O(n).

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

*/

class ThirdMax {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
        Set<Integer> set=new HashSet<Integer>();
        
        for (int num:nums){
            
            if (set.contains(num))
                    continue;
            
            queue.add(num);
            set.add(num);
            
            if (queue.size()>3){
                queue.remove(queue.peek());
                set.remove(queue.peek());
            }
        }
        
        if (set.size()==2){
           queue.remove(queue.peek());
        }
            
        return queue.peek();
    }
}
