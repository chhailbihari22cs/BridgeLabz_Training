import java.util.*;
public class WordFrequencyProblem {

	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		String input = "Hello world, hello Java!";
		input = input.toLowerCase().replaceAll("[^a-z]", " ");
		
		String words[] = input.split("\\s+");
		for(String word : words) {
			if(map.containsKey(word)) {
				map.put(word, map.get(word)+1);
			}else {
				map.put(word, 1);
			}
		}
		
		System.out.println("Word count is: "+map);
	}

}
