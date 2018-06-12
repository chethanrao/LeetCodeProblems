/*
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], 
return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]
*/

class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
	List<String> list=new ArrayList<String>();
    int prev=lower;
    for (int i=0;i<nums.length;i++){
		if (nums[i]<prev)
			continue;
		if (nums[i]==prev){
            if (prev!=2147483647)
                prev++;
			continue;
		}

		list.add(getRange(prev,nums[i]-1));
        if (nums[i]<2147483647)
		    prev=nums[i]+1;
        else
            prev=2147483647;
        
	}
	
	if (prev!=2147483647 && prev<=upper)
		list.add(getRange(prev,upper));

    return list;
    }

   String getRange(int lower,int upper){
	if (lower==upper)
		return  ""+lower;
	else
		return  lower+"->"+upper;
  }
}
