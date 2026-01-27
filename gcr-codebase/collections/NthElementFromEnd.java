import java.util.*;
public class NthElementFromEnd {

	public static void main(String[] args) {
		
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("A");
		linkedList.add("B");
		linkedList.add("C");
		linkedList.add("D");
		linkedList.add("E");
		
		int n = 2;
		System.out.println(findNthElement(linkedList,n));

	}
	
	public static String findNthElement(LinkedList<String> list, int n) {

        Iterator<String> it1 = list.iterator();
        Iterator<String> it2 = list.iterator();
        
        for (int i = 0; i < n; i++) {
            it1.next();
        }

        while (it1.hasNext()) {
            it1.next();
            it2.next();
        }

        return it2.next();
    }

}
