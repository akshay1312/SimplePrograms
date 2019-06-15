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

}
