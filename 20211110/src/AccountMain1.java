import java.util.Scanner;

public class AccountMain1 {
	static Account[] accs = new Account[100];
	static Scanner sc = new Scanner(System.in);
	static int arrayNum = 0; // 배열의 현재 번호를 가지기 위한 변수
	
	static boolean run = true;
	
	public static void main(String[] args) {

		do {
			System.out.println("1. 계좌등록 | 2. 계좌 목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.print("선택 > ");
			int selectNo = sc.nextInt();
			sc.nextLine();// nextLine사용할 경우, 선언 한번 해줘야함 -> 입력장치에 \n값이 있는 것을 없애기 위해 사용
//			String selectNo = sc.nextLine(); -> 아님 nextInt없애고 이거쓰던가
			switch(selectNo) {
			case 1 :
				System.out.println("계좌등록 페이지입니다.");
				System.out.print("계좌 번호 : ");
				String accountNo = sc.nextLine();
				System.out.print("예금주 : ");
				String owner = sc.nextLine();
				System.out.print("금액 : ");
				int money = sc.nextInt();
				accs[arrayNum] = new Account(accountNo, owner, money);
				arrayNum++;
				System.out.println("계좌 등록이 완료되었습니다.");
				break;
			case 2 :
				System.out.println("계좌 목록 페이지입니다.");
				System.out.println("계좌 번호\t\t 계좌주 \t\t 금액");
				
				accountPrint();
				
				break;
			case 3 :
				System.out.println("예금 페이지입니다.");
				System.out.print("계좌번호 : ");
				accountNo = sc.nextLine();
				System.out.print("예금액 : ");
				money = Integer.parseInt(sc.nextLine());
				Account acc = accountFind(accountNo);
				
				int result = acc.getBalance() + money;
				acc.setBalance(result);
				System.out.println();
				break;
			case 4 : 
				System.out.println("출금 페이지입니다.");
				System.out.print("계좌번호 : ");
				accountNo = sc.nextLine();
				System.out.print("출금액 : ");
				money = Integer.parseInt(sc.nextLine());
				acc = accountFind(accountNo);
				
				result = acc.getBalance() - money;
				acc.setBalance(result);
				System.out.println();
				break;
			case 5 :
				System.out.println("프로그램을 종료합니다.");
				run = false; break;
//				System.exit(0); // 프로그램 종료
			}
//		}
		}while(run);
	}
	
	public static Account accountFind(String accountNo) {
		for(int i = 0; i< accs.length; i++) {
			if(accs[i] == null) break;
			else {
				if(accs[i].getAccountNo().equals(accountNo)) {
					// 계좌번호가 일치하는 Account를 가지고 와서 acc에 저장
					return accs[i];
				}				
			}
		}
		return null; // 흠 null 리턴...
	}
	
	public static void accountPrint() {
		for(int i = 0; i < accs.length; i++) {
			if (accs[i] == null) break;
			System.out.println(accs[i].getAccountNo()+"\t\t" + accs[i].getOwner()+"\t\t" + accs[i].getBalance());
		}
	}

}



