package Java.a06_object.vo;

public class Product {

	public String name;
	public int price;
	public int cnt;
	
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

	public Product() {
		// 생성자에 매개변수가 있을 경우에 해당하는 것 
		// name = a;
		// System.out.println(name);
		System.out.println("Product 생성자 호출");
	}
	
	public Product(String name, int price, int cnt) {
		this.name = name;
		this.price = price;
		this.cnt = cnt;	
	}
	
	public String gg() {
		System.out.println(name + "호출");
		return name;
	}
	
	public void buy() {
		System.out.println("구매한 물품 : " + name + " 단가 : "
				+ price + "원 구매갯수 : " + cnt + "개 총 비용 : "
				+ (price * cnt) + "원 입니다.");
	}
	
}
