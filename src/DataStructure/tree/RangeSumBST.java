package DataStructure.tree;

/**
 * @author : apitale
 * @Date : 12/27/20
 */
public class RangeSumBST {

  int ans;
  public int rangeSumBST(TreeNode root, int low, int high) {
    ans = 0;
    dfs(root, low, high);
    return ans;
  }

  public void dfs(TreeNode node, int low, int high) {
    if(node != null) {
      if(low <= node.data && node.data <= high) {
        ans += node.data;
      }
      if(low < node.data) {
        dfs(node.left, low,  high);
      }
      if(node.data < high) {
        dfs(node.right, low,  high);
      }
    }
  }

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

    RangeSumBST rangeSumBST = new RangeSumBST();
    System.out.println("Sum ::" + rangeSumBST.rangeSumBST(root, 4, 10));
  }
}
