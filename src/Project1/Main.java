package Project1;//Project1.Main class is going to implement all together,And is going to be able to distuingish different operations//

//first array then linked list//



import Project1.Addition;
import Project1.Subtraction;
import static Project1.Addition.addLinkedLists;
import static Project1.Subtraction.subtractLinkedLists;


public class Main {
    public static void main(String[] args) {
        String strNum1 = "1234";
        String strNum2 = "567";

        Node head1= LinkedList.stringOfNumbersToLinkedList(strNum1);
        Node head2= LinkedList.stringOfNumbersToLinkedList(strNum2);

        Node resultHead = Addition.addLinkedLists(head1, head2);
        System.out.println("The sum is: ");
        printLinkedList(resultHead );

        Node resultHead1 = Subtraction.subtractLinkedLists(head1, head2);
        System.out.println("The difference is: ");
        printLinkedList(resultHead1);

        Node resultHead2 = Multiplication.multiplyLinkedLists(head1, head2);
        System.out.println("The multipliation is: ");
        printLinkedList(resultHead2);

        Node resultHead3= Division.divideLinkedLists(head1, head2);
        System.out.println("The division is: ");
        printLinkedList(resultHead3);
    }

    private static void printLinkedList(Node head)

    {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "");
            current = current.next;
        }
        System.out.println("");
    }


}

