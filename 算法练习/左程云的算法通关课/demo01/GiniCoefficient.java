/**
һ��ʼ��100���ˣ�ÿ���˶���100Ԫ
��ÿһ�ֶ������µ����� : 
ÿ���˶������ó�1ԪǮ�����Լ�����������ˣ���˭��ȫ���
���ĳ��������һ�ֵ�Ǯ��Ϊ0����ô�����Բ��������ǿ��Խ���
�����ܶ�ܶ���֮����100�˵����Ƹ��ֲ��ܾ�����
*/
import java.util.Arrays;

public class GiniCoefficient {

    public static void main(String[] args) {
        System.out.println("һ�����Ļ���ϵ����һ����0~1֮���С��");
		System.out.println("����ϵ��Ϊ0���������˵ĲƸ���ȫһ��");
		System.out.println("����ϵ��Ϊ1������1����������ȫ���ĲƸ�");
		System.out.println("����ϵ��ԽС���������Ƹ��ֲ�Խ���⣻Խ�������Ƹ��ֲ�Խ������");
		System.out.println("��2022�꣬���������ƽ������ϵ��Ϊ0.44");
		System.out.println("Ŀǰ�ձ���Ϊ��������ϵ������ 0.5 ʱ");
		System.out.println("����ζ�����ƶ�����ǳ��󣬷ֲ��ǳ�������");
		System.out.println("�����ܻ��������Σ������������ķ�����߾�����ᶯ��");
		System.out.println("���Կ�ʼ");
		int n = 100;
		int t = 1000000;
		System.out.println("������" + n);
		System.out.println("������" + t);
		experiment(n, t);
		System.out.println("���Խ���");
    }

    public static void experiment(int n, int t) {
		double[] wealth = new double[n];
		Arrays.fill(wealth, 100);

		boolean[] hasMoney = new boolean[n];

		for (int i = 0; i < t; i++) {
			Arrays.fill(hasMoney, false);
			for (int j = 0; j < n; j++) {
				if (wealth[j] > 0) {
					hasMoney[j] = true;
				}
			}

			for (int j = 0; j < n; j++) {
				if (hasMoney[j]) {
					int other = j;
					do {
						other = (int) (Math.random() * n);
					} while (other == j);
					wealth[j]--;
					wealth[other]++;
				}
			}
		}

		Arrays.sort(wealth);
		System.out.println("�г�ÿ���˵ĲƸ���ƶ����У���");
		for (int i = 0; i < n; i++) {
			System.out.print((int) wealth[i] + " ");
			if (i % 10 == 9) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("������Ļ���ϵ��Ϊ��" + getGiniCoefficient(wealth));

    }

    public static double getGiniCoefficient(double[] wealth) {
		double sumOfAbsoluteDifferences = 0;
		double sumOfWealth = 0;
		int n = wealth.length;

		for (int i = 0; i < n; i++) {
			sumOfWealth += wealth[i];
			for (int j = 0; j < n; j++) {
				sumOfAbsoluteDifferences += Math.abs(wealth[i] - wealth[j]);
			}
		}

		return sumOfAbsoluteDifferences / (2 * n * sumOfWealth);
    }
}

