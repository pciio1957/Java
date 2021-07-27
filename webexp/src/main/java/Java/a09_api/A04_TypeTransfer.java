package Java.a09_api;

public class A04_TypeTransfer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 응용) 형변환 예제
		// args[] 수박 12000 3 바나나 4000 5
		// 출력1 -> 수박...
		// 출력2 -> 바나나... 
		// 물건명   가격      갯수    계
		// 수박    12000    3      36000
		// 바나나    4000    5      20000
		
		// 응용풀이
		String wmname = args[0];
		int wmprice = Integer.parseInt(args[1]);
		int wmcnt = Integer.parseInt(args[2]);
		String baname = args[3];
		int baprice = Integer.parseInt(args[4]);
		int bacnt = Integer.parseInt(args[5]);
		
		System.out.println("물건명    가격    갯수    계");
		// \t : 탭 간격 설정
		// \n : 줄바꿈 처리
		System.out.println(wmname + "     " + wmprice + "  " + wmcnt
				+ "    "+ (wmprice * wmcnt));
		System.out.println(baname + "    " + baprice + "   " +
				bacnt + "    " + (baprice * bacnt));
		//System.out.println("물건명    가격    갯수    계");
		
		
		
		

	}

}
