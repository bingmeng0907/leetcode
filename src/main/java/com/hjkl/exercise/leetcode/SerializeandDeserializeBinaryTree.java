package com.hjkl.exercise.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeandDeserializeBinaryTree {
    private static final String SP = ",";
    private static final String NN = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(SP);
        } else {
            sb.append(node.val).append(SP);
            serialize(node.left, sb);
            serialize(node.right, sb);
        }
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.addAll(Arrays.asList(data.split(SP)));
        return deserialize(queue);
    }
    private TreeNode deserialize(ArrayDeque<String> queue) {
        String str = queue.poll();
        if (NN.equals(str)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(str));
            root.left = deserialize(queue);
            root.right = deserialize(queue);
            return root;
        }
    }
}
