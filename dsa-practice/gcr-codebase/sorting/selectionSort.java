import java.util.*;

public class selectionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input array length
		System.out.println("Enter the length of an array:");
		int length = sc.nextInt();

		// Declare and initialize the array
		int[] arr = new int[length];
		System.out.println("Please enter the exam scores:");
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}

		// Display array before sorting
		System.out.println("\n___________Array before sorting___________");
		display(arr);

		// Selection Sort Logic
		for (int i = 0; i < arr.length - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min_idx] > arr[j]) {
					min_idx = j;
				}
			}
			// Swap the elements
			int swap = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = swap;
		}

		// Display array after sorting
		System.out.println("\n___________Array after sorting___________");
		display(arr);
	}

	// Method to display the array
	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}
}