/*
Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.

 

Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.
Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.
Example 4:

Input: s = "covid2019"
Output: "c2o0v1i9d"
Example 5:

Input: s = "ab123"
Output: "1a2b3"
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters and/or digits.
*/
class Solution {
    public String reformat(String s) {
        if (s.length()<=1){
            return s;
        }
        String letters=getLetters(s);
        String numbers=getNumbers(s);
        if (letters.trim().length()==0 || numbers.trim().length()==0 || Math.abs(letters.trim().length()-numbers.trim().length())>1){
            return "";
        }
        
        StringBuilder builder=new StringBuilder();
        if (letters.length()>numbers.length()){
            return reformatString(letters,numbers);
        }
        else {
            return reformatString(numbers,letters);
        } 
    }
    
    public String reformatString(String strOfLetters,String strOfNumbers){
        StringBuilder builder=new StringBuilder();
        int index=0;
        for (int i=0;i<strOfLetters.length();i++){
            builder.append(strOfLetters.charAt(i));
            if (index<strOfNumbers.length()){
                builder.append(strOfNumbers.charAt(index));
                index++;
            }
        }
        return builder.toString();
    }
    
    public String getLetters(String s){
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)>='a' && s.charAt(i)<='z'){
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();     
    }
    
    public String getNumbers(String s){
         StringBuilder builder=new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)>='0' && s.charAt(i)<='9'){
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();   
    }
}
