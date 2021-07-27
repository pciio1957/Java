package Java.a06_object.vo;

public class Product200 {
	
	private String name;
	private int price;
	private int cnt;
	private int tot;
	
	public Product200(String name, int price, int cnt) {
		super();
		this.name = name;
		this.price = price;
		this.cnt = cnt;
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

	@Override
	public String toString() {
		return "Product200 [name=" + name + ", price=" + price + ", cnt=" + cnt + ", tot=" + tot + "]";
	}

}
