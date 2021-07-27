package Java.z01_vo;

public class Book {
	private String bName;
	private int bPrice;
	private String bWritter;
	

	public Book(String bName, int bPrice, String bWritter) {
		super();
		this.bName = bName;
		this.bPrice = bPrice;
		this.bWritter = bWritter;
	}


	public String getbName() {
		return bName;
	}


	public int getbPrice() {
		return bPrice;
	}


	public String getbWritter() {
		return bWritter;
	}

	

	public void setbName(String bName) {
		this.bName = bName;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
