public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(2);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println("reverse");
        list.reverse();
        list.print();
        list.add(41000);
        list.print();
    }
}
