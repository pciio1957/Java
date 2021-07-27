package Java.a01_exp.month05;

public class A03_0506 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		1. 클래스와 객체와의 관계를 Movie 클래스 선언과 참조변수 m01, m02를 통해서 
			메모리와 함께 설명하기
			
			// 클래스 
			class Movie {
				String name = "홍길동";
			}
			-> 클래스는 코드로 선언되어 있는 것을 말한다. 
			
			// 객체
			Movie m01 = new Movie(); 
			Movie m02 = new Movie();
			-> class에 선언된 코드가 메모리에 로딩되어 수행되는 것을 객체라고 한다.
			
			class와 객체는 밀접한 연관관계를 가지고 있으며 
			class만으로는 프로그램 처리를 하지 못하므로 객체를 만들어야 한다.
			
			
		2. 클래스의 구성요소와 각 구성 요소의 특징(생성자/ 메소드의 차이)에 대해 기술
		
			// 클래스
			public class Movie {
			
			// 구성요소1 : 필드
			// 클래스의 특정 속성을 나타내는 역할
			public int i; 
			
			// 구성요소2 : 생성자 
			// 클래스와 동일한 명칭을 가진 기능함수로 일반적으로 속성을 초기화함
			public Movie() {
			  생성자의 경우 클래스를 이용한 객체를 생성할 때 사용할 값들을 초기화하고 설정.
			}
			
			// 구성요소3 : 메소드
			// 클래스의 기능을 처리하는 역할
			public void see() {
			  메소드의 경우 클래스에서 사용하는 프로세스로 클래스에서 일어날 일을 작성한 것... 
			} 
			}
			
			1) 생성자는 클래스와 같은 이름을 가지며, 메소드는 다른 이름을 가진다.
			2) 생성자는 데이터유형을 적지않고, 메소드는 데이터유형을 가지며 리턴값을 가지기도 한다.

		
		3. 클래스에 this를 사용하는 경우에 대해 기술
			클래스의 생성자를 작성할 때 매개변수가 있는 경우 
			해당 클래스가 가지고 있는 변수에 매개변수의 값을 할당하기 위해서 
			즉, 해당 클래스의 변수라는 것을 선언하기 위함
		
		4. Calculator 클래스를 선언하고, 필드값(두개의 숫자)를 할당해 합산의 값 출력
			class Calculator {
				int aa; 
				int bb; 
				
				void plus() {
					System.out.println("두 숫자의 합은" + (aa+bb));
				}
			}
			
			-- main() 클래스
			
			Calculator cal1 = new Calculator();
			cal1.aa = 5;
			cal1.bb = 10;
			cal1.plus();
			
		5. Calculator 클래스를 선언하고, 생성자로 필드값을 할당하여 곱셈의 값 출력
			class Calculator {
				public int aa; 
				public int bb; 
				
				public Calculator (int a, int b) {
					this.aa = a;
					this.bb = b;
				}
				
				void multi() {
					System.out.println("두 숫자의 곱셈은" + (aa*bb));
				}
			}
			
			-- main() 클래스
			
			Calculator cal2 = new Calculator(7, 8);
			cal2.multi();
			
		6. Calculator 클래스를 선언하고 생성자로 필드값을 할당하여 
			메소드 plus(), minus(), divide(), multi()를 통해 
			덧셈, 뺄셈, 곱셈, 나눗셈을 출력하여 처리하기
				class Calculator {
					public int zz; 
					public int xx; 
					
					public Calculator(int z, int x) {
						this.zz = z;
						this.xx = x;
					}
					
					public void plus() {
						System.out.println("두 숫자의 합은 " + (zz + xx);
					}
					
					public void minus() {
						System.out.println("두 숫자의 뺄셈은 " + (zz - xx);
					}
					
					public void divide() {
						System.out.println("두 숫자의 나눗셈은 " + (zz / xx);
					}
					
					public void multi() {
						System.out.println("두 숫자의 곱셈은 " + (zz * xx);
					}
				}
				
						
			-- main() 클래스
			
			
			Calculator cal3 = new Calculator(20,10);
			cal3.plus()
			cal3.minus()
			cal3.divide()
			cal3.multi()
			
		7. 자바의 접근제어자 범위에 대해 기술하기
			- private
				클래스 내부에서만 사용가능
			- (defalut)
				같은 클래스내에서만 사용가능
			- protected
				상속 관계에서만 사용 가능
			- public 
				모든 관계에서 사용 가능
		
		8. 추상 클래스와 일반 클래스의 차이점 기술하기 
			1) 추상클래스는 일반 클래스와 달리 단독으로 객체 생성이 불가능
			2) Body({})가 없는 추상메소드가 하나라도 있으면 그 클래스는
				추상클래스가 된다.
			3) 일반 클래스는 상위 클래스로 추상 클래스를 상속받을 수 있고,
				상속받은 경우 추상메소드를 반드시 오버라이딩해야한다.
			4) 추상 클래스는 단독으로 객체 생성이 불가능하기 때문에 
				상위 클래스를 참조만 해서 하위 클래스로 생성해야한다.
		  		
		9. Duck 추상클래스(quack() 꽥!!, flying()-추상메소드)에
			상속받은 RubberDuck(고무오리), Mallard(청둥오리)를 선언하기
			
			abstract class Duck {
				public String isDuck = "오리";
			
				void quack() {
					System.out.println("오리 울음소리는 꽥!");
				}
				
				abstract void flying();
			}
			
			class RubberDuck extends Duck {
			
				void flying() {
					System.out.println("고무오리는 날지못한다");
				}
			}
			
			class Mallard extends Duck {
			
				void flying() {
					System.out.println("청둥오리는 날수있다");
				}
			}
			
			
			Duck d1 = new RubberDuck();
			d1. flying();
			
			Duck d2 = new Mallard();
			d2.flying();
*/		
		
		
		
		
	}

}


