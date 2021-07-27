package Java.a06_object.access.woodcutterhome;

public class Angel {
	
	WoodCutter wc = new WoodCutter();
	
	public void callData() {
		// private이라서 같은 패키지라도 접근불가능
		//System.out.println(wc.hiddenCloth);
		System.out.println(wc.savingMoney);
		System.out.println(wc.inheritMoney);
		System.out.println(wc.weddingDaugherDate);
	}

}
