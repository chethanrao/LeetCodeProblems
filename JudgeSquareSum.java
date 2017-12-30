/*Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: 3
Output: False*/

class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        
        for (int i=0;i<=c;i++){
            long k= c - i*i;
            
            if (k<0)
                break;
            
            double sqrt=Math.sqrt(k);
            
            long x=(long)sqrt;
            
            if (x*x==k)
               return true;

        }
        
        return false;
    }
}
