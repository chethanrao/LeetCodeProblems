/*
Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.

For example, if , it is a valid string because frequencies are . So is  because we can remove one  and have  of each character in the remaining string. If  however, the string is not valid as we can only remove  occurrence of . That would leave character frequencies of .

Function Description

Complete the isValid function in the editor below. It should return either the string YES or the string NO.

isValid has the following parameter(s):

s: a string
Input Format

A single string .

Constraints

Each character 
Output Format

Print YES if string  is valid, otherwise, print NO.

Sample Input 0

aabbcd
Sample Output 0

NO
Explanation 0

Given , we would need to remove two characters, both c and d  aabb or a and b  abcd, to make it valid. We are limited to removing only one character, so  is invalid.

Sample Input 1

aabbccddeefghi
Sample Output 1

NO
Explanation 1

Frequency counts for the letters are as follows:

{'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}

There are two ways to make the valid string:

Remove  characters with a frequency of : .
Remove  characters of frequency : .
Neither of these is an option.

Sample Input 2

abcdefghhgfedecba
Sample Output 2

YES
Explanation 2

All characters occur twice except for  which occurs  times. We can delete one instance of  to have a valid string.









*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<Character,Integer> mapOfCharacters=getMapOfCounts(s);
        Map<Integer,Integer> frequencyCount=new HashMap<Integer,Integer>();
        for (char key:mapOfCharacters.keySet()){
           
                frequencyCount.put(mapOfCharacters.get(key),frequencyCount.getOrDefault(mapOfCharacters.get(key),0)+1);
        }

        if (frequencyCount.size()==1){
            return "YES";
        }
        if (frequencyCount.size()>2){
                                    System.out.println(frequencyCount.size());

            return "NO";
        }
        List<Integer> list1=new ArrayList<Integer>();
        List<Integer> list2=new ArrayList<Integer>();

        for (int key:frequencyCount.keySet()){
            list1.add(key);
            list2.add(frequencyCount.get(key));
     

        }

       
        if (list2.get(1)==1 || list2.get(0)==1){
             if (list2.get(1)==1){
                 if (list1.get(1)!=1 && Math.abs(list1.get(1)-list1.get(0))>1){
                     return "NO";
                 }
             }

              if (list2.get(0)==1){
                 if (list1.get(0)!=1 && Math.abs(list1.get(1)-list1.get(0))>1){
                     return "NO";
                 }
             }
            return "YES";
        }

        return "NO";
    }




    public static Map<Character,Integer> getMapOfCounts(String s){
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        return map;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
