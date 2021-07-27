package Java.a05_condition;

public class Card {
	private String number;
	private String shape;
	
	public Card(String number, String shape) {
		super();
		this.number = number;
		this.shape = shape;
	}
	
	public String show() {
		// System.out.println(shape + number + "\t"); 리턴값으로 바꿈
		return shape+number; 
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	
	
}
