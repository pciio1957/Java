package Java.z02_project.mvc2;

public class XXXController {
	// 화면단에서 오는 데이터를 받고
	// 화면단에 전달할 데이터를 설정하는 기능
	// 예를 들어 게시판 검색 처리라고 할 떄
	// 물건명 [] 가격 [] ~ [] 이렇게 지정되어있을 때 옆에 [검색] 버튼?이 있는거
	// 물건명  가격  갯수  기타가 리스트로 나올 것임
	// @@@   @@   @@   @@
	// 입력데이터 : 물건명, 가격 - controller의 메소드의 매개변수로 설정한다.
	// 출력데이터 : 물건리스트 - 출력할 Model 객체에 할당 처리 (key, value) 형식으로 할당
	// 					마지막 매개변수로 선언해줘야함
	
	
	/*
	
	1. 개발패턴의 3단계
		1) 기본단계
			Controller --> service --> Dao (DB에 연결 필요O)
			Controller --> service  (Db에 연결 필요X)
				 		<--		   <--
	
		2) 주의사항
			근데 중간에 비우면 안됨 단계가 있음
			Controller --> dao (X) : 처리하는 단계가 정해져있기 때문에 이렇게는 안됨
			   		   <--
			   		   
		3) 화면만 호출시
			Controller 호출
		
		4) DB처리가 필요없고 입력을 통해서 반복이나 조건 처리 
			Controller --> Service 
					  <--
	
	
	 2. 데이터 조회시 sql문 
	 	select * from product where name like '%' || '물건명입력' || '%'
				and price between 가격의 최소 and 가격의 최대;
	*/
	
	
	private XXXService service = new XXXService();
	
	
	// 모델 데이터를 이용해야하는데 없으니까 임의로 설정해서 사용하는 것임. 
	public String schList(String pname, int price, Model d) {
		// 화면단에 대한 호출로 보통 jsp를 호출함 
		return "경로/@@@.jsp";
	}
	
	// 연관관계를 꼭 설정하라고 하심
	public String schList2(ProductSch s, Model d) {
		// 화면단에 대한 호출로 보통 jsp를 호출함 
		System.out.println("# 컨트롤에서 받은 데이터 #");
		System.out.println(s.getName());
		
		// view단에 넘겨줄 데이터를 key, object로 보냄
		d.addAttribute("plist", service.schList(s));
		
		return "경로/@@@.jsp";
	}

}
