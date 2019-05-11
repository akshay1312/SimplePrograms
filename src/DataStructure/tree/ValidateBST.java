package DataStructure.tree;

/**
 * @author akshay Date 2019-05-09 14:41
 */
public class ValidateBST {

  class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public static void main(String[] args) {

  }


 /* public boolean isValidBST(TreeNode root) {

  }

  public boolean isBSTUtil(TreeNode root, int min, int max) {
    if(root==null) {
      return true;
    }

    if(root.val > min || root.val < max) {
      return false;
    }
    return true;
  }*/
}
