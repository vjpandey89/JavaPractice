package sorting;

public class QuickSort {

	private static void sort(int[] arr, int low, int high) {

		int pivot;
		if (low < high) {
			pivot = partition(arr, low, high);
			sort(arr, low, pivot - 1);
			sort(arr, pivot + 1, high);

		}
	}

	private static int partition(int[] arr, int low, int high) {

		int left;
		int right;
		int pivot = arr[low];
		left = low;
		right = high;
		while (left < right) {
			while (arr[left] <= pivot)
				left++;
			while (arr[right] > pivot)
				right--;
			if (left < right)
				swap(arr, left, right);
		}

		arr[low] = arr[right];
		arr[right] = pivot;
		return right;

	}

	private static void swap(int[] arr, int left, int right) {
		int temp;
		temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;

	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver method
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		printArray(arr);

		QuickSort.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}

}
