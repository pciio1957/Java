package Java.z02_project.mvc2;

// 모델 데이터가 있다는 것만 표시. 
public class Model {
	public void addAttribute(String key, Object ob) {
		System.out.println("# 모델 데이터 처리(화면에 전달할 데이터)#");
		System.out.println("key: " + key);
		System.out.println("객체: " + ob);
	}
}
