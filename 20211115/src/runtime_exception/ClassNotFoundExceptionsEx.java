package runtime_exception;

public class ClassNotFoundExceptionsEx {

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("java.util.List");
			System.out.println("클래스가 있습니다.");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 끝");
	}

}
