import java.util.*;
public class SetUnionAndIntersection {

	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		Set<Integer> set2 = new HashSet<>();
		set2.add(3);
		set2.add(4);
		set2.add(5);
		
		Set<Integer> union = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
		
		for (int num : set1) {
            union.add(num);
        }
        for (int num : set2) {
            if (!union.contains(num)) {
                union.add(num);
            }
        }

        for (int num : set1) {
            if (set2.contains(num)) {
                intersection.add(num);
            }
        }

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);

	}

}
