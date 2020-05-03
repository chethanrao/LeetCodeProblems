/*
 Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
	Map<Character,Integer> characterCountMap=new HashMap<Character,Integer>();

	for (int i=0;i<magazine.length();i++){
		if (characterCountMap.containsKey(magazine.charAt(i))){
			    characterCountMap.put(magazine.charAt(i),characterCountMap.get(magazine.charAt(i))+1);
		}
		else {
			characterCountMap.put(magazine.charAt(i),1);
		}
  }
	
	for (int i=0;i<ransomNote.length();i++){
		if (characterCountMap.containsKey(ransomNote.charAt(i)) && characterCountMap.get(ransomNote.charAt(i))!=0){				
        characterCountMap.put(ransomNote.charAt(i),characterCountMap.get(ransomNote.charAt(i))-1);	
		}
		else {
			return false;
		}
	  }
    return true;
    }
}
