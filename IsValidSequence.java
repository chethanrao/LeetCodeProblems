/*
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (arr.length==0){
            if (root==null){
                return true;
            }
            else {
                return false;
            }
        }
        return isValidSequence(root,arr,0);
    }
    
    public boolean isValidSequence(TreeNode root,int[] arr,int index){     
        if (index==arr.length-1 && root!=null){
            if (root.val==arr[index] && root.left==null && root.right==null){
                return true;
            }
            else {
                return false;
            }
        }          
        return root!=null && root.val==arr[index] && (isValidSequence(root.left,arr,index+1) || isValidSequence(root.right,arr,index+1));
        
    }
}
*/
