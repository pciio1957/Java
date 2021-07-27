package Java.a06_object.access.woodcutterhome;

public class WoodCutter {

		private String hiddenCloth = "날개 옷은 뒷동산";
		String savingMoney = "가족들과 공유하는 재산";
		protected String inheritMoney = "상속재산을 숨긴 곳";
		public String weddingDaugherDate = "막내딸 결혼일(공지)";
		
		public void callData() {
			System.out.println(hiddenCloth);
			System.out.println(savingMoney);
			System.out.println(inheritMoney);
			System.out.println(weddingDaugherDate);
		}
}
