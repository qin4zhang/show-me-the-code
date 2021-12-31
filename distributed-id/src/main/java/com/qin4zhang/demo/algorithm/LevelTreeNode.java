package com.qin4zhang.demo.algorithm;

import java.util.*;

/**
 * Hello world!
 */
public class LevelTreeNode {
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int t) {
            val = t;
        }
    }

    public static void main(String[] args) {
        LevelTreeNode levelTreeNode = new LevelTreeNode();
        int[] xianxu = {1, 2, 4, 5, 3};
        int[] zhongxu = {4, 2, 5, 1, 3};
        System.out.println(Arrays.toString(levelTreeNode.solve(xianxu, zhongxu)));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     *
     * @param xianxu  int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve(int[] xianxu, int[] zhongxu) {
        // write code here\
        // 重建二叉树
        TreeNode root = buildTree(xianxu, zhongxu);
        // 层序遍历二叉树
        ArrayList<ArrayList<Integer>> levelRes = level(root);
        // 获取每层的最后一个
        int[] res = new int[levelRes.size()];
        for (int i = 0; i < levelRes.size(); i++) {
            ArrayList<Integer> tmp = levelRes.get(i);
            res[i] = tmp.get(tmp.size() - 1);
        }
        return res;
    }

    private TreeNode buildTree(int[] xianxu, int[] zhongxu) {
        if (xianxu.length == 0 || zhongxu.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(xianxu[0]);
        for (int i = 0; i < zhongxu.length; i++) {
            if (xianxu[0] == zhongxu[i]) {
                root.left = buildTree(Arrays.copyOfRange(xianxu, 1, i + 1), Arrays.copyOfRange(zhongxu, 0, i));
                root.right = buildTree(Arrays.copyOfRange(xianxu, i + 1, xianxu.length), Arrays.copyOfRange(zhongxu, i + 1, zhongxu.length));
                break;
            }
        }
        return root;
    }

    private ArrayList<ArrayList<Integer>> level(TreeNode node) {
        // 队列的方式层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int size;
        while ((size = queue.size()) > 0) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = queue.poll();
                tmp.add(tmpNode.val);
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
