import java.util.*;

public class RemoveDuplicatesFromList {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
		
		List<Integer> ans = new ArrayList<>();
		for(int num : list) {
			if(!ans.contains(num)) {
				ans.add(num);
			}
		}
		
		System.out.println("Updated Output: "+ans);

	}

}
