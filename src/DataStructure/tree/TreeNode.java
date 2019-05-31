package DataStructure.tree;

/**
 * Created by Akshay1312 on 11/13/2015.
 */
public class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode()
    {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
