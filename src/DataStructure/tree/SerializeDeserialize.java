package DataStructure.tree;

import java.util.Stack;

/**
 * @author akshay Date 2019-05-31 18:52
 */
public class SerializeDeserialize {


  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if(root==null)
      return null;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    StringBuilder sb = new StringBuilder();

    while(!stack.isEmpty()){
      TreeNode h = stack.pop();
      if(h!=null){
        sb.append(h.data+",");
        stack.push(h.right);
        stack.push(h.left);
      }else{
        sb.append("#,");
      }
    }

    return sb.toString().substring(0, sb.length()-1);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data == null)
      return null;

    int[] t = {0};
    String[] arr = data.split(",");

    return helper(arr, t);
  }

  public TreeNode helper(String[] arr, int[] t){
    if(arr[t[0]].equals("#")){
      return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));

    t[0]=t[0]+1;
    root.left = helper(arr, t);
    t[0]=t[0]+1;
    root.right = helper(arr, t);

    return root;
  }
}
