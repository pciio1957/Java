package Java.z02_project.mvc2;

import java.util.ArrayList;

// XXX에는 기능에 맞는 클래스이름으로 지어주면 됨.
// DB서버에 접속해서 데이터를 가져올 필요성이 있을 때 사용 (무조건 사용하는게 x)
// 
public class XXXDao {

	/*
	
	2. 데이터 조회시 sql문 
	 	select * from product where name like '%' || '물건명입력' || '%'
				and price between 가격의 최소 and 가격의 최대;
			-> sql문을 java 객체로 할당해서 전달 
			
	2차원 데이터인 sql을 어떻게 자바객체로 만드는지?
	1 row(행) -> VO객체에 할당 class Product{}
	행이 모여서 다중의 row(행) -> ArrayList<VO> ArrayList<Product> 객체를 만들어서
	결국 리스트형 데이터를 Dao 객체를 통해서 입력값과 함께 리턴할 객체를 리턴하는
	메소드를 정의해주면 된다.
	
	VO객체에 할당할때는
	class Product {
		private int pid;
		private String pname;
		private int price;
		private int stock; 
		
		// 필요한 생성자, set/get 메소드 생성
		// set, get 메소드 생략
		 * 
		 
	}
	
	*/
	
	public ArrayList<ProductSch> schList(ProductSch sch) {
		ArrayList<ProductSch> list = new ArrayList<ProductSch>();
		System.out.println("# DB 서버에 넘겨줄 검색 데이터 #");
		System.out.println("물건명키워드 : " + sch.getName());
		System.out.println("검색할 가격(최저) : " + sch.getFr_price());
		System.out.println("검색할 가격(최대) : " + sch.getTo_price());
		
		System.out.println("# DB 서버에서 온 데이터 리스트 #");
		list.add(new ProductSch("사과", 3000, 2));
		list.add(new ProductSch("사과2", 4000, 4));
		list.add(new ProductSch("사과3", 5000, 3));
		
		for(ProductSch pro:list) {
			System.out.print(pro.getName() + "\t");
			System.out.print(pro.getFr_price() + "\t");
			System.out.print(pro.getTo_price() + "\t");
		}
		
		return list;
	}
}
