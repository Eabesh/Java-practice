package data.structures.binarytrees;

import utilities.TreeNode;

public class TreeExamples {

    /**
     * 9. Level Order Tree Traversal
     */
    void levelOrder(TreeNode root) {
        int height = height(root);
        for(int i = 1; i <= height; i++) {
            level(root,i);
            System.out.println("");
        }
    }

    private void level(TreeNode root, int level) {
        if (root != null) {
            if (level < 2) System.out.print(root.data + " ");
            else {
                level(root.left, level - 1);
                level(root.right, level - 1);
            }
        }
    }

    /**
     * 14. Size of a tree
     */
    int size(TreeNode node) {
        if (node == null) return 0;
        else return 1 + size(node.left) + size(node.right);
    }

    /**
     * 15. Determine if Two Trees are Identical
     */
    boolean isIdentical(TreeNode root1, TreeNode root2) {
        return root1 == null && root2 == null || root1 != null && root2 != null && root1.data == root2.data &&
                isIdentical(root1.left,root2.left) &&
                isIdentical(root1.right,root2.right);
    }

    /**
     * 16. Maximum Depth or Height of a Tree
     */
    int height(TreeNode node) {
        if (node == null) return 0;
        else return 1 + Math.max(height(node.left), height(node.right));
    }


    /**
     * 18. Convert a Binary Tree into its Mirror Tree
     */
    void mirror(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirror(root.left);
            mirror(root.right);
        }
    }

    /**
     * 20. Print out all of its root-to-leaf paths one per line.
     */
    void rootToLeafPath(String path, TreeNode root) {
        if (root != null) {
            if (isLeaf(root)) System.out.println(path + root.data);
            else {
                rootToLeafPath(path + root.data + "->", root.left);
                rootToLeafPath(path + root.data + "->", root.right);
            }
        }
    }

    private boolean isLeaf(TreeNode node) { return node.left == null && node.right == null; }

    /**
     * 22. Count leaf nodes in a binary tree
     */
    int countLeaves(TreeNode root) {
        if (root == null) return 0;
        else if (isLeaf(root)) return 1;
        else return countLeaves(root.right) + countLeaves(root.left);
    }

    /**
     * 23. Level order traversal in spiral form
     */
    void levelOrderSpiral(TreeNode root) {
        int height = height(root);
        for(int i = 1; i <= height; i++) {
            levelSpiral(root, i, i % 2 == 0);
            System.out.println("");
        }
    }

    private void levelSpiral(TreeNode root, int level, boolean odd) {
        if (root != null) {
            if (level < 2) System.out.print(root.data + " ");
            else if (odd){
                level(root.right, level - 1);
                level(root.left, level - 1);
            }
            else {
                level(root.left, level - 1);
                level(root.right, level - 1);
            }
        }
    }


    /**
     * 24. Check for Children Sum Property in a Binary Tree.
     */
    boolean hasChildSum(TreeNode root) {
        if (root == null || isLeaf(root)) return true;
        else {
            return root.data == getChildSum(root) && hasChildSum(root.left) && hasChildSum(root.right);
        }
    }

    int getChildSum(TreeNode node) {
        int sum = 0;
        if (node.left != null) sum += node.left.data;
        if (node.right != null) sum += node.right.data;
        return sum;
    }

    /**
     * 25. Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
     */
    TreeNode convertToChildSum(TreeNode root) {
        if (root == null || isLeaf(root)) return root;
        else {
            convertToChildSum(root.left);
            convertToChildSum(root.right);
            root.data = getChildSum(root);
            return root;
        }
    }

    /**
     * 26. Diameter of a Binary Tree
     */
    int diameter(TreeNode root) {
        if (root == null) return 0;
        else {
            return Math.max(height(root.left) + 1 + height(root.right), Math.max(diameter(root.left), diameter(root.right)));
        }
    }

    /**
     * 77. Lowest Common Ancestor in a Binary Tree.
     */
    TreeNode LCA(TreeNode root, int k1, int k2) {
        if (root == null || root.data == k1 || root.data == k2) return root;
        else {
            TreeNode left = LCA(root.left,k1,k2);
            TreeNode right = LCA(root.right,k1,k2);
            if (left != null && right != null) return root;
            else return left != null ? left : right;
        }
    }

}
