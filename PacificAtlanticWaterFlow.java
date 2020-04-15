/*
417. Pacific Atlantic Water Flow
Medium

1048

208

Add to List

Share
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:

The order of returned grid coordinates does not matter.
Both m and n are less than 150.
 

Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
*/

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
      List<List<Integer>> listOfLists=new ArrayList<List<Integer>>();
      if (matrix.length==0){
                return listOfLists;
       }
			int[][] finalMatrix=new int[matrix.length][matrix[0].length];
      for (int i=0;i<matrix.length;i++){
				updateValuesPacific(matrix,finalMatrix,i,0,Integer.MIN_VALUE,-1);
			}
			for (int i=0;i<matrix[0].length;i++){
				updateValuesPacific(matrix,finalMatrix,0,i,Integer.MIN_VALUE,-1);
			}
			for (int i=0;i<matrix.length;i++){
				updateValuesAtlantic(matrix,finalMatrix,i,matrix[0].length-1,Integer.MIN_VALUE,1);
			}
			for (int i=0;i<matrix[0].length;i++){
				updateValuesAtlantic(matrix,finalMatrix,matrix.length-1,i,Integer.MIN_VALUE,1);
			}
			for (int i=0;i<finalMatrix.length;i++){
			for (int k=0;k<finalMatrix[0].length;k++){
					if (finalMatrix[i][k]==2){
						List<Integer> list=new ArrayList<Integer>();
						list.add(i);
						list.add(k);
						listOfLists.add(list);
					}
				}
			}

			return listOfLists;

    }


	public void  updateValuesPacific(int[][] matrix,int[][] finalMatrix,int i,int k,int previousValue,int value){
		if (i<0 || k<0 || i>=matrix.length || k>=matrix[0].length){
			return;
		}

		if (finalMatrix[i][k]==0 && matrix[i][k]>=previousValue){
			finalMatrix[i][k]=value;
			updateValuesPacific(matrix,finalMatrix,i-1,k,matrix[i][k],value);
			updateValuesPacific(matrix,finalMatrix,i+1,k,matrix[i][k],value);
			updateValuesPacific(matrix,finalMatrix,i,k-1,matrix[i][k],value);
			updateValuesPacific(matrix,finalMatrix,i,k+1,matrix[i][k],value);
		}
	}


	public void  updateValuesAtlantic(int[][] matrix,int[][] finalMatrix,int i,int k,int previousValue,int value){
		if (i<0 || k<0 || i>=matrix.length || k>=matrix[0].length){
			return;
		}

		if ((finalMatrix[i][k]==-1 || finalMatrix[i][k]==0) && matrix[i][k]>=previousValue){
			if (finalMatrix[i][k]==-1){
			     finalMatrix[i][k]=2;
		  		 value=2;
			}
      else {
           finalMatrix[i][k]=1;            
      }
			updateValuesAtlantic(matrix,finalMatrix,i-1,k,matrix[i][k],value);
			updateValuesAtlantic(matrix,finalMatrix,i+1,k,matrix[i][k],value);
			updateValuesAtlantic(matrix,finalMatrix,i,k-1,matrix[i][k],value);
			updateValuesAtlantic(matrix,finalMatrix,i,k+1,matrix[i][k],value);
		}
				
	}

}	
