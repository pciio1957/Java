package Java.a09_api;

import java.util.ArrayList;

public class A14_WrapperExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 응용1) args 래퍼클래스 처리 응용하기
		//		args[]에   홍길동 25 75.7   값을 입력하고
		// 		위의 값을 받아서 Wrapper 클래스에 해당하는 데이터를 할당해
		//		이름 : @@  형식으로 이름, 나이, 몸무게 출력하기 (5조, 6조 못푼사람)
		
		// String도 Wrapper클래스에 해당하는지..?
		String val1 = new String(args[0]);
		Integer val2 = new Integer(args[1]);
		Double val3 = new Double(args[2]);
		
		System.out.println("\n# 응용1 #");
		System.out.println(" 이름 : " + val1);
		System.out.println(" 나이 : " + val2);
		System.out.println(" 몸무게 : " + val3);

		
		// 응용2) ArrayList로 autoboxing 처리 후 데이터 할당하기
		// ArrayList<String>, ArrayList<Integer>, ArrayList<Double> 이용
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Double> avgs = new ArrayList<Double>();
		
		names.add("홍길동");
		names.add("이길동");
		names.add("김길동");
		
		nums.add(21);
		nums.add(22);
		nums.add(23);
		
		avgs.add(76.8);
		avgs.add(82.1);
		avgs.add(43.6);
		
		// 여기서 for문으로 데이터를 돌리는 건 알겠는데 
		//		이름하나 번호하나 평균하나 못하려나
		System.out.println("\n# 응용2 #");
		for(String s:names) {
			System.out.println("이름 : " + s);
		}
		
		for(Integer i:nums) {
			System.out.println("번호 : " + i);
		}
		
		for(Double d:avgs) {
			System.out.println("평균 : " + d);
		}
		
		
		System.out.println("\n# 응용2 풀이 #");
		System.out.println("번호\t이름\t평균");
		for(int idx = 0; idx < 3; idx++) {
				System.out.print(names.get(idx) + "\t");
				System.out.print(nums.get(idx) + "\t");
				System.out.println(avgs.get(idx));
		}
		
				
	}

}
