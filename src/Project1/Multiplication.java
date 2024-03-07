/*This class is going to be responsible for the Multiplication.
*/


     /*This class is going to be responsible for the Multiplication.
     */
package Project1;

public class Multiplication {

    public static Node multiplyLinkedLists(Node head1, Node head2) {
        Node resultHead0= null;
        Node resultHead = null;
        Node current1 = head1;
        Node current2 = head2;


        // Iterate over the second linked list from right to left.
        while (current2 != null) {
            // Multiply the first linked list by the last digit of the second linked list.
            Node partialResultHead = multiplyLinkedListByDigit(head1, current2.data);

            // Add the partial result linked list to the result linked list.
            if (resultHead == null) {
                resultHead = partialResultHead;

            } else {
                Addition.addLinkedLists(resultHead, partialResultHead);

            }

            // Move to the next digit of the second linked list.
            current2 = current2.next;

        }

        return resultHead;

    }

    private static Node multiplyLinkedListByDigit(Node head1, int digit) {
        Node resultHead = null;
        int carry = 0;

        // Iterate over the first linked list from right to left.
        while (head1 != null) {
            // Multiply the current digit of the first linked list by the digit and add the carry.
            int sum = head1.data * digit + carry;
            carry = sum / 10;
            int resultData = sum % 10;

            // Create a new node with the result data and add it to the result linked list.
            Node newNode = new Node(resultData);
            newNode.next = resultHead;
            resultHead = newNode;

            // Move to the next digit of the first linked list.
            head1 = head1.next;
        }

        // If there is a carry, add a new node with the carry to the result linked list.
        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = resultHead;
            resultHead = newNode;
        }

        return resultHead;
    }
}