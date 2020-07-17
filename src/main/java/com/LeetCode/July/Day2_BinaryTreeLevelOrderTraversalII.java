package com.LeetCode.July;

import com.LeetCode.HelperClasses.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Day2_BinaryTreeLevelOrderTraversalII {
    public static Map<Integer,List<Integer>> levelMap =  new TreeMap<>(Comparator.reverseOrder());


    public static void main(String[] args) {


    }



    // optimized solution using linkedlist and dfs, no extra memory
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        addLevel(result, root, 0);
        return result;
    }

    private void addLevel(List<List<Integer>> result, TreeNode root, int level) {
        if(root == null) return;
        if(level >= result.size()) result.add(0, new LinkedList<>());
        addLevel(result, root.left, level+1);
        addLevel(result, root.right, level+1);
        result.get(result.size() - level - 1).add(root.val);
    }


    // my unoptimized solution using an extra treemap + DFS
    public List<List<Integer>> levelOrderBottomUnOptimized(TreeNode root) {
        addLevelAndValueToMap(root,0);
        List<List<Integer>> result =  new ArrayList<>();
        levelMap.entrySet().stream().forEach( e ->
            result.add(e.getValue()));
        levelMap.clear();
        return result;
    }

    private void addLevelAndValueToMap(TreeNode root, int i) {
        if(root != null) {
            List<Integer> list = levelMap.getOrDefault(i, new ArrayList<>());
            list.add(root.val);
            levelMap.put(i, list);
            if(root.left != null) addLevelAndValueToMap(root.left, i+1);
            if(root.right != null) addLevelAndValueToMap(root.right, i+1);
        }

    }



}

