import java.util.Calendar;

public class Ex15 {

	public static void main(String[] args) {
		WEEK today; // ������ ��� ���� ����
		today = WEEK.MONDAY; // ������ ������ ������� ����
		System.out.println(today);
		// ��� ��
		// Calendar�� ��¥�� ����ϱ� ���� �ڷ����̴�.
		Calendar cal = Calendar.getInstance();
		// ������ ������ ����.
		int week = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(week); // 2: ������
		switch(week){
		case 1 : today = WEEK.SUNDAY; break;
		case 2 : today = WEEK.MONDAY; break;
		case 3 : today = WEEK.THURSDAY; break;
		case 4 : today = WEEK.WEDNESDAY; break;
		case 5 : today = WEEK.THURSDAY; break;
		case 6 : today = WEEK.FRIDAY; break;
		case 7 : today = WEEK.SATURDAY; break;
		}
		System.out.println(today);
		if(today == WEEK.SUNDAY) {
			System.out.println("���� �����");
		}else {
			System.out.println("������ ���� �մϴ�.");
		}
	}

}