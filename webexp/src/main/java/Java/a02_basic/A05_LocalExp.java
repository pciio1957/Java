package Java.a02_basic;

public class A05_LocalExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 응용) Product 클래스를 선언하여 생성자로 물건명, 기능메소드로 가격, 갯수를 입력받아서
		// 총계를 처리한 내용을 계층 구조 변수에 의해 처리하기
		Product pd = new Product("헛개차");
		pd.total(1600, 5);
	}
}

class Product {
	// 필드값, 클래스 최상단에 작성한 전역변수
	private String name;

	// 객체 생성시 name의 필드값 할당
	public Product(String name) {
		super();
		this.name = name;
	}
	
	// 생성 후 기능메소드로 필드값 price, cnt 할당
	public void total(int price, int cnt) {
		System.out.println(" # 구매리스트 # ");
		System.out.println("물건명\t가격\t갯수\t총계");
		System.out.print(name + "\t"); 
		// 매개변수값, 매개변수로 가져온 값은 지역변수
		System.out.print(price + "\t");
		System.out.print(cnt + "\t");
		System.out.println(price*cnt);
	}
}
