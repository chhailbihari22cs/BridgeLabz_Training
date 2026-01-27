import java.util.*;
public class HighestKeyValue {

	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("A",10);
		map.put("B",20);
		map.put("C",15);
		String maxKey = null;
		int maxValue = Integer.MIN_VALUE;
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue()>maxValue) {
				maxKey = entry.getKey();
				maxValue = entry.getValue();
			}
		}
		
		System.out.println("Max key is: "+maxKey);
	}

}
