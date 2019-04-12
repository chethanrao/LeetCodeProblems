/*Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.*/


import java.math.BigDecimal;

class Solution {
    public String largestNumber(int[] nums) {
        
	for (int i=0;i<nums.length;i++)
	for (int k=i+1;k<nums.length;k++){
		if (!compareIfFirstNumberFormsBiggerNumber(nums[i],nums[k])){
			
			swap(nums,i,k);
		}

	}
	
	StringBuilder builder=new StringBuilder();

	for (int i=0;i<nums.length;i++){
        if (nums[0]==0){
            return "0";
        }

		builder.append(nums[i]);
	}
        
	return builder.toString();
}


    
    
    public boolean compareIfFirstNumberFormsBiggerNumber(int num1,int num2){
        BigDecimal bigD1=new BigDecimal(num1 +""+num2);
        BigDecimal bigD2=new BigDecimal(num2 +""+num1);
	
        if (bigD1.compareTo(bigD2)>0){
	return true;
      }
     else{

		return false;
    }


    }

   public void swap(int[] nums,int i,int k){
	int temp=nums[i];

	nums[i]=nums[k];

	nums[k]=temp;

  }
}

