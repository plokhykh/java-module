
public class SinglyLinkedList {
    private Node head;

    static class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void add(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void print() {
        if (head != null) {
            System.out.println(head.value);
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            System.out.println(currentNode.value);
        }
    }

    public void reverse() {
       Node currentNode = head;
       Node previousNode = null, nextNode;
       while(currentNode != null){
           nextNode = currentNode;
           currentNode = currentNode.next;

           nextNode.next = previousNode;
           previousNode = nextNode;
           head = previousNode;
       }
    }

}
