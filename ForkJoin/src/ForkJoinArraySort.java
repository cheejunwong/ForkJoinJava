import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

// Main class
public class ForkJoinArraySort {

	public static void main(String[] args) {

		System.out.print("Enter size of array: ");
		Scanner input = new Scanner(System.in);
		int arraySize = input.nextInt();

		System.out.print("Choose 1 (merge sort) or 2 (quick sort): ");
		int sortOption = input.nextInt();

		// Create a pool of threads
		ForkJoinPool pool = new ForkJoinPool();
		int[] array = createArray(arraySize);
		long startTime;
		long endTime;

		if (sortOption == 1) {
			// merge sort with fork-join API
			ForkJoinMergeSort mergeSort = new ForkJoinMergeSort(array, 0, array.length - 1);
			startTime = System.currentTimeMillis();

			// Start execution and wait for result/return
			pool.invoke(mergeSort);

			endTime = System.currentTimeMillis();
			pool.shutdown();

			System.out.println("Time taken with merge sort: " + (endTime - startTime) + " millis");

		} else {
			// quick sort with fork-join API
			ForkJoinQuickSort quickSort = new ForkJoinQuickSort(array);
			startTime = System.currentTimeMillis();

			// Start execution and wait for result/return
			pool.invoke(quickSort);

			endTime = System.currentTimeMillis();
			pool.shutdown();

			System.out.println("Time taken with quick sort: " + (endTime - startTime) + " millis");

		}

	}

	// Create array with random data
	private static int[] createArray(final int size) {
		int[] array = new int[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt(1000);
		}
		return array;
	}
}