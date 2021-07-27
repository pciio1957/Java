package Java.a09_api;

public class A03_TypeTransfer {
	
	/*
	
	# 데이터의 변환
	1. 숫자형 문자열은 연산이 불가능하다.
	 	이때 필요로 하는 것이 숫자형으로 변환히 필요하다
	2. 정수/정수일때 자바에서는 정수형의 몫만 가져올 수 있다.
		소숫점이하의 숫자로 가져오기 위해서는 형 변환이 필요하다
	3. 숫자형 데이터를 문자열로 변환하여 처리
		1) 각 wrapper 클래스 (기본데이터유형의 객체화한 클래스)
			정수형 Integer.toString(25) => "25"
			실수형 Double.toString(27.35) => "27.35"
		2) 간략하게 "" + 25 => "25"
				 "" + 27.25 => "27.25" 
				 문자를 추가해서 변환,, 
		
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String numStr = "25";
		int num01 = 25;
		// 문자열은 기본적으로 + 기호에 의해서 연결(concat) 처리한다
		System.out.println(numStr + 30); // 데이터가 연결됨
		System.out.println(num01 + 30); // 더하기 
		
		// run 속성에서 arguments에 사과 3000 2 작성
		String fname = args[0];
		String fprice = args[1];
		String fcnt = args[2];
		
		System.out.println("물건명 : " + fname);
		System.out.println("가격 : " + fprice);
		System.out.println("갯수 : " + fcnt);
		//System.out.println("총계 : " + (fprice*fcnt)); //에러발생
		// 숫자형태의 데이터가 아니기때문에 연산을 할 수 없다.
		
		// 숫자형 문자열에서 -> 숫자형으로
		// 1. 정수형 : Integer.parseInt("정수형문자열");
		// 2. 실수형 : Double.parseDouble("실수형문자열");
		// 위의 문제였던 정수형 형변환
		int price = Integer.parseInt(fprice);
		int cnt = Integer.parseInt(fcnt);
		System.out.println("총계 : " + price * cnt);
		
		// Double 실수형 형변환
		double dblNum = Double.parseDouble("180.7");
		System.out.println(dblNum + 25.25);
		
		
	}

}
