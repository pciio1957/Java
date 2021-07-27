package Java.a09_api;

public class A05_TypeCasting {

/*
 	
 	# 숫자형에서의 데이터 변환 처리
 	1. 숫자형은 종류와 크기에 따라서
 		byte, short, int, long (정수형)
 		float, double (실수형)
 	2. - 해당 데이터는 작은 데이터에서 큰 데이터 타입으로 할당하는 것을
 		promote라고 한다.
 		데이터 유실이 없다 ex) 작은 용기에 있는 물은 큰 용기에 담는 것
 		- 큰 데이터 타입에 담긴 데이터를 작은 데이터타입으로 할당하면 유실이 발생한다.
 		이때 명시적으로 해당 작은 데이터에 맞게 타입을 정해서 할당하는데
 		이것은 casting이라고 한다(데이터유형)
 		ex) 큰 용기에 가득 채운 물을 작은 용기에 담으면 넘쳐서 버리게 된다.
 	3. 자바에서 연산처리시 정수형/정수형 -> 정수형으로 처리된다.
 		이때 소숫점이하까지 처리된 결과를 확인하기 위해 피연산자의 데이터가 
 		1개 이상의 실수어야한다.
 	
*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// promote 예제
		byte num01 = 25;
		int num02 = num01;
		System.out.println(num02);
		double num03 = num02;
		System.out.println(num03);
		
		double num04 = 25.343;
		int num05 = (int) num04;
		System.out.println(num05);
		
		int num06 = 25;
		int num07 = 4;
		// 정수형으로만 계산되어서 값만 나옴
		System.out.println("정수형/정수형 : " + num06/num07);
		// 실수형으로 계산되어서 소수점도 나옴 
		System.out.println("정수형/실수형 : " + num06/(double)num07);
		// promote에 가까움
		
		
		// 응용) 실수형변환, 타입캐스팅 이용
		// args[] 65.72 55.4 80.32 
		// 3명의 몸무게를 입력받아 실수형의 평균 : @@@, 정수형의 평균 : @@@ 나타내기
		
		double per1 = Double.parseDouble(args[0]);
		double per2 = Double.parseDouble(args[1]);
		double per3 = Double.parseDouble(args[2]);
		
		// 여기서 왜 Integer.parseInt 가 안먹지? 
		// .이 문자로 인식해서 숫자형으로 바꿀수가 없나봄 -> 그래서 실수형으로 바꾸고 정수형으로
		int per01 = (int) per1;
		int per02 = (int) per2;
		int per03 = (int) per3;
		
		System.out.println("실수형의 평균 : " + (per1 + per2 + per3)/3);
		System.out.println("정수형의 평균 : " + (per01 + per02 + per03)/3);
	}

}
