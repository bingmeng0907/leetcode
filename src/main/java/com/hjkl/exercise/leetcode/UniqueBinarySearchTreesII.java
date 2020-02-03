package com.hjkl.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<TreeNode>();
        return gen(1,n);
    }
    private List<TreeNode> gen(int s, int e) {
        List<TreeNode> ret = new ArrayList<>();
        if (s > e) {
            ret.add(null);
            return ret;
        }
        for(int i=s; i<=e; i++) {
            List<TreeNode> ls = gen(s,i-1);
            List<TreeNode> rs = gen(i+1, e);
            for(TreeNode ln : ls) {
                for(TreeNode rn : rs) {
                    TreeNode root = new TreeNode(i);
                    root.left = ln;
                    root.right = rn;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}
