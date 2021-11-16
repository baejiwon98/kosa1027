package StringClass;

public class StringMethod {

	public static void main(String[] args) {
		String ssn = "010624-1230123";
		//            01234567890123
		char ch = ssn.charAt(7);
		switch(ch) {
		case '1' : 
		case '3' : System.out.println("남자"); break;
		case '2' :
		case '4' : System.out.println("여자"); break;
		}
		System.out.println(ssn.charAt(7));
		String str = "나는 자바가 너무 재미있어요.";
		//            01 23 4567 890 123 45
		System.out.println(str.charAt(10));
		//charAt():index에 해당하는 문자를 가져옴.
		
		// Method 정리
		String str1 = "apple";
		boolean b1 = str1.startsWith("ap");
		System.out.println(b1);
		b1 = str1.startsWith("le");
		System.out.println(b1);
		
		b1 = str1.endsWith("le");
		System.out.println(b1);
		
		str = new String("java");
		str1 = new String("java");
		System.out.println(str1 == str); // false
		System.out.println(str1.equals(str));
		
		str1 = "I like the java";
		//      012345678901234
		System.out.println(str1.indexOf("t"));
		System.out.println(str1.indexOf("a"));
		System.out.println(str1.lastIndexOf("a"));
		System.out.println(str1.length());
		int [] ii = new int[5];
		System.out.println(ii.length);
		
		System.out.println(str1.replace("I", "i"));
		System.out.println(str1.replace("I", "You"));
		
		str = "A:B:C:D:abcd";
		String [] str2 = str.split(":");
		System.out.println(str2[1]);
		
		//slicing : a = "abcdef" : a[1:3] substring
		str1 = "abcdef";
		System.out.println(str1.substring(1,  1+2));
		
		str1 = "abcDEF";
		System.out.println(str1.toLowerCase());
		System.out.println(str1.toUpperCase());
		
		Integer i = 10;
		str = "10" + i.toString(); // 숫자들 문자로 변경
		System.out.println(str);
		
		str1 = " abc DEF "; // strip
		System.out.println(str1.trim());
		
		str1 = "I like the java";
		//      012345678901234
		int start = str1.indexOf("t");
		System.out.println(str1.substring(start, start+8));
		
		str = "A:B/C-D,abcd";
		str2 = str.split(":|/|-|,");
		System.out.println(str2[1]);
	}
}
