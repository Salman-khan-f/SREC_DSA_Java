import java.util.Stack;

public class StacktoQ {

    private Stack<Integer> stack1;  // int a
    private Stack<Integer> stack2;

    public StacktoQ(){
        stack1 = new Stack<>(); // a = 10
        stack2 = new Stack<>();
    }

    public void enqueue(int val){
        stack1.push(val);
    }

    public int dequeue(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StacktoQ queue = new StacktoQ();

        queue.enqueue(88);
        queue.enqueue(77);
        queue.enqueue(43);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    
}