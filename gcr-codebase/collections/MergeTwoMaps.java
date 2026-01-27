import java.util.*;
public class MergeTwoMaps {

	public static void main(String[] args) {
		
		HashMap<String,Integer> map1 = new HashMap<>();
		map1.put("A", 1);
		map1.put("B", 2);
		
		HashMap<String,Integer> map2 = new HashMap<>();
		map2.put("B", 3);
		map2.put("C", 4);
		
		HashMap<String,Integer> ans = new HashMap<>();
		
		for(Map.Entry<String, Integer> entry : map1.entrySet()) {
			ans.put(entry.getKey(), entry.getValue());
		}
		
		for(Map.Entry<String, Integer> entry : map2.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			if(ans.containsKey(key)) {
				ans.put(key, ans.get(key)+value);
			}else {
				ans.put(key, value);
			}
		}
		
		System.out.println(ans);

	}

}
