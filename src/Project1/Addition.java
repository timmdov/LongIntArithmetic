package Project1;/*This class is going to be responsible for the Project1.Addition.
*/
public class Addition {
    public static Node addLinkedLists(Node head1, Node head2) {
        Node resultHead = null;
        Node current1 = head1;
        Node current2 = head2;
        int carry = 0;

        while (current1 != null || current2 != null) {
            int data1 = current1 != null ? current1.data : 0;
            int data2 = current2 != null ? current2.data : 0;

            int sum = data1 + data2 + carry;
            carry = sum / 10;
            int resultData = sum % 10;

            Node newNode = new Node(resultData);
            newNode.next = resultHead;
            resultHead = newNode;

            if (current1 != null) {
                current1 = current1.next;
            }

            if (current2 != null) {
                current2 = current2.next;
            }
        }

        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = resultHead;
            resultHead = newNode;
        }

        return resultHead;
    }
}