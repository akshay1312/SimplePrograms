package DataStructure.tree;

import java.util.Stack;

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

  public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root ;
    TreeNode pre = null ;
    while (!stack.isEmpty() || cur != null) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.left ;
      } else {
        TreeNode p = stack.pop() ;
        if (pre != null && p.val <= pre.val) {
          return false ;
        }
        pre = p ;
        cur = p.right ;
      }
    }
    return true ;
  }

  public boolean isValidBST1(TreeNode root) {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBST(TreeNode root, int minValue, int maxValue) {
    if(root == null) {
      return true;
    }

    if(root.val <= minValue || root.val > maxValue) {
      return false;
    }
    return isBST(root.left, minValue, root.val) && isBST(root.right, root.val, maxValue);
  }
}
