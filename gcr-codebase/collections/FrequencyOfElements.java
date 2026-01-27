import java.util.*;

public class FrequencyOfElements {

	public static void main(String[] args) {
		
		String input[] = {"apple", "banana", "apple", "orange"};
		HashMap<String,Integer> map = new HashMap<>();
		
		for(String item : input) {
			if(map.containsKey(item)) {
				map.put(item, map.get(item)+1);
			}else {
				map.put(item, 1);
			}
		}
		
		System.out.println(map);

	}

}
