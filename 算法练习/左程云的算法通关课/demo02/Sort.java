public class Sort {
	
	public static void main (String[] args) {
		int[] arr = {5, 3, 2, 4, 1};
		insertionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void swap (int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	// —°‘Ò≈≈–Ú
	public static void selectSort (int[] arr) {
		if (arr == null || arr.length <= 2) {
			return;
		}
		
		int minIndex;

		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}

	// √∞≈›≈≈–Ú
	public static void bubbleSort (int[] arr) {
		if (arr == null || arr.length <= 2) {
			return;
		}
		
		for (int i = arr.length - 1; i > 0; i--) {
			
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	// ≤Â»Î≈≈–Ú
	public static void insertionSort (int[] arr) {
		if (arr == null || arr.length <= 2) {
			return;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j, j + 1);
			}
		}
	}

}