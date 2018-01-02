/*
You are standing at position 0 on an infinite number line. There is a goal at position target.

On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

Return the minimum number of steps required to reach the destination.

Example 1:
Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.
Example 2:
Input: target = 2
Output: 3
Explanation:
On the first move we step from 0 to 1.
On the second move we step  from 1 to -1.
On the third move we step from -1 to 2.
Note:
target will be a non-zero integer in the range [-10^9, 10^9].
*/

class ReachNumber {
    public int reachNumber(int target) {
        int step=0;
        int sum=0;
        target=Math.abs(target);
        
        // In this loop you greedly find the number of steps to reach the target
        while (sum<target){
            step++;
            sum=sum+step;
        }
        
        // In this loop you add extra steps to reach the target if the difference between sum and step to make sure sum is even
        // This makes sure that you can get back to the target by flipping one of the numbers.
        while ((sum-target)%2!=0){
            step++;
            sum=sum+step;
        }
        
        return step;
    }
}
