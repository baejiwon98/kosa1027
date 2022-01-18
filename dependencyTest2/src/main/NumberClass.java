package main;

public class NumberClass {
	private int i;
	private int j;
	Test1 tt;
	public NumberClass() {}
	public NumberClass(int i, int j) {
		this.i = i;
		this.j = j;
	}
	public void print() {
		System.out.println(tt.getX());
	}
	public NumberClass(Test1 tt) {
		this.tt =tt;
	}
	public void setTt(Test1 tt) {
		this.tt =tt;
	}
	public void setI(int i) {
		this.i = i;
	}
	public void setJ(int j) {
		this.j = j;
	}
}