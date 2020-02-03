package com.hjkl.exercise.leetcode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        preorder = [3,9,20,15,7]
        inorder = [9,3,15,20,7]
        Return the following binary tree:

            3
           / \
          9  20
            /  \
           15   7
         */
        return buildTree(preorder, 0, inorder, 0, inorder.length-1);
    }
    private TreeNode buildTree(int[] preorder, int preStart, int[] inorder,
                               int inStart, int inEnd) {
        if (preStart > preorder.length-1 || inStart > inEnd) return null;
        int rootVal = preorder[preStart];
        int idx = inStart; // idx = 1
        for(int i=inStart; i<=inEnd; i++) {
            if (inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        //                                    1,                      0,             0
        root.left = buildTree(preorder, preStart+1, inorder, inStart, idx-1);
        //                                      2,                          2,
        root.right = buildTree(preorder, preStart+(idx-inStart+1), inorder, idx+1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(preorder, inorder);
    }
}
