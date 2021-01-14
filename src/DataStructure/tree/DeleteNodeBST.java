package DataStructure.tree;

/**
 * @author : apitale
 * @Date : 1/13/21
 */
public class DeleteNodeBST {

  /*
One step right and then always left
*/
  public int successor(TreeNode root) {
    root = root.right;
    while (root.left != null) root = root.left;
    return root.data;
  }

  /*
  One step left and then always right
  */
  public int predecessor(TreeNode root) {
    root = root.left;
    while (root.right != null) root = root.right;
    return root.data;
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;

    // delete from the right subtree
    if (key > root.data) root.right = deleteNode(root.right, key);
      // delete from the left subtree
    else if (key < root.data) root.left = deleteNode(root.left, key);
      // delete the current node
    else {
      // the node is a leaf
      if (root.left == null && root.right == null) root = null;
        // the node is not a leaf and has a right child
      else if (root.right != null) {
        root.data = successor(root);
        root.right = deleteNode(root.right, root.data);
      }
      // the node is not a leaf, has no right child, and has a left child
      else {
        root.data = predecessor(root);
        root.left = deleteNode(root.left, root.data);
      }
    }
    return root;
  }
}
