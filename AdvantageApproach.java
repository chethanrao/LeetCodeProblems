/*
Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.

 

Example 1:

Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]

Example 2:

Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]

 

Note:

    1 <= A.length = B.length <= 10000
    0 <= A[i] <= 10^9
    0 <= B[i] <= 10^9

*/
class Solution {
 public int[] advantageCount(int[] A, int[] B) {
    TreeMap<Integer,Integer> treeMap=getTreeMapFromArray(A);
	  int[] finalArray=new int[A.length];
	  Arrays.fill(finalArray,-1);
	  for (int i=0;i<A.length;i++){
		  if (treeMap.ceilingKey(B[i]+1)!=null){
			  int key=treeMap.ceilingKey(B[i]+1);
			  finalArray[i]=key;
			  treeMap.put(key,treeMap.get(key)-1);
			  if (treeMap.get(key)==0){
				  treeMap.remove(key);
			  }
		  }
	  }
	
	  int index=0;
	  while (index<finalArray.length){
		  if (finalArray[index]==-1){
			  for (int key:treeMap.keySet()){
				  finalArray[index]=key;
				  treeMap.put(key,treeMap.get(key)-1);
				  if (treeMap.get(key)==0){
					  treeMap.remove(key);
				  }
				  break;
			  }
		  }		

		  index++;
	    }

	    return finalArray;
    }
    
    TreeMap<Integer,Integer> getTreeMapFromArray(int[] array){
	    TreeMap<Integer,Integer> treeMap=new TreeMap<Integer,Integer>();
	    for (int i=0;i<array.length;i++){
		    treeMap.put(array[i],treeMap.getOrDefault(array[i],0)+1);
	    }
	    return treeMap;
    }
}
