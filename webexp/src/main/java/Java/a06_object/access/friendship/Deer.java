package Java.a06_object.access.friendship;

public class Deer {
	void callDate() {
		WoodCutter wc = new WoodCutter();
		// 같은 패키지 클래스에서는 접근이 가능
		// 접근 제어자가 default일때는 접근 불가능
		System.out.println(wc.hiddenDeer);
		
		// 접근제어자가 private인 것은 외부에서 접근하지 못함
		//System.out.println(wc.hiddenCloth);
	}

}
