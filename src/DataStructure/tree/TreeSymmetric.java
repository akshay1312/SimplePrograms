package DataStructure.tree;

/**
 * @author akshay Date 2019-06-15 14:54
 */
public class TreeSymmetric {

  public static void main(String args[]) {

    TreeNode leftSubTree = new TreeNode(2);
    leftSubTree.setLeft(new TreeNode(3));
    leftSubTree.setRight(new TreeNode(4));

    TreeNode rightSubTree = new TreeNode(2);
    rightSubTree.setLeft(new TreeNode(4));
    rightSubTree.setRight(new TreeNode(3));

    TreeNode treeNode = new TreeNode(1);
    treeNode.setLeft(leftSubTree);
    treeNode.setRight(rightSubTree);

    boolean lists = isSymmetric(treeNode);
    System.out.println("Result :: " + lists);

  }

  private static boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return helper(root.left, root.right);
  }

  private static boolean helper(TreeNode left, TreeNode right) {
    if (left == null || right == null) {
      return left == right;
    }

    if (left.data != right.data) {
      return false;
    }

    return (helper(left.left, right.right) && helper(left.right, right.left));
  }

}
