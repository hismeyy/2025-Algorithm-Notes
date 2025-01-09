/**
������������ȷ��num���ڻ��ǲ�����
*/
import java.util.Arrays;
public class FindNum{
	
	public static void main(String[] args){
		int testCount = 500;
		int arrLength = 10;
		int v = 50;

		System.out.println("���Կ�ʼ");
		while (testCount > 0) {
			int n = (int) (Math.random() * arrLength + 1);
			int[] arr = getNewArray(n, v);
			int num = (int) (Math.random() * v + 1);
			boolean res1 = violenceFind(arr, num);
			boolean res2 = find(arr, num);
			if (res1 != res2) {
				System.out.println("������");
				System.out.println("arr: " + Arrays.toString(arr));
				break;
			}
			testCount--;
		}
		System.out.println("���Խ���");
	
	}

	public static int[] getNewArray(int n, int v){
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++){
			arr[i] = (int) (Math.random() * v + 1);
		}
		Arrays.sort(arr);
		return arr;
	}
	
	// �������
	public static boolean violenceFind(int[] arr, int num){
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return true;
			}
		}
		return false;
		
	}

	// ���ֲ���
	public static boolean find(int[] arr, int num){
		if (arr == null || arr.length == 0){
			return false;
		}

		int l = 0;
		int r = arr.length - 1;
		int m = -1;

		while (l <= r) {
			m = l + ((r - l) >> 1);
			if (arr[m] == num) {
				return true;
			}else if (arr[m] > num) {
				r = m - 1;
			}else {
				l = m + 1;
			}
		}

		return false;
	}

}