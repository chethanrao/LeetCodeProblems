/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/


public class Solution {
    public int maxProduct(int[] nums) {
        int prevMax=nums[0],prevMin=nums[0],maxProduct=nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]>0){
                prevMax=Math.max(nums[i],prevMax*nums[i]);
                prevMin=Math.min(nums[i],prevMin*nums[i]);
            }
            else{
                int temp=prevMax;
                prevMax=Math.max(nums[i],prevMin*nums[i]);
                prevMin=Math.min(nums[i],temp*nums[i]);
            }
             
            maxProduct=Math.max(maxProduct,prevMax);
        }
        return maxProduct;
    }
}
