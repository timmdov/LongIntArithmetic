/*This class is going to be responsible for the Subtraction.
*/
package Project1;
public class Subtraction {
    public static Node subtractLinkedLists(Node head1, Node head2) {
        Node resultHead = null;
        Node current1 = head1;
        Node current2 = head2;
        int borrow = 0;

        while (current1 != null || current2 != null) {
            int data1 = current1 != null ? current1.data : 0;
            int data2 = current2 != null ? current2.data : 0;

            int difference = data1 - data2 - borrow;
            if (difference < 0) {
                difference += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            Node newNode = new Node(difference);
            newNode.next = resultHead;
            resultHead = newNode;

            if (current1 != null) {
                current1 = current1.next;
            }

            if (current2 != null) {
                current2 = current2.next;
            }
        }

        if (borrow > 0) {
            Node newNode = new Node(borrow);
            newNode.next = resultHead;
            resultHead = newNode;
        }

        return resultHead;
    }
}