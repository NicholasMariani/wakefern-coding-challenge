package wakefern.SinglyLinkedList;

public class Driver {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(10);
        list.insertAtBeginning(5);
        list.insertAtEnd(15);
        list.insertAtPosition(12, 2);

        System.out.print("List after insertions: ");
        list.traverse();

        System.out.println("Search for 12: " + list.search(12));
        System.out.println("Search for 20: " + list.search(20));

        list.deleteFromBeginning();
        list.deleteFromEnd();
        list.deleteFromPosition(1);

        System.out.print("List after deletions: ");
        list.traverse();

        list.insertAtEnd(20);
        list.insertAtEnd(30);
        System.out.print("List before reversing: ");
        list.traverse();

        list.reverse();
        System.out.print("List after reversing: ");
        list.traverse();
    }
}