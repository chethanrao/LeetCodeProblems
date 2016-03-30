package javaproject;

public class Island {
	static int  findIsland(int a[][]){
		   
	      int island=0;
	      for (int i=0;i<a.length;i++) {
	         for (int j=0;j<a[i].length;j++){
	            
	            if (a[i][j]==1){
	               island=island+1;
	               dfs(a,i,j);  
	            }
	         } 
	      
	      
	   }
	   return island;
	   
	}

	static void dfs(int a[][], int i, int j){
	   
	   if (a[i][j]==0 || a[i][j]==2)
	      return;
	   a[i][j]=2;
	      
	   if (i+1<a.length)
	      dfs(a,i+1,j);
	   
	   if (i-1>=0)
	      dfs(a,i-1,j);
	   
	   if (j+1<a[i].length)
	      dfs(a,i,j+1);

	   if (j-1>=0)
	      dfs(a,i,j-1);
	   return;

	}

   public static void main(String[] args) {
      String pramp = "Practice Makes Perfect";
      System.out.println(pramp);
      
      //Objective of this code is to find number of islands in the array below
      //island is represented by a single 1's or a group of 1's which are adjacent to each other either vertically or horizontally
      int[][] multi = new int[][]{
    	  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	  { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 },
    	  { 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
    	  { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
    	  { 0, 0, 0, 0, 1, 1, 1, 1, 1, 0 }
    	  
    	};

    	System.out.println(findIsland(multi));
   }
   
}
   
