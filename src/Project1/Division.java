/*This class is going to be responsible for the Division.
*/

package Project1;
import Project1.LinkedList;
import Project1.Node;

public class Division {

    public static Node divideLinkedLists(Node head1, Node head2) throws IllegalArgumentException {
        // Check if the divisor is zero.
        if (head2 == null || head2.data == 0) {
            throw new IllegalArgumentException("The divisor cannot be zero.");
        }

        // Check if the dividend is less than the divisor.
        if (head1 == null || head1.data < head2.data) {
            return null;
        }

        // Normalize the two linked lists.
        head1 = normalizeLinkedList(head1);
        head2 = normalizeLinkedList(head2);

        // Initialize the quotient linked list.
        Node resultHead = null;

        // Iterate over the dividend linked list from left to right.
        while (head1 != null) {
            // Find the largest multiple of the divisor that is less than or equal to the current digit of the dividend.
            int quotientDigit = findLargestMultipleOfDivisor(head1, head2);

            // Update the quotient linked list with the quotient digit.
            Node newNode = new Node(quotientDigit);
            newNode.next = resultHead;
            resultHead = newNode;

            // Subtract the largest multiple of the divisor from the current digit of the dividend.
            head1 = subtractLinkedLists(head1, multiplyLinkedListByDigit(head2, quotientDigit));
        }

        return resultHead;
    }

    private static Node normalizeLinkedList(Node head) {
        // Remove any leading zeros from the linked list.
        while (head != null && head.data == 0) {
            head = head.next;
        }

        return head;
    }

    private static int findLargestMultipleOfDivisor(Node head1, Node head2) {
        int largestMultiple = 0;

        // Iterate over the dividend linked list from left to right until we reach a digit that is less than the divisor or we reach the end of the linked list.
        while (head1 != null && head1.data >= head2.data) {
            // Increment the largest multiple.
            largestMultiple++;

            // Subtract the divisor from the current digit of the dividend.
            head1 = subtractLinkedLists(head1, head2);
        }

        return largestMultiple;
    }

    private static Node subtractLinkedLists(Node head1, Node head2) {
        // Normalize the two linked lists.
        head1 = normalizeLinkedList(head1);
        head2 = normalizeLinkedList(head2);

        // Initialize the difference linked list.
        Node differenceHead = null;

        // Iterate over the two linked lists from right to left.
        while (head1 != null && head2 != null) {
            // Subtract the corresponding digits of the two linked lists.
            int differenceDigit = head1.data - head2.data;

            // If the difference digit is negative, borrow from the next digit of the dividend.
            if (differenceDigit < 0) {
                differenceDigit += 10;
                head1.next.data--;
            }

            // Update the difference linked list with the difference digit.
            Node newNode = new Node(differenceDigit);
            newNode.next = differenceHead;
            differenceHead = newNode;

            // Move to the next digits of the two linked lists.
            head1 = head1.next;
            head2 = head2.next;
        }

        return differenceHead;
    }

    private static Node multiplyLinkedListByDigit(Node head, int digit) {
        // Normalize the linked list.
        head = normalizeLinkedList(head);

        // Initialize the product linked list.
        Node productHead = null;

        // Iterate over the linked list from right to left.
        while (head != null) {
            // Multiply the current digit of the linked list by the digit.
            int productDigit = head.data * digit;

            // Update the product linked list with the product digit.
            Node newNode = new Node(productDigit);

        }
     return productHead;
    }
}