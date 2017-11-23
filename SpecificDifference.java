/*Pairs with Specific Difference

Given an array arr of distinct integers and a nonnegative integer k, write a function findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr, such that x - y = k. If no such pairs exist, return an empty array.

In your solution, try to reduce the memory usage while maintaining time efficiency. Prove the correctness of your solution and analyze its time and space complexities.

Note: the order of the pairs in the output array doesn’t matter.

Examples:

input:  arr = [0, -1, -2, 2, 1], k = 1
output: [[0, -1], [-1, -2], [2, 1], [1, 0]]

input:  arr = [1, 7, 5, 3, 32, 17, 12], k = 17
output: []
Constraints:

[time limit] 5000ms

[input] array.integer arr

0 ≤ arr.length ≤ 100
[input]integer k

k ≥ 0
[output] array.array.integer*/

import java.io.*;
import java.util.*;

class Solution {

  static int[][] findPairsWithGivenDifference(int[] arr, int k) {
    // your code goes here
     Set<Integer> set=new HashSet<Integer>();
   
  int[][] answer=new int[arr.length][2];   
    
   int p=0;
    for (int i=0;i<arr.length;i++){
      if (set.contains(arr[i]-k)){
        answer[p][0]=arr[i];
        answer[p][1]=arr[i]-k;
        p++;
                
      }
      
      if (set.contains(k+arr[i])){
          answer[p][0]=arr[i];
          answer[p][1]=arr[i]+k;
          p++;
      }
    
      
        
      set.add(arr[i]);
    }
    
    
    return answer;
  }

  public static void main(String[] args) {

  }

}
