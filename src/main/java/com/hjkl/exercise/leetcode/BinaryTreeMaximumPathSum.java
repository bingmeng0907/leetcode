package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int ls = Math.max(0, dfs(root.left));
        int rs = Math.max(0, dfs(root.right));
        max = Math.max(max, root.val + ls + rs);
        return Math.max(0, Math.max(root.val + ls, root.val + rs));
    }

    private List<Integer> inorder(TreeNode root) {
        if (root == null) return null;
        List<Integer> ret = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ret.add(cur.val);
            cur = cur.right;
        }
        return ret;
    }
}
