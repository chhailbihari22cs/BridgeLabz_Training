import java.util.*;

public class RotateListElements {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10,20,30,40,50));
		int distance = 2;
		Collections.rotate(list, distance);
		System.out.println("Rotated list: "+list);

	}

}
