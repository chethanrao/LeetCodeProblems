/*
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]

Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false

Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false

 

Note:

    1 <= N <= 2000
    0 <= dislikes.length <= 10000
    1 <= dislikes[i][j] <= N
    dislikes[i][0] < dislikes[i][1]
    There does not exist i != j for which dislikes[i] == dislikes[j].

*/
class Solution {  
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer,List<Integer>> mapOfLists=getMapFromDislikes(dislikes);
        Map<Integer,Integer> visitedVertices=new HashMap<Integer,Integer>();     
        for (int i=1;i<=N;i++){
            if (!visitedVertices.containsKey(i) && hasOddCycles(mapOfLists,i,-1,visitedVertices,0)){
                return false;
            }
        }      
        return true;
    }
    
    public boolean hasOddCycles(Map<Integer,List<Integer>> mapOfLists,int currentVertex,int parent,Map<Integer,Integer> visitedVertices,int distance){
        if (currentVertex!=parent){
            if (visitedVertices.containsKey(currentVertex)){
                if ((visitedVertices.get(currentVertex)-distance)%2==0){
                    return false;
                } 
                return true;
            }
        }
        if (!mapOfLists.containsKey(currentVertex)){
            return false;
        }
        visitedVertices.put(currentVertex,distance);
        List<Integer> list=mapOfLists.get(currentVertex);
        for (int i=0;i<list.size();i++){
        
            if (list.get(i)!=parent && hasOddCycles(mapOfLists,list.get(i),currentVertex,visitedVertices,distance+1)){
                return true;
            }
        }
        return false;
    }
    
    public Map<Integer,List<Integer>> getMapFromDislikes(int[][] dislikes){
        Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        for (int i=0;i<dislikes.length;i++){
           if (map.containsKey(dislikes[i][0])){
               map.get(dislikes[i][0]).add(dislikes[i][1]);
           }
           else {
               List<Integer> list=new ArrayList<Integer>();
               list.add(dislikes[i][1]);
               map.put(dislikes[i][0],list);
           }
           if (map.containsKey(dislikes[i][1])){
               map.get(dislikes[i][1]).add(dislikes[i][0]);
           }
           else {
               List<Integer> list=new ArrayList<Integer>();
               list.add(dislikes[i][0]);
               map.put(dislikes[i][1],list);
           }
        }
        return map;
    }
    
}
