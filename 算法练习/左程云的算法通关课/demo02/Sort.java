import java.util.Arrays;

public class Sort {
	
	public static void main (String[] args) {
		int testCount = 10;
		int arrLength = 10;
		int v = 10;

		System.out.println("开始测试");
		while(testCount > 0) {
			
			int n = (int) (Math.random() * arrLength + 1);
			int[] arr = getNewArray(n, v);
			int[] arr1 = copyNewArray(arr);
			int[] arr2 = copyNewArray(arr);
			int[] arr3 = copyNewArray(arr);
			selectSort(arr1);
			bubbleSort(arr2);
			insertionSort(arr3);
			if (!(sameArr(arr1, arr2) && sameArr(arr1, arr3) && sameArr(arr2, arr3))) {
				System.out.println("出错了");
				System.out.println("arr: " + Arrays.toString(arr));
				System.out.println("arr1: " + Arrays.toString(arr1));
				System.out.println("arr2: " + Arrays.toString(arr2));
				System.out.println("arr3: " + Arrays.toString(arr3));
				break;
			}

			testCount--;

		}
		System.out.println("结束测试");
		

	}

	/**
	n 数组长度
	v 数组范围
	*/
	public static int[] getNewArray(int n, int v){
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			// 1 ~ v
			arr[i] = (int) (Math.random() * v + 1);
		}
		return arr;
	}

	public static int[] copyNewArray(int[] arr){
		int[] newArr = new int[arr.length];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}

	public static boolean sameArr(int[] arr1, int[] arr2){
		if (arr1.length != arr2.length) {
			return false;
		}

		for(int i = 0; i < arr1.length; i++){
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}

		return true;
	}

	public static void swap (int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	// 选择排序
	public static void selectSort (int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		int minIndex;

		for (int i = 0; i < arr.length - 1; i++) {

			minIndex = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			swap(arr, i, minIndex);
			
		}
		
	}

	// 冒泡排序
	public static void bubbleSort (int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	// 插入排序
	public static void insertionSort (int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = key;
		}
	}

}