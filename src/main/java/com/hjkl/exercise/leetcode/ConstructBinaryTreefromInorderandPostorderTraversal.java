package com.hjkl.exercise.leetcode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /*
        inorder = [9,3,15,20,7]
        postorder = [9,15,7,20,3]
        Return the following binary tree:

            3
           / \
          9  20
            /  \
           15   7
         */
        return buildTree(postorder, postorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode buildTree(int[] postorder, int postEnd, int[] inorder, int inStart, int inEnd) {
        if (postEnd < 0 || inStart > inEnd) return null;
        int rootVal = postorder[postEnd];
        int idx = 0; // idx = 1
        for(int i=inStart; i<=inEnd; i++) {
            if (inorder[i] == rootVal){
                idx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        //                                        3                     2,           4
        root.right = buildTree(postorder, postEnd-1, inorder, idx+1, inEnd);
        //                                       0                                 0         0
        root.left = buildTree(postorder, postEnd-(inEnd-idx)-1, inorder, inStart, idx-1);
        return root;
    }
}
