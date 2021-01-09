package DataStructure.tree;

/**
 * @author : apitale
 * @Date : 12/27/20
 */
public class mergeTrees {

  public static void main(String args[]) {

    TreeNode leftSubTree = new TreeNode(3);
    leftSubTree.setLeft(new TreeNode(5));

    TreeNode root1 = new TreeNode(1);
    root1.setLeft(leftSubTree);
    root1.setRight(new TreeNode(2));

    TreeNode rightSubTree = new TreeNode(3);
    rightSubTree.setRight(new TreeNode(7));
    TreeNode tree1 = new TreeNode(1);
    tree1.setRight(new TreeNode(4));


    TreeNode root2 = new TreeNode(2);
    root2.setLeft(tree1);
    root2.setRight(rightSubTree);

    mergeTrees mergeTrees = new mergeTrees();
    mergeTrees.printINORDER(root1);
    System.out.println(" ");
    mergeTrees.printINORDER(root2);
    System.out.println(" ");
    TreeNode result = mergeTrees.mergeTree(root1, root2);
    mergeTrees.printINORDER(result);
  }

  private TreeNode mergeTree(TreeNode root1, TreeNode root2) {
    if(root1 == null) {
      return root2;
    }
    if(root2 == null) {
      return root1;
    }
    root1.data = root1.data + root2.data;
    root1.left = mergeTree(root1.left, root2.left);
    root1.right = mergeTree(root1.right, root2.right);
    return root1;
  }

  public void printINORDER(TreeNode root) {
    if (root != null) {
      printINORDER(root.left);
      System.out.print("  " + root.data);
      printINORDER(root.right);
    }
  }

}
