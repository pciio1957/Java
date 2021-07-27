package Java.a05_condition;

public class Fruit {
	private String color;
	private String fname;
	public Fruit(String color, String fname) {
		super();
		this.color = color;
		this.fname = fname;
	}
	
	// show() 메소드로 color와 fname을 합쳐줌
	public String show() {
		//return color+fname;
		return fname + "(" + color +")";
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	
	
}
