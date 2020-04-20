/*
1008. Construct Binary Search Tree from Preorder Traversal
Medium

694

23

Add to List

Share
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Note: 

1 <= preorder.length <= 100
The values of preorder are distinct.
*/
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length==0){
            return null;
        }
        return bstFromPreorder(preorder,0,preorder.length);
        
    }
    
    public TreeNode bstFromPreorder(int[] preorder,int start,int end){
        if (start>end || start<0 || end>preorder.length){
            return null;
        }
         

        int rootValue=preorder[start];
        TreeNode finalNode=new TreeNode(rootValue);
        int start1=-1;
        int start2=-1;
       for (int i=start+1;i<end;i++){
           if (start1==-1 && preorder[i]<rootValue){
               start1=i;
           }
           
            if (start2==-1 && preorder[i]>rootValue){
               start2=i;
               break;
           }
           
       }
        
        if (start2==-1){
            finalNode.left=bstFromPreorder(preorder,start1,end);
        }
        else {
            finalNode.left=bstFromPreorder(preorder,start1,start2);
        }
        finalNode.right=bstFromPreorder(preorder,start2,end);
        return finalNode;     
    }
}
