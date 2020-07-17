package com.LeetCode.July;

import com.LeetCode.HelperClasses.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Day13_SameTree {

    //iterative
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        if (p != null && q != null) {
            queue.offer(p);
            queue.offer(q);
        }
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null)
                continue;
            if (first == null || second == null)
                return false;
            if (first.val != second.val)
                return false;
            queue.offer(first.left);
            queue.offer(second.left);
            queue.offer(first.right);
            queue.offer(second.right);
        }
        return true;
    }

    //Recursive
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null && q != null)
                || (p != null && q == null)
                || (p.val != q.val)) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
