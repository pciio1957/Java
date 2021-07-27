package Java.a06_object.access;

import Java.a06_object.access.friendship.WoodCutter;

public class Hunter {

	void callData() {
		
		WoodCutter wc = new WoodCutter();
		
		// 접근 불가능
		//System.out.println(wc.wchiddenDeer);
		//System.out.println(wc.hiddenCloth);
	}
}
