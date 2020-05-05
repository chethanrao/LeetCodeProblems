/*
K-Messed Array Sort

Given an array of integers arr where each element is at most k places away from its sorted position, code an efficient function sortKMessedArray that sorts arr. For instance, for an input array of size 10 and k = 2, an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.

Analyze the time and space complexities of your solution.

Example:

input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2

output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Constraints:

    [time limit] 5000ms

    [input] array.integer arr
        1 ≤ arr.length ≤ 100

    [input] integer k
        0 ≤ k ≤ 20

    [output] array.integer

*/
import java.io.*;
import java.util.*;

class Solution {

  static int[] sortKMessedArray(int[] arr, int k) {
    // your code goes here
    int[] newArr=new int[arr.length];
    PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->(a-b));
    int index=0;
    for (int i=0;i<arr.length;i++){
      pq.offer(arr[i]);
      if (pq.size()==k+1){
        newArr[index]=pq.poll();
        index++;
      }
    }
    while (!pq.isEmpty()){
        newArr[index]=pq.poll();
        index++;
    }
    return newArr;
  }

  public static void main(String[] args) {
    
    
  }

}
