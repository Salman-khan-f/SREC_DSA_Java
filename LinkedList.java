class LinkedList {
    Node head; // Instance var 

    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node findNthFromEnd(int n) { //2
        Node first = head;  // 2   null
        Node second = head;

        for (int i = 0; i < n; i++) {
            if (first == null) return null;  
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        int n = 2;
        Node result = list.findNthFromEnd(n);

        if (result != null)
            System.out.println("Nth node from end = " + result.data);
        else
            System.out.println("N is greater than list size");
    }
}
