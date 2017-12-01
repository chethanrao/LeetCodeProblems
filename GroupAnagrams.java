
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
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
      
        HashMap<Double,List<String>> hashMap=new HashMap<Double,List<String>>();
        
        List<Integer> list=getPrimes();
        
        
        HashMap<Character,Integer> alphaHashMap=getAlphabetPrimeHashMap(list);

        
        for (String s:strs){
            double product=getProductOfPrimes(alphaHashMap,s.toLowerCase());
            
            
            if (hashMap.containsKey(product)){
                List<String> existingList=hashMap.get(product);
                existingList.add(s);
                hashMap.put(product,existingList);
            }
            else{
                List<String> newlist=new ArrayList<String>();
                newlist.add(s);
                hashMap.put(product,newlist);
            }
        
        }   
        List<List<String>> finallist=new ArrayList<List<String>>();
        for (List<String> anagramlist:hashMap.values()){
          
            
            finallist.add(anagramlist);
            
        }
        
        return finallist;
    }
    
    public static double getProductOfPrimes(HashMap<Character,Integer> hashMap,String str){
        double product=1.0;
        for (int i=0;i<str.length();i++){
            product=product*hashMap.get(str.charAt(i));
        }
        
          System.out.println(product);
                    System.out.println(str);
                              System.out.println("---------------");


      
        return product;
        
    }
    
    public static HashMap<Character,Integer> getAlphabetPrimeHashMap(List<Integer> list){
        int start=(int)'a';
        HashMap<Character,Integer> hashMap=new HashMap<Character,Integer>();
        
        for (int i=0;i<26;i++){
            hashMap.put((char)start,list.get(i));
            start=start+1;      
        }
        
        return hashMap;
        
    }
    
    public static List<Integer> getPrimes(){
    List<Integer> list=new ArrayList<Integer>();
          list.add(2);
        int countOfPrimes=0,num=3;
        while (true){
            if (verifyPrime(num)){
                countOfPrimes++;
                list.add(num);
                if (countOfPrimes==25)
                    break;
            }
            num=num+2;
            
            
        }
        return list;
    }
    
    public static boolean verifyPrime(int num){
    	
        
        for (int i=2;i<Math.sqrt(num);i=i+1){
        

            if (num%i==0)
                return false;
        }

        return true;
    }
    
    
  
    
}
