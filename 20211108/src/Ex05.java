
public class Ex05 {

	public static void main(String[] args) {
		// �迭�� ũ�� (�迭��.length)
		int i [] = new int[] {1, 2, 3, 4, 5};
		System.out.println(i.length);
		// �迭�� �ִ� ���� �հ踦 ���Ͻÿ�.
		int sum = 0;
		for(int j = 0; j< i.length; j++) {
			sum += i[j];
		}
		System.out.println(sum);
		System.out.println("==============");
		// ũ�Ⱑ 10�� �迭�� ����� Math.random�� �̿��Ͽ�
		// �迭�� ������ ���� �����Ͻÿ�. for �� ���
		// ���� ���� 1 ~ 100
		int num [] = new int [10];
		for (int j = 0; j<num.length; j++) {
			num[j] = (int)(Math.random()*100) + 1;
			System.out.println(num[j]);
		}
		sum = 0;
		for (int j = 0; j<num.length; j++) {
			System.out.println(num[j]);
			sum += num[j];
		}
		System.out.println(sum);
		
		
	}

}
