package Java.z01_vo;

public class Product {
	private String pno;
	private String name;
	private int price;
	private int cnt;
	
	private int fr_price;
	private int to_price;
	
	public Product() {
		super();
	}
	
	// 이름, 가격 조회용
	public Product(String name, int fr_price, int to_price) {
		super();
		this.name = name;
		this.fr_price = fr_price;
		this.to_price = to_price;
	}
	
	// 수정용
	public Product(int price, int cnt, String pno) {
		super();
		this.pno = pno;
		this.price = price;
		this.cnt = cnt;
	}

	// 삽입용
	public Product(String pno, String name, int price, int cnt) {
		super();
		this.pno = pno;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
		
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
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


	public String getPno() {
		return pno;
	}


	public void setPno(String pno) {
		this.pno = pno;
	}


	public int getFr_price() {
		return fr_price;
	}


	public void setFr_price(int fr_price) {
		this.fr_price = fr_price;
	}


	public int getTo_price() {
		return to_price;
	}


	public void setTo_price(int to_price) {
		this.to_price = to_price;
	}
}
