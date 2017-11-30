
/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      
        HashMap<String,List<String>> hashMap=new HashMap<String,List<String>>();
        
        List<Integer> list=getPrimes();
        
        System.out.println(list);
        
        HashMap<Character,Integer> alphaHashMap=getAlphabetPrimeHashMap(list);
                System.out.println(alphaHashMap);

        
        for (String s:strs){
            int product=getProductOfPrimes(alphaHashMap,s);
            
            if (hashMap.containsKey(product)){
                List<String> existingList=hashMap.get(product);
                existingList.add(s);
            }
            else{
                List<String> newlist=new ArrayList<String>();
                newlist.add(s);
                hashMap.put(s,newlist);
            }
        
            
        }   
        List<List<String>> finallist=new ArrayList<List<String>>();
        for (List<String> anagramlist:hashMap.values()){
            finallist.add(anagramlist);
        }
        
        return finallist;
    }
    
    public int getProductOfPrimes(HashMap<Character,Integer> hashMap,String str){
        int product=1;
        for (int i=0;i<str.length();i++){
            product=product*hashMap.get(str.charAt(i));
        }
        return product;
        
    }
    
    public HashMap<Character,Integer> getAlphabetPrimeHashMap(List<Integer> list){
        int start=(int)'a';
        HashMap<Character,Integer> hashMap=new HashMap<Character,Integer>();
        
        for (int i=0;i<25;i++){
            hashMap.put((char)start,list.get(i));
            start=start+1;      
        }
        
        return hashMap;
        
    }
    
    public List<Integer> getPrimes(){
    List<Integer> list=new ArrayList<Integer>();

        int countOfPrimes=0,num=3;
        while (true){
            if (verifyPrime(num)){
                countOfPrimes=countOfPrimes+1;
                list.add(num);
                num=num+2;
                if (countOfPrimes==25)
                    break;
            }
            
            
        }
        return list;
    }
    
    public boolean verifyPrime(int num){
        
        for (int i=3;i<Math.sqrt(num);i=i+1){
            if (num%i==0)
                return false;
        }
        return true;
    }
    
    
    
}
