package Java.z02_project.mvc2;

public class XXXMain {

	// 화면에서 처리하는 부분을 main()을 통해서 test한다.
	// Scanner를 통해서 입력받거나 임의로 데이터를 넣어서 작동시키는 부분
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TEST하는거니까 Scanner로 하던지 그냥 생성자로 데이터 넣던지 마음대로,,, 
		// 검색을 눌렀을때 처리할 부분 처리
		ProductSch sch = new ProductSch("과자", 2000, 10);
		
		// controller 호출
		XXXController controller = new XXXController();
		System.out.println("# 호출된 화면 #");
		
		System.out.println(controller.schList2(sch, new Model()));
	}
}
