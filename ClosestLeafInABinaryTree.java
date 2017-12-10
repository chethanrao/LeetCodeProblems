/*

Given a binary tree where every node has a unique value, and a target key k, 
find the closest leaf node to target k in the tree.

A node is called a leaf if it has no children.

In the following examples, the input tree is represented in flattened form row by row. 
The actual root tree given will be a TreeNode object.

Example 1:

Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2

Output: 2 (or 3)

Explanation: Either 2 or 3 is the closest leaf node to 1.
Example 2:

Input:
root = [1], k = 1
Output: 1

Explanation: The closest leaf node is the root node itself.
Example 3:

Input:
root = [1,2,3,4,null,null,null,5,null,6], k = 2
Diagram of binary tree:
             1
            / \
           2   3
          /
         4
        /
       5
      /
     6

Output: 3
Explanation: The leaf node with value 3 (and not the leaf node with value 6) is closest to the node with value 2.
Note:
root represents a binary tree with at least 1 node and at most 1000 nodes.
Every node has a unique node.val in range [1, 1000].
There exists some node in the given binary tree for which node.val == k.*/

class ClosestLeafInABinaryTree {
    public int findClosestLeaf(TreeNode root, int k) {
        
        
        HashMap<Integer,List<Integer>> hashMap=new HashMap<Integer,List<Integer>>();
        
       
        hashMap=updateParent(root,hashMap);
        
        hashMap=updateChildren(root,hashMap);
        
        
        return hashMap.get(k).get(0);
        
    }
    
  
    
    
    HashMap<Integer,List<Integer>> updateParent(TreeNode root,HashMap<Integer,List<Integer>> hashMap){
        
        
        
        
        int min1=-1,min2=-1,valleft=-1,valright=-1;
        
        List<Integer> list=null;

        if (root.left==null && root.right==null){
          list=new ArrayList<Integer>();
            
            list.add(root.val);
            list.add(0);
            hashMap.put(root.val,list);
              

            return hashMap;
        }
            
        
        if (root.left!=null){
             HashMap<Integer,List<Integer>>  hashmap1=updateParent(root.left,hashMap);
             valleft=hashmap1.get(root.left.val).get(0);
             min1=hashmap1.get(root.left.val).get(1);
        }
        
         if (root.right!=null){
              HashMap<Integer,List<Integer>>  hashmap2=updateParent(root.right,hashMap);
              valright=hashmap2.get(root.right.val).get(0);
              min2=hashmap2.get(root.right.val).get(1);
         }
        
        
        
       list=new ArrayList<Integer>();
        
        if (min1==-1){
            list.add(valright);
            list.add(min2+1);
           
            hashMap.put(root.val,list);
            return hashMap;
        }
        
         if (min2==-1){
            list.add(valleft);
            list.add(min1+1);
           
            hashMap.put(root.val,list);
            return hashMap; 
        }
        
        
        if (min2<min1){
       

            list.add(valright);
            list.add(min2+1);
           
            hashMap.put(root.val,list);
            
        
        }
        else {
     
              list.add(valleft);
            list.add(min1+1);
           
            hashMap.put(root.val,list);
        

        }
               
        
        return hashMap;
        
    }
    

        HashMap<Integer,List<Integer>> updateChildren(TreeNode root,HashMap<Integer,List<Integer>> hashMap){

         if (root.left==null && root.right==null)
             return hashMap;
        List<Integer> list=hashMap.get(root.val);

          if (root.left!=null){
              List<Integer> list1=hashMap.get(root.left.val);
              
              if (list.get(1)+1<list1.get(1)){
                  list1.set(1,list.get(1)+1);
                  list1.set(0,list.get(0));
                  
                  hashMap.put(root.left.val,list1);
                  
              }
            updateChildren(root.left,hashMap);
       
          }  
            
        if (root.right!=null){
              List<Integer> list2=hashMap.get(root.right.val);
              
              if (list.get(1)+1<list2.get(1)){
                  list2.set(1,list.get(1)+1);
                  list2.set(0,list.get(0));
                  hashMap.put(root.right.val,list2);

              }
                  
             updateChildren(root.right,hashMap);

          }  
            
          return hashMap;
        }
}
