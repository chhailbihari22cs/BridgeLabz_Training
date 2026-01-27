import java.util.*;

public class ReverseList {
	public static void main(String args[]) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		System.out.println("Original List: "+arrayList);
		reverseArrayList(arrayList);
		System.out.println("Reversed List: "+arrayList);
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		System.out.println("Original LinkedList: "+linkedList);
		reverseLinkedList(linkedList);
		System.out.println("Reversed LinkedList: "+linkedList);
		
	}
	
	public static void reverseArrayList(ArrayList<Integer> arrayList) {
		int left = 0;
		int right = arrayList.size()-1;
		while(left < right) {
			int temp = arrayList.get(left);
			arrayList.set(left, arrayList.get(right));
			arrayList.set(right, temp);
			left++;
			right--;
		}
	}
	
	
	public static void reverseLinkedList(LinkedList<Integer> linkedList) {
		int left = 0;
		int right = linkedList.size()-1;
		while(left < right) {
			int temp = linkedList.get(left);
			linkedList.set(left, linkedList.get(right));
			linkedList.set(right, temp);
			left++;
			right--;
		}
	}
}
