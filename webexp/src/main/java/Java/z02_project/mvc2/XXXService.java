package Java.z02_project.mvc2;

import java.util.ArrayList;

public class XXXService {
	XXXDao dao = new XXXDao();
	
	// 필터링하거나 데이터베이스 내용 필터링?,, 
	public ArrayList<ProductSch> schList(ProductSch sch) {
		System.out.println("# 서비스단 처리 #");
		System.out.println("DAO에 전송받은 데이터 : " + sch.getName());
		System.out.println("DAO에 받은 데이터 크기 : " + dao.schList(sch).size());
		
		return dao.schList(sch);
	}
}
