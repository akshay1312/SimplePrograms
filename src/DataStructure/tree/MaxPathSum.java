package DataStructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author akshay Date 2019-06-20 14:07
 */
public class MaxPathSum {

  static List<Integer> path = new ArrayList<>();

  public static void main(String args[]) {

    TreeNode leftSubTree = new TreeNode(2);
    leftSubTree.setLeft(new TreeNode(8));
    TreeNode right = new TreeNode(4);
    right.setLeft(new TreeNode(10));
    leftSubTree.setRight(right);
    TreeNode root = new TreeNode(1);
    root.setLeft(leftSubTree);

    TreeNode rightSubTree = new TreeNode(3);
    TreeNode tree1 = new TreeNode(5);
    tree1.setRight(new TreeNode(9));
    tree1.setLeft(new TreeNode(7));
    TreeNode tree2 = new TreeNode(6);
    tree2.setRight(new TreeNode(5));
    rightSubTree.setLeft(tree1);
    rightSubTree.setRight(tree2);
    root.setRight(rightSubTree);

    System.out.println("Max Sum ::" + maxPathSum(root));
    System.out.println("Max Sum ::" + maxPathSum2(root));
  }

  private static Integer maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int max = root.data;

    int left = maxPathSum(root.left);

    int right = maxPathSum(root.right);
    System.out.println("data :: " + root.data);
    if (left > right) {
      return left + root.data;
    } else {
      return right + root.data;
    }
  }


  private static Integer maxPathSum2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Stack<TreeNode> nodeStack = new Stack<>();
    Stack<String> nodePath = new Stack<>();
    nodeStack.push(root);
    nodePath.push("" + root.data);
    int runningSum = 0;
    while (!nodeStack.isEmpty()) {
      TreeNode node = nodeStack.pop();
      String currentPath = nodePath.pop();
      if (node.right != null) {
        nodeStack.push(node.right);
        nodePath.push(currentPath + ("->" + node.right.data));
      }
      if (node.left != null) {
        nodeStack.push(node.left);
        nodePath.push(currentPath + ("->" + node.left.data));
      }
      if (node.left == null && node.right == null) {
        String[] split = currentPath.split("->");

        for(String s : split) {
          runningSum = runningSum + Integer.valueOf(s);
        }
        System.out.println(currentPath +" :: "+ runningSum);
        runningSum = 0;
      }

    }
    return runningSum;
  }
}
