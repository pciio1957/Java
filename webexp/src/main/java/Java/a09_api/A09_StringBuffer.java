package Java.a09_api;

public class A09_StringBuffer {
	
	/*
	
	#String Buffer
	1. 문자열은 추가적으로 +=로 처리할 시, 해당 문자열의 같은 
		메모리에서 데이터를 추가하는 것이 아니라
		계속 새로운 heap영역의 메모리를 만들어가기 때문에 
		메모의 비효율과 부하를 발생시킨다
	
	2. 문자열에 대한 하나의 메모리에 효과적인 추가 처리를 위해서
		사용되는 객체가 StringBuffer이다
		1) 추가하는 기능메소드 .append()를 통해서 동일한
			heap메모리를 사용하여 메모리 관리를 효율적으로 처리한다.
		2) 주요기능메소드
			.append("마지막에 추가할 문자열")
			.insert(특정위치 index, "추가할 문자열")
			.delete(시작index, 마지막index) : 해당 위치에 있는 데이터를 삭제 처리
			.replace(위치index, 위치index, "대체할 문자열")
			
			
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "홍길동";
		// 기존 name의 heap메모리에 추가적인 데이터를 처리하는 것이 아니라
		name += ", 김길동";
		// 새로운 메모리가 만들어 진다.
		
		
		StringBuffer sbf = new StringBuffer("안녕하세요!");
		sbf.append("좋은 하루입니다.!!");
		sbf.append("반가워요! ");
		sbf.insert(6,  "문자열 삽입! insert");
		sbf.delete(13,19);
		sbf.replace(0, 6, "^^(변경처리)");	
		System.out.println(sbf.toString());
		
		
		
		// 응용) 초기에 # 과일 목록 : 팝니다 #
		// 문자열을 만들고 
		// 1) 사과, 바나나, 딸기 추가
		// 2) 바나나 위치 index 확인해서 삭제
		// 3) 딸기 index 확인해서 오렌지 변경
		// 최종 결과 출력
		
		StringBuffer sb2 = new StringBuffer("# 과일 목록 : 팝니다 #\n");
		
		// 추가
		sb2.append("사과");
		sb2.append("바나나");
		sb2.append("딸기");
		//sb2.append("사과, 바나나, 딸기");
		System.out.println("추가 -> \n" + sb2);
		//System.out.println("추가 -> \n" + sb2.toString());
		
		// 삭제
		sb2.delete(18, 21); 
		System.out.println("삭제 -> \n" + sb2);
		//System.out.println(sb2.length()); 확인용 ㅎ
		
		// 수정
		sb2.replace(18, 20, "오렌지");
		// sb2.replace(17, sb2.length(), "오렌지");
		System.out.println("수정 -> \n" + sb2);
	}

}
