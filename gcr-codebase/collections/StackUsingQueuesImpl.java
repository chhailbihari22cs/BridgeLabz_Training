import java.util.*;
public class StackUsingQueuesImpl {
	
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	
	public void push(int ele) {
		q2.add(ele);
		
		while(!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		
		Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
	}
	
	public int pop() {
		if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.remove();
	}
	
	public int top() {
		if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
	}
	

	public static void main(String[] args) {
		StackUsingQueuesImpl stack = new StackUsingQueuesImpl();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.top());

	}

}
