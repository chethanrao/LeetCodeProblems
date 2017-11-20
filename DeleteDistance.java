import java.io.*;
import java.util.*;
/*
Deletion Distance

The deletion distance of two strings is the minimum number of characters you need to delete in the two strings in order to get the same string. For instance, the deletion distance between "heat" and "hit" is 3:

By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
We cannot get the same string from both strings by deleting 2 letters or fewer.
Given the strings str1 and str2, write an efficient function deletionDistance that returns the deletion distance between them. Explain how your function works, and analyze its time and space complexities.

Examples:

input:  str1 = "dog", str2 = "frog"
output: 3

input:  str1 = "some", str2 = "some"
output: 0

input:  str1 = "some", str2 = "thing"
output: 9

input:  str1 = "", str2 = ""
output: 0
Constraints:

[input] string str1
[input] string str2
[output] integer
*/
class Solution {

  static int deletionDistance(String str1, String str2) {
    // your code goes here
    
    if (str1.length()==0)
      return str2.length();
   
    if (str2.length()==0)
      return str1.length();
   
    int[][] arr=new int[str1.length()][str2.length()];
    
    int counter=1;
    boolean flag=false;
    
    
    for (int i=0;i<str2.length();i++){
      if (str1.charAt(0)==str2.charAt(i) && !flag){
               counter--;
        
           flag=true;
      }   
      else
        counter++;
      arr[0][i]=counter;
    }
    flag=false;
    counter=1;
   for (int i=0;i<str1.length();i++){
      if (str2.charAt(0)==str1.charAt(i) && !flag){
               counter--;
        
           flag=true;
      }   
      else
        counter++;
      arr[i][0]=counter;
    }
    
    for (int i=1;i<str1.length();i++)
      for (int j=1;j<str2.length();j++){
        if (str1.charAt(i)==str2.charAt(j)){
          arr[i][j]=arr[i-1][j-1];
        }
        else{
          arr[i][j]=Math.min(arr[i-1][j],arr[i][j-1])+1;
        }
      }
  
    return arr[str1.length()-1][str2.length()-1];
  }

  public static void main(String[] args) {

  }

}
