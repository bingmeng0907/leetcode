package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        List<Integer> ret = new ArrayList<>();
        inorder(root, ret);
        int i=0, j=ret.size()-1;
        while(i<j) {
            int sum = ret.get(i) + ret.get(j);
            if (sum == k) {
                return true;
            } else if  (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
    private void inorder(TreeNode node, List<Integer> ret) {
        if (node == null) return;
        inorder(node.left, ret);
        ret.add(node.val);
        inorder(node.right, ret);
    }
}
