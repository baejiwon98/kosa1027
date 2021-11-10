import java.util.Scanner;

public class BankTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank [] banks = new Bank[100];
		boolean replay = true;
		int arraynum = 0;
		
		while(replay) {
			System.out.println("1. 계좌 등록 | 2. 계좌 출력 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.print("선택 > ");
			int num = sc.nextInt();
			sc.nextLine();
			switch(num) {
			case 1 :
				System.out.println("계좌를 등록합니다.");
				System.out.print("계좌를 입력하세요 : ");
				String account = sc.nextLine();
				System.out.print("계좌주를 입력하세요 : ");
				String name = sc.nextLine();
				System.out.print("금액을 입력하세요 : ");
				int money = sc.nextInt();
				banks[arraynum]= new Bank(account, name, money);
				arraynum ++;
				System.out.println("계좌 등록을 완료했습니다.");
				break;
			case 2 : 
				System.out.println("계좌를 출력합니다.");
				System.out.println("계좌\t\t 계좌주\t\t 금액");
				for (int i = 0; i< banks.length; i++) {
					if (banks[i] == null) break;
					System.out.println(banks[i].getAccount() + "\t\t" + banks[i].getName() + "\t\t" + banks[i].getMoney());
				}
				System.out.println("계좌 출력을 완료했습니다.");
				break;
			case 3 : 
				System.out.println("계좌에 예금합니다.");
				System.out.print("입금할 계좌를 입력해주세요. : ");			
				account = sc.nextLine();
				
				for (int i = 0; i< banks.length; i++) {
					if(account.equals(banks[i].getAccount())) {
						System.out.print("입금할 금액을 입력하세요 : ");
						money = sc.nextInt();
						int result = banks[i].getMoney() + money;
						banks[i].setMoney(result);
						break;
					}
					else{
						System.out.println("입금할 계좌가 없습니다.");
						break;
					}
				}
				System.out.println("입금을 완료했습니다.");
				break;
			case 4 : 
				System.out.println("계좌에서 출금합니다.");
				System.out.print("출금할 계좌를 입력해주세요. : ");			
				account = sc.nextLine();
				
				for (int i = 0; i< banks.length; i++) {
					if(account.equals(banks[i].getAccount())) {
						System.out.print("출금할 금액을 입력하세요 : ");
						money = sc.nextInt();
						int result = banks[i].getMoney() - money;
						banks[i].setMoney(result);
						break;
					}
					else{
						System.out.println("출금할 계좌가 없습니다.");
						break;
					}
				}
				System.out.println("출금을 완료했습니다.");
				break;
			case 5 : 
				System.out.println("프로그램을 종료합니다.");
				replay = false;
				break;
			}
		}
	}

}
