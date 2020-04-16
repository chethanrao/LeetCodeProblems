/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
*/
class Solution {
    public int candy(int[] ratings) {
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<Map.Entry<Integer,Integer>>((a,b)->(a.getValue()-b.getValue()));
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
       for (int i=0;i<ratings.length;i++){
           map.put(i,ratings[i]);
       }   
    
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.offer(entry);
        }
        
        int[] finalCandies=new int[ratings.length];
        int count=0;
        while (!pq.isEmpty()){
            Map.Entry<Integer,Integer> entry=pq.poll();
            int key=entry.getValue();
            int index=entry.getKey();
            if (index==0 && index==finalCandies.length-1){
                finalCandies[index]=1;
            }
            else if (index==0){
                if (ratings[index]==ratings[index+1]){
                    finalCandies[index]=1;
                }
                else {
                    finalCandies[index]=finalCandies[index+1]+1;
                }
            }
            else if (index==finalCandies.length-1){
                if (ratings[index]==ratings[index-1]){
                    finalCandies[index]=1;
                }
                else {
                    finalCandies[index]=finalCandies[index-1]+1;
                }
            }
            else {
                if (ratings[index]==ratings[index-1] && ratings[index]==ratings[index+1]){
                    finalCandies[index]=1;
                }
                else if (ratings[index]==ratings[index-1]){
                    finalCandies[index]=finalCandies[index+1]+1;
                }
                else if (ratings[index]==ratings[index+1]){
                    finalCandies[index]=finalCandies[index-1]+1;
                }
                else {
                    finalCandies[index]=Math.max(finalCandies[index-1],finalCandies[index+1])+1;
                }
            }
            count=count+finalCandies[index];
        }
        return count;
        
        
        
    }
    
     
}
