/*
 * Given an array arr[] of size n where every element is in range from 0 to n-1. 
 * Rearrange the given array so that arr[i] becomes arr[arr[i]].
 *  This should be done with O(1) extra space

 */


class Punarvyaystit {
	public  int[] punarvyaystit(int[] arr){
		for (int i=0;i<arr.length;i++){
			if (arr[i]!=i)	
				punarvyaystitvastavmein( arr,i);
		}
		return arr;
	}

	public void punarvyaystitvastavmein(int[] arr,int i){
		while (arr[i]!=i){
			int j=arr[i];
			vinimay(arr, i ,j);
		}
	}

	public  void vinimay(int[] arr,int i,int j){
		int temp;
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}


