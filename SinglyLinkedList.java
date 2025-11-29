class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;
    private int size;
    
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }
    
    // Insert at beginning - O(1)
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Inserted " + data + " at beginning");
    }
    
    // Insert at end - O(n)
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if(head == null) {
            head = newNode;
            size++;
            return;
        }
        
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
        System.out.println("Inserted " + data + " at end");
    }
    
    // Insert at specific position - O(n)
    public void insertAtPosition(int data, int position) {
        if(position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }
        
        if(position == 0) {
            insertAtBeginning(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node current = head;
        
        for(int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("Inserted " + data + " at position " + position);
    }
    
    // Delete from beginning - O(1)
    public void deleteFromBeginning() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        
        int deletedData = head.data;
        head = head.next;
        size--;
        System.out.println("Deleted " + deletedData + " from beginning");
    }
    
    // Delete from end - O(n)
    public void deleteFromEnd() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if(head.next == null) {
            int deletedData = head.data;
            head = null;
            size--;
            System.out.println("Deleted " + deletedData + " from end");
            return;
        }
        
        Node current = head;
        while(current.next.next != null) {
            current = current.next;
        }
        
        int deletedData = current.next.data;
        current.next = null;
        size--;
        System.out.println("Deleted " + deletedData + " from end");
    }
    
    // Delete specific value - O(n)
    public void deleteValue(int value) {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if(head.data == value) {
            deleteFromBeginning();
            return;
        }
        
        Node current = head;
        while(current.next != null && current.next.data != value) {
            current = current.next;
        }
        
        if(current.next == null) {
            System.out.println("Value " + value + " not found");
            return;
        }
        
        current.next = current.next.next;
        size--;
        System.out.println("Deleted " + value);
    }
    
    // Search - O(n)
    public boolean search(int value) {
        Node current = head;
        while(current != null) {
            if(current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Get element at index - O(n)
    public int get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    // Display list - O(n)
    public void display() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        
        System.out.print("List: ");
        Node current = head;
        while(current != null) {
            System.out.print(current.data);
            if(current.next != null) {
                System.out.print(" → ");
            }
            current = current.next;
        }
        System.out.println(" → null");
    }
    
    // Reverse list - O(n)
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
        System.out.println("List reversed");
    }
    
    // Find middle element - O(n)
    public int findMiddle() {
        if(head == null) {
            throw new IllegalStateException("List is empty");
        }
        
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;
    }
    
    // Detect cycle - O(n)
    public boolean hasCycle() {
        if(head == null) return false;
        
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                return true;
            }
        }
        
        return false;
    }
    
    // Get size
    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);
        list.display();
        
        list.insertAtPosition(15, 2);
        list.display();
        
        System.out.println("Search 20: " + list.search(20));
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Middle element: " + list.findMiddle());
        
        list.deleteValue(15);
        list.display();
        
        list.reverse();
        list.display();
    }
}
