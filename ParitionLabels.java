class PartitionLabels {
   
   public List<Integer> partitionLabels(String S) {
        
        List<Integer> list=new ArrayList<Integer>();

        if (S.length()==1){
            
            list.add(1);
            
            return list;
        }
        
        if (S.length()==2){
         
            if (S.charAt(0)==S.charAt(1)){
            
                list.add(2);
                
                return list;
            }
            else {
                
                list.add(1);
                
                list.add(1);
                
                return list;
            }
            
        }
        
        HashMap<Character,Integer> hashMap=new HashMap<Character,Integer>();
        
        for (int i=0;i<S.length();i++){
          
          hashMap.put(S.charAt(i),i);
            
        }
        
        
        int highMax=hashMap.get(S.charAt(0));
        
        int low=0;
        
        
        for (int i=1;i<S.length();i++){
        
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
