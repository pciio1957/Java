package Java.a01_exp.month06;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class a19_0609 {
	
	/*
	
	?문제
	1. 제너릭 타입에 대한 개념과 장점을 설명하기
		1) 컴파일 단계에서 잘못된 타입이 사용될 수 있는 문제를 제거할 수 있도록 한다.
		2) 컴파일시 강한 타입의 체크가 가능하고, 이로 인해 타입 체크를 강하게 하므로 에러를 사전에 방지한다.
		3) 실행시에 타입 에러가 나는 것을 방지한다
		4) 타입변환을 제거할 수 있다.
		
		#
		1. 사전에 사용할 객체에 대한 타입을 외부에서 지정하여 다른 타입을 할당하는 것을 
			방지하여 프로그램의 데이터타입에 대한 확정하는 것을 말한다.
			ex) ArrayList<Person> plist; -> Person 한 타입만 넣을 수 있다. 
				Vehicle<Car> v1 = new Vehicle<Car>(); -> Car 객체만 할당 가능
				class Vehicle<T> { -> T에 어떤 타입을 넣어도 된다,,, 
					private T t;
					;
				}
	
	2. class 클래스<타입>의 선언 의미를 기술하기
		1) 클래스를 선언할 때 <타입> 파라미터를 사용하는 것을 generic이라고 한다
			어떤 type을 속성으로 사용할 것인지 선언하는 것을 의미하는데 T로 설정하여 작성한다.
			그러면 컴파일시 타입 파라미터가 구체적인 클래스로 변경처리되면서 해당 타입에 맞게 변환되어 사용할 수 있다 
		
		#
		1) 가변적인 속성을 generic으로 <T>형식을 선언하여 여러가지 데이터 유형의 속성을
			사용할 수 있게 처리할 때 활용된다. 
		2) 컴파일시 파라미터가 구체적인 클래스로 변경처리되고 실행할 타입을 구체화하여 사용할 수 있게 한다.
		3) 두가지 이상의 속성을 가변적으로 활용할 수 있는데,
			호출시 클래스명<사용할 타입1, 사용할 타입2>을 참조하여 작성한다. 
		
	3. generic 타입으로 WorkingGroup<T>로 설정하고,
		실제 속성으로 fireMan, PoliceMan 등으로 할당하여 실행하기
		
	4. 스트림은 어떤 역할을 하는지 기술하기
		
		#
		1) 프로그램을 기준으로 특정한 입력도구나 프로그램을 통해서 해당 데이터를 
			입력받게 해주는 객체가 입력스트림이다. 
		   프로그램을 기준으로 데이터를 대상 출력 도구나 프로그램에 
		    출력하게 해주는 객체가 출력스트림이다. 
	
	
	5. 바이트기반 스트림과 문자기반 스트림의 차이점을 기술하기
	6. InputStream과 byte[]를 이용해서 사원번호와 이름을 등록하기
	7. 2byte이상 문자를 입력받는 스트림객체 InputStreamReader와 char[]를
		이용하여 학생이름과 국어성적을 등록 및 출력하기
	
	
	
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 3.
		WorkingGroup<FireMan> fire = new WorkingGroup<FireMan>("소방관");
		fire.goWork();
		fire.working();
		fire.goHome();
		
		WorkingGroup<PoliceMan> plc = new WorkingGroup<PoliceMan>("경찰관");
		plc.goWork();
		plc.working();
		plc.goHome();
		
		
		// #3.
		WorkingGroup2<FireMan> wg1 = new WorkingGroup2<FireMan>();
		wg1.setWorker(new FireMan());
		FireMan fm = wg1.getWorker();
		
		WorkingGroup2<PoliceMan> wg2 = new WorkingGroup2<PoliceMan>();
		wg2.setWorker(new PoliceMan());
		PoliceMan pm = wg2.getWorker();
		
		
		
		// 6. 
		InputStream is = System.in;
		// 1. 입력받을 사원번호와 이름의 배열 선언
		byte[] empnoArr = new byte[10]; 
		byte[] enameArr = new byte[10]; 
		
		
		try {
			System.out.print("사원번호를 입력하세요 : ");
			is.read(empnoArr);
			
			System.out.print("이름을 입력하세요 : ");
			is.read(enameArr);
			
			System.out.println("\n# 1입력데이터 #");
			System.out.print("사원번호 : ");
			for(byte b:empnoArr) {
				System.out.print((char) b);
			}
			
			System.out.print("이름 : ");
			for(byte b:enameArr) {
				System.out.print((char) b); // byte를 문자1byte로 형변환
			}
			
			// 공백제거
			String ar1 = new String(empnoArr).trim();
			String ar2 = new String(enameArr).trim();
			
			System.out.println("\n# 2입력데이터 #");
			System.out.println("사원번호 : " + ar1);
			System.out.println("이름 : " + ar2);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 여기서 close하니까 밑에서 실행이 안되서 주석처리함
//		} finally { // finally에는 자원해제 처리
//			try {
//				is.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
		
		// 7.
		
		char[] name = new char[10];
		char[] kor = new char[10];
		
		// 한글을 입력할 수 있도록 도와주는 Reader 객체
		InputStreamReader ir = new InputStreamReader(System.in);
		try {
			
			System.out.print("이름을 입력하세요 : ");
			ir.read(name);
			String names = new String(name).trim();
			
			System.out.print("국어 성적을 입력하세요 : ");
			ir.read(kor);
			String kors = new String(kor).trim();
			
			System.out.println("# 입력데이터 #");
			System.out.println(" 이름 : " + names);
			System.out.println(" 국어성적 :" + kors);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ir.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}

class WorkingGroup<T> {
	private Object obj;

	public WorkingGroup(Object obj) {
		super();
		this.obj = obj;
	}

	public void working() {
		System.out.println(obj + " 일한다");
	}
	
	public void goWork() {
		System.out.println(obj + " 출근한다");
	}
	
	public void goHome() {
		System.out.println(obj + " 퇴근한다");
	}
}

class WorkingGroup2<T> {
	private T worker;

	public T getWorker() {
		return worker;
	}

	public void setWorker(T worker) {
		this.worker = worker;
	}
}

class FireMan {
	
}

class PoliceMan {
	
}