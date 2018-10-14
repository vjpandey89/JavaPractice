package sorting;

public class MergeSort {

	public static int recursionCount = 1;

	// Driver Method
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.print("Given array");

		for (int i : arr)
			System.out.print(" " + i);

		MergeSort ob = new MergeSort();
		ob.sort(arr);

		System.out.print("\nSorted array");

		for (int i : arr)
			System.out.print(" " + i);

	}

	private void sort(int[] arr) {
		int[] helper = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length - 1);

	}

	private void mergeSort(int[] arr, int[] helper, int low, int high) {

		if (low < high) {
			int med = (low + high) / 2;

			mergeSort(arr, helper, low, med);

			mergeSort(arr, helper, med + 1, high);
			merge(arr, helper, low, med, high);
		}
	}

	private void merge(int[] arr, int[] helper, int low, int med, int high) {

		int helpIndex = low;
		int helpLeft = low;
		int helpRight = med + 1;

		for (int i = low; i <= high; i++)
			helper[i] = arr[i];

		while (helpLeft <= med && helpRight <= high) {
			if (helper[helpLeft] <= helper[helpRight]) {
				arr[helpIndex] = helper[helpLeft];
				helpLeft++;

			} else {
				arr[helpIndex] = helper[helpRight];
				helpRight++;

			}
			helpIndex++;
		}

		while (helpLeft <= med)
			arr[helpIndex++] = helper[helpLeft++];

		while (helpRight <= high)
			arr[helpIndex++] = helper[helpRight++];

	}

}
