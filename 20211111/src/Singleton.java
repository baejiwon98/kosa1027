
public class Singleton {
	int first;
	int second;
	static int val = 10;
	//// ½Ì±ÛÅæ
	private static Singleton singleton = new Singleton();
	
	private Singleton() {}
	public static Singleton getInstance() { // ÀÚ½ÅÀÇ °´Ã¼¸¦ Àü´Ş
		return singleton;
	}
	///
	
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
}
