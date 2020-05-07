/*
n a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
*/
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
      
        if (getParent(root,x)!=getParent(root,y) && getLevel(root,x)==getLevel(root,y)){
            return true;
        }
        else {
            return false;
        }
        
    }
    
    
    public int getParent(TreeNode root,int x){
        if (root==null){
            return -1;
        }
        
        if (root.left!=null && root.left.val==x){
            return root.val;
        }
        
        if (root.right!=null && root.right.val==x){
            return root.val;
        }
        int left=-1,right=-1;
        
        if (root.left!=null){
            left=getParent(root.left,x);
            if (left!=-1){
                return left;
            }
        }
        
        if (root.right!=null){
            right=getParent(root.right,x);

            if (right!=-1){
                return right;
            }
        }
        
      
        return -1;
        
    }
    
    public int getLevel(TreeNode root,int x){
        if (root==null){
            return -1;
        }
        
        if (root.val==x){
            return 0;
        }
        
        int leftLevel=getLevel(root.left,x);
        int rightLevel=getLevel(root.right,x);

        if (leftLevel!=-1){
            return leftLevel+1; 
        }
        else if (rightLevel!=-1){
            return rightLevel+1;
        }
        
        return -1;
        
        
    }
    
    
}
