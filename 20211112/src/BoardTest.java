import java.util.Scanner;

public class BoardTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board [] board = new Board[100];
		boolean replay = true;
		int arraynum = 0;
		
		while(replay) {
			System.out.println("�� ���");
			System.out.println("��ȣ\t\t�۾���\t\t����\t\t���� ��");
			for (int i =0; i< board.length; i++) {
				if (board[i] == null) {
					System.out.println("�� ����� �����ϴ�.");
					break;
				}else
				System.out.println(board[i].getNum() + "\t\t" + board[i].getName() + "\t\t" + board[i].getSubject() + "\t\t" + board[i].getVisit() + "\t\t");
			}
			System.out.println();
			System.out.println("=======================================");
			System.out.println("1. �۾��� | 2. �󼼺���");
			System.out.print("���� > ");
			int select = sc.nextInt();
			sc.nextLine();
			switch(select) {

			case 1 :
				System.out.println("�� �ۼ� ������ �Դϴ�.");
				System.out.print("�۾��� : ");
				String name = sc.nextLine();
				System.out.print("���� : ");
				String subject = sc.nextLine();
				System.out.print("���� : ");
				String content = sc.nextLine();
				System.out.print("�����Ϸ��� y, �ٽ� ������ n : ");
				String choice = sc.nextLine();
				switch(choice) {
				case "y":
					board[arraynum]= new Board(arraynum+1, name, subject, content, 0);
					arraynum ++;
					System.out.println("����� �Ϸ��߽��ϴ�.");
					break;
				case "n":
					
					break;
				}
				break;
			case 2 :
				System.out.print("���� ���� �Խñ��� ��ȣ�� �Է��ϼ���. : ");
				int want = sc.nextInt();
				for (int i = 0; i < board.length; i++) {
					
				}
				break;	
			}
		}
	}

}
