/**
在有序数组中找<=num的最右位置
*/
import java.util.Arrays;
public class FindNumRight{

	public static void main(String[] args){
		int testCount = 10;
		int arrLength = 5;
		int v = 10;

		System.out.println("测试开始");
		while (testCount > 0) {
			int n = (int) (Math.random() * arrLength + 1);
			int[] arr = getNewArray(n, v);
			int num = (int) (Math.random() * v + 1);
			System.out.println("arr: " + Arrays.toString(arr) + "n: " + num);
			int res1 = violenceFind(arr, num);
			int res2 = find(arr, num);
			if (res1 != res2) {
				System.out.println("出错了");
				System.out.println("res1: " + res1);
				System.out.println("res2: " + res2);
				System.out.println("arr: " + Arrays.toString(arr));
				break;
			}
			testCount--;
		}
		System.out.println("测试结束");
	
	}

	public static int[] getNewArray(int n, int v){
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++){
			arr[i] = (int) (Math.random() * v + 1);
		}
		Arrays.sort(arr);
		return arr;
	}
	
	// 暴力求解
	public static int violenceFind(int[] arr, int num){
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] <= num) {
				return i;
			}
		}
		return -1;
	}

	public static int find(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		int l = 0;
		int r = arr.length - 1;
		int m = -1;

		while (l <= r) {
			int temp = l + ((r - l) >> 1);

			if (arr[temp] <= num) {
				l = temp + 1;
				m = temp;
			}else {
				r = temp - 1;
			}
		}
		return m;
	}

}