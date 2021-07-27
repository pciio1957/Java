package Java.a06_object.access.son1home;

import Java.a06_object.access.woodcutterhome.WoodCutter;

public class son1 extends WoodCutter {
	
WoodCutter wc = new WoodCutter();
	
	public void callData() {
		// 상속관계에 있는 외부 패키지에 있는 클래스
		// 1. private은 접근불가
		//System.out.println(wc.hiddenCloth);
		// 2. defalut 즉 같은 패키지에 있어야지 상속가능
		//System.out.println(wc.savingMoney);
		// 3. protected 외부 패키지이지만, 상속관계에 있으면 접근가능
		//System.out.println(wc.inheritMoney); // extends했는데 왜 안되농
		// 4. 어떤 패키지라도 상속가능
		System.out.println(wc.weddingDaugherDate);
	}

}
