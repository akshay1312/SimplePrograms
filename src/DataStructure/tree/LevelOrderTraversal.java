package DataStructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author akshay Date 2019-06-15 10:22
 */
public class LevelOrderTraversal {


  public static void main(String args[]) {

    TreeNode subTree = new TreeNode(20);
    subTree.setLeft(new TreeNode(15));
    subTree.setRight(new TreeNode(7));
    TreeNode treeNode = new TreeNode(3);
    treeNode.setLeft(new TreeNode(9));
    treeNode.setRight(subTree);

    List<List<Integer>> lists = levelOrder(treeNode);
    System.out.println("Result :: " + lists.toString());
    System.out.println("height :: " + height(treeNode));

  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    if (root != null) {
      q.offer(root);
    }
    TreeNode curr;
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> subList = new LinkedList<>();
      for (int i = 0; i < size; ++i) {
        curr = q.poll();
        subList.add(curr.data);
        if (curr.left != null) {
          q.offer(curr.left);
        }
        if (curr.right != null) {
          q.offer(curr.right);
        }
      }
      ans.add(subList);
    }
    return ans;
  }

  /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
  static int height(TreeNode root)
  {
    if (root == null)
      return 0;
    else
    {
      /* compute  height of each subtree */
      int lheight = height(root.left);
      int rheight = height(root.right);

      /* use the larger one */
      if (lheight > rheight)
        return(lheight+1);
      else return(rheight+1);
    }
  }

}
