import java.util.Scanner;

public class BoardTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board [] board = new Board[100];
		boolean replay = true;
		int arraynum = 0;
		
		while(replay) {
			System.out.println("글 목록");
			System.out.println("번호\t\t글쓴이\t\t제목\t\t읽은 수");
			for (int i =0; i< board.length; i++) {
				if (board[i] == null) {
					System.out.println("글 목록이 없습니다.");
					break;
				}else
				System.out.println(board[i].getNum() + "\t\t" + board[i].getName() + "\t\t" + board[i].getSubject() + "\t\t" + board[i].getVisit() + "\t\t");
			}
			System.out.println();
			System.out.println("=======================================");
			System.out.println("1. 글쓰기 | 2. 상세보기");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			sc.nextLine();
			switch(select) {

			case 1 :
				System.out.println("글 작성 페이지 입니다.");
				System.out.print("글쓴이 : ");
				String name = sc.nextLine();
				System.out.print("제목 : ");
				String subject = sc.nextLine();
				System.out.print("내용 : ");
				String content = sc.nextLine();
				System.out.print("저장하려면 y, 다시 쓰려면 n : ");
				String choice = sc.nextLine();
				switch(choice) {
				case "y":
					board[arraynum]= new Board(arraynum+1, name, subject, content, 0);
					arraynum ++;
					System.out.println("등록을 완료했습니다.");
					break;
				case "n":
					
					break;
				}
				break;
			case 2 :
				System.out.print("보고 싶은 게시글의 번호를 입력하세요. : ");
				int want = sc.nextInt();
				for (int i = 0; i < board.length; i++) {
					
				}
				break;	
			}
		}
	}

}
