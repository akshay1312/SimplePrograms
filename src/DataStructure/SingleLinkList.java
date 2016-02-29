package DataStructure;

/**
 * Created by Akshay1312 on 11/13/2015.
 */
public class SingleLinkList
{
    private Node head;
    private int size;

    public SingleLinkList()
    {
        head = null;
        size = 0;
    }

    public void add(int data)
    {
        Node temp = new Node(data, null);
        Node current = head;

        if(head == null)
            head = temp;
        else {
            while (current.getLink() != null)
                current = current.getLink();
        }

        head.setLink(temp);
    }

    public void add(int data, int index)
    {
        Node temp = new Node(data, null);
        Node current = head;

        if(index == 0)
        {
            temp.setLink(head);
            this.head = temp;
        }
        else
        {
            for(int i = 1; i < index; i++)
                current = current.getLink();
            temp.setLink(current.getLink());
            current.setLink(temp);
        }

        this.size++;
    }

    public void remove(int index) {
        Node current = head;
        if (index == 0) {
            head = head.getLink();
        } else
        {
            for(int i =1; i < index; i++)
                current = current.getLink();

            current.setLink(current.getLink().getLink());
        }

        this.size--;
    }

    public String toString() {
        String list = "";
        list += "[" + this.head.getData() + "]";

        Node curr = head.getLink();
        while (curr != null){
            list += "[" + curr.getData() + "]";
            curr = curr.getLink();
        }

        return list;

    }

    public static void main(String args[])
    {
        SingleLinkList singleLinkList = new SingleLinkList();

        singleLinkList.add(3);
        singleLinkList.add(5);
        singleLinkList.add(2);

        System.out.print(singleLinkList.toString());
    }
}
