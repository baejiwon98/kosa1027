import java.util.Scanner;

public class BankTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank [] banks = new Bank[100];
		boolean replay = true;
		int arraynum = 0;
		
		while(replay) {
			System.out.println("1. ���� ��� | 2. ���� ��� | 3. ���� | 4. ��� | 5. ����");
			System.out.print("���� > ");
			int num = sc.nextInt();
			sc.nextLine();
			switch(num) {
			case 1 :
				System.out.println("���¸� ����մϴ�.");
				System.out.print("���¸� �Է��ϼ��� : ");
				String account = sc.nextLine();
				System.out.print("�����ָ� �Է��ϼ��� : ");
				String name = sc.nextLine();
				System.out.print("�ݾ��� �Է��ϼ��� : ");
				int money = sc.nextInt();
				banks[arraynum]= new Bank(account, name, money);
				arraynum ++;
				System.out.println("���� ����� �Ϸ��߽��ϴ�.");
				break;
			case 2 : 
				System.out.println("���¸� ����մϴ�.");
				System.out.println("����\t\t ������\t\t �ݾ�");
				for (int i = 0; i< banks.length; i++) {
					if (banks[i] == null) break;
					System.out.println(banks[i].getAccount() + "\t\t" + banks[i].getName() + "\t\t" + banks[i].getMoney());
				}
				System.out.println("���� ����� �Ϸ��߽��ϴ�.");
				break;
			case 3 : 
				System.out.println("���¿� �����մϴ�.");
				System.out.print("�Ա��� ���¸� �Է����ּ���. : ");			
				account = sc.nextLine();
				
				for (int i = 0; i< banks.length; i++) {
					if(account.equals(banks[i].getAccount())) {
						System.out.print("�Ա��� �ݾ��� �Է��ϼ��� : ");
						money = sc.nextInt();
						int result = banks[i].getMoney() + money;
						banks[i].setMoney(result);
						break;
					}
					else{
						System.out.println("�Ա��� ���°� �����ϴ�.");
						break;
					}
				}
				System.out.println("�Ա��� �Ϸ��߽��ϴ�.");
				break;
			case 4 : 
				System.out.println("���¿��� ����մϴ�.");
				System.out.print("����� ���¸� �Է����ּ���. : ");			
				account = sc.nextLine();
				
				for (int i = 0; i< banks.length; i++) {
					if(account.equals(banks[i].getAccount())) {
						System.out.print("����� �ݾ��� �Է��ϼ��� : ");
						money = sc.nextInt();
						int result = banks[i].getMoney() - money;
						banks[i].setMoney(result);
						break;
					}
					else{
						System.out.println("����� ���°� �����ϴ�.");
						break;
					}
				}
				System.out.println("����� �Ϸ��߽��ϴ�.");
				break;
			case 5 : 
				System.out.println("���α׷��� �����մϴ�.");
				replay = false;
				break;
			}
		}
	}

}
