/*


Difficulty: Medium
Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days 
you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> stack=new Stack<Integer>();
        
        stack.push(0);
        
        for (int k=1;k<temperatures.length;k++){            
            
            
            
            while (true){
                if (stack.empty())
                    break;
                
                int index=stack.peek();

          
                if (temperatures[k]<=temperatures[index]){
                    break;
                 }
                stack.pop();
                
                temperatures[index]=k-index;  
            
             }
            
            stack.push(k);

        }
            
            while (!stack.empty() && temperatures.length>1){
                             
                 temperatures[stack.pop()]=0;
                
            }
            return temperatures;
        }
        
       
    }
