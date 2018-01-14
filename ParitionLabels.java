/*A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.*/



class PartitionLabels {
   
   public List<Integer> partitionLabels(String S) {
        
        List<Integer> list=new ArrayList<Integer>();

    
        
        HashMap<Character,Integer> hashMap=new HashMap<Character,Integer>();
        
        for (int i=0;i<S.length();i++){
          
          hashMap.put(S.charAt(i),i);
            
        }
        
        
        int highMax=hashMap.get(S.charAt(0));
        
        int low=0;
        
        
        for (int i=0;i<S.length();i++){
        
            int currMax=hashMap.get(S.charAt(i));
    
            if (i<=highMax && i!=S.length()-1){
 
                if (currMax>highMax)
              
                    highMax=currMax;
                
            }
            else {
                
                list.add(highMax-low+1);
                   
                if (S.length()-1==highMax+1){
                    list.add(1);
                }
               
                low=i;
            
                highMax=currMax;
         
            }

        }
        
        return list;
    }
        
}
