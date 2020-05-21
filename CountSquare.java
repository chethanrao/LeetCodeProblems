/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.

 

Constraints:

    1 <= arr.length <= 300
    1 <= arr[0].length <= 300
    0 <= arr[i][j] <= 1
*/
class Solution {
    public int countSquares(int[][] matrix) {
        int count=0;
        for (int i=0;i<matrix.length;i++){
            for (int k=0;k<matrix[0].length;k++){
                if (matrix[i][k]==1){
                    if (i>=1 && k>=1){
                            matrix[i][k]=Math.min(matrix[i-1][k-1],Math.min(matrix[i-1][k],matrix[i][k-1]))+1;   
                    }
                    count=count+matrix[i][k];
                }
            }
        }  
        return count;
    }
}
