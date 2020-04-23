/*
Given a 2-dimensional grid of integers, each value in the grid represents the color of the grid square at that location.

Two squares belong to the same connected component if and only if they have the same color and are next to each other in any of the 4 directions.

The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).

Given a square at location (r0, c0) in the grid and a color, color the border of the connected component of that square with the given color, and return the final grid.

 

Example 1:

Input: grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
Output: [[3, 3], [3, 2]]
Example 2:

Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
Output: [[1, 3, 3], [2, 3, 3]]
Example 3:

Input: grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
Output: [[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 

Note:

1 <= grid.length <= 50
1 <= grid[0].length <= 50
1 <= grid[i][j] <= 1000
0 <= r0 < grid.length
0 <= c0 < grid[0].length
1 <= color <= 1000
*/
class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int[][] finalGrid=new int[grid.length][grid[0].length];
        
        colorBorder(grid,finalGrid,r0,c0,color);
        for (int i=0;i<grid.length;i++){
            for (int k=0;k<grid[0].length;k++){
                if (finalGrid[i][k]==0 || finalGrid[i][k]==-1)
                    finalGrid[i][k]=grid[i][k];
            }
        }
        return finalGrid;    
    }
    
    public void colorBorder(int[][] grid,int[][] finalGrid,int r0,int c0,int color){
        if (!isValid(grid,r0,c0) || finalGrid[r0][c0]!=0){
            return;
        }
        finalGrid[r0][c0]=-1;
     
        int count=0;   
        if (isValid(grid,r0-1,c0) && grid[r0][c0]==grid[r0-1][c0]){
            count++;
            colorBorder(grid,finalGrid,r0-1,c0,color);
        }
        
        if (isValid(grid,r0+1,c0) && grid[r0][c0]==grid[r0+1][c0]){
            count++;
            colorBorder(grid,finalGrid,r0+1,c0,color);
        }
        
         
        if (isValid(grid,r0,c0-1) && grid[r0][c0]==grid[r0][c0-1]){
            count++;
            colorBorder(grid,finalGrid,r0,c0-1,color);
        }
        
        if (isValid(grid,r0,c0+1) && grid[r0][c0]==grid[r0][c0+1]){
            count++;
            colorBorder(grid,finalGrid,r0,c0+1,color);
        }
        
        if (count!=4){
            finalGrid[r0][c0]=color;
        }
        
        
    }
    
    
    public boolean isValid(int[][] grid,int r0,int c0){
         if (r0<0 || c0<0 || r0>=grid.length || c0>=grid[0].length){
            return false;
        }
        return true;
    }
}
