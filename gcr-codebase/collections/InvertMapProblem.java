import java.util.*;
public class InvertMapProblem {

	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("A",1);
		map.put("B",2);
		map.put("C",1);

		HashMap<Integer,List<String>> invertmap = new HashMap<>();
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			Integer value = entry.getValue();
			String key = entry.getKey();
			
			if(!invertmap.containsKey(value)) {
				invertmap.put(value, new ArrayList<>());
			}
			invertmap.get(value).add(key);
			
		}
		System.out.println(invertmap);
	}

}
