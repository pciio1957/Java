package Java.a05_condition;

public class Product {
	private String name;
	private int price;
	private int cnt;
	public Product(String name, int price, int cnt) {
		super();
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	
	// 출력하고 총계 리턴 메소드 선언
	public int totShow() {
		System.out.println(name + "\t" + price + "\t" + cnt + "\t" + (price*cnt));
		return price * cnt;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
}
