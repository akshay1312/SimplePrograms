package DataStructure;

/**
 * Created by Akshay1312 on 11/16/2015.
 */
public class BST
{
    private TreeNode root;

    public BST()
    {
        this.root = null;
    }

    public BST(TreeNode root)
    {
        this.root = root;
    }

    public void insert(int data)
    {
        insert(root, data);
    }

    private TreeNode insert(TreeNode node, int data)
    {
        if (node == null)
            node = new TreeNode(data);
        else
        {
            if (data <= node.getData())
                node.setLeft(insert(node.getLeft(), data));
            else
                node.setRight(insert(node.getRight(), data));
        }
        return node;
    }

    public boolean search(int k)
    {
        return search(root, k);
    }

    private boolean search(TreeNode r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    public void delete(int k)
    {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (!search(k))
            System.out.println("Sorry "+ k +" is not present");
        else
        {
            root = delete(root, k);
            System.out.println(k+ " deleted from the tree");
        }
    }

    private TreeNode delete(TreeNode root, int k)
    {

        TreeNode p, p2, n;
        if (root.getData() == k)
        {
            TreeNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null)
            {
                p = rt;
                return p;
            }
            else if (rt == null)
            {
                p = lt;
                return p;
            }
            else
            {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData())
        {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        }
        else
        {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }

    private boolean isEmpty()
    {
        return root == null;
    }
}
