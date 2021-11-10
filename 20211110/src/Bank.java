
public class Bank {
	String name;
	String account;
	int money;
	
	public Bank() {}
	
	public  Bank (String account, String name, int money) {
		this.name = name;
		this.account = account;
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
