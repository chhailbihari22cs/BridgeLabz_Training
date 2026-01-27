import java.util.*;
public class BinaryNumbersGeneration {

	public static void main(String[] args) {
		
		int n = 5;
		Queue<String> queue = new LinkedList<>();
		
		for(int i = 1; i<= n;i++) {
			StringBuilder ans = new StringBuilder();
			int temp = i;
			while(temp>=1) {
				ans.append(temp%2);
				temp /= 2;
			}
			queue.add(ans.reverse().toString());
		}
		System.out.println(queue);

	}

}
