import java.util.*;
public class SetSymmetricDifference {

	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		Set<Integer> set2 = new HashSet<>();
		set2.add(3);
		set2.add(4);
		set2.add(5);
		
		Set<Integer> diff = new HashSet<>();
		
		for(int num : set1) {
			if(!set2.contains(num)) {
				diff.add(num);
			}
		}
		
		for(int num : set2) {
			if(!set1.contains(num)) {
				diff.add(num);
			}
		}
		
		System.out.println("Difference is: "+diff);
	}

}
