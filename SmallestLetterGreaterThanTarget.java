/*
Given a list of unsorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.*/

class SmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        
        char ch=' ';
        int mindiff=1000;
        int diff;
        for (char letter:letters){
            if ((int)letter>(int)target)
               diff=(int)letter-(int)target;
            else
               diff=(int)letter-(int)'a'+(int)'z'-(int)target+1;
            
     

            if (diff<mindiff){
                
                mindiff=diff;
                ch=letter;
            }
        }
        return ch;
    }
}
