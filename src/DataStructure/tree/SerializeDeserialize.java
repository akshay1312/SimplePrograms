package DataStructure.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author akshay Date 2019-05-31 18:52
 */
public class SerializeDeserialize {


  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return null;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    StringBuilder sb = new StringBuilder();

    while (!stack.isEmpty()) {
      TreeNode h = stack.pop();
      if (h != null) {
        sb.append(h.data + ",");
        stack.push(h.right);
        stack.push(h.left);
      } else {
        sb.append("#,");
      }
    }

    return sb.toString().substring(0, sb.length() - 1);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null) {
      return null;
    }

    int[] t = {0};
    String[] arr = data.split(",");

    return helper(arr, t);
  }

  public TreeNode helper(String[] arr, int[] t) {
    if (arr[t[0]].equals("#")) {
      return null;
    }
    String s = null;
    Character ch = s.charAt(0);
    Character.getNumericValue(ch);
    TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));

    t[0] = t[0] + 1;
    root.left = helper(arr, t);
    t[0] = t[0] + 1;
    root.right = helper(arr, t);

    return root;
  }




  public String rserialize(TreeNode root, String str) {
    // Recursive serialization.
    if (root == null) {
      str += "null,";
    } else {
      str += str.valueOf(root.data) + ",";
      str = rserialize(root.left, str);
      str = rserialize(root.right, str);
    }
    return str;
  }

  // Encodes a tree to a single string.
  public String serialize1(TreeNode root) {
    return rserialize(root, "");
  }

  public TreeNode rdeserialize(List<String> l) {
    // Recursive deserialization.
    if (l.get(0).equals("null")) {
      l.remove(0);
      return null;
    }

    TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
    l.remove(0);
    root.left = rdeserialize(l);
    root.right = rdeserialize(l);

    return root;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize1(String data) {
    String[] data_array = data.split(",");
    List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
    return rdeserialize(data_list);
  }
}
