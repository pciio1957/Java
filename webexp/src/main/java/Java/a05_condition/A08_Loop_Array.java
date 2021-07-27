package Java.a05_condition;

import java.util.ArrayList;
import java.util.Collections;

public class A08_Loop_Array {
	
	/*
	 
	#배열과 반복문
	1. 배열의 속성
		1) index: 0부터 시작해서 크기 -1까지 고유번호로 접근할 수 있다.
		2) length: 배열의 크기로 반복문에서 한계치로 설정할 수 있다.
			ArrayList의 경우 .size() 메소드로 크기를 설정하고 있다.
			
			
	#동적배열인 ArrayList를 활용한 데이터처리
	1. ArrayList<타입설정-클래스> 설정
	2. .add(추가될 데이터)
	3. .get(가져올 데이터의 index)
	4. .size() : ArrayList의 크기
	
	
	#클래스로 객체 담기
	1. 클래스를 선언 : 필드, 생성자, 메소드 선언 
	2. ArrayList<클래스> 참조변수명 = new ArrayList<클래스>(); 로 생성
	3. 참조변수명.add(new 생성자());
	
	
		
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			// idx = 0 : 배열의  index 시작값으로 접근할 수 있다.
			// idx < name.length : 배열의 index범위가 크기보다 1 적기 때문에
			// 반복조건으로 설정한다.
			// names[idx] : 각 단위 데이터로 접근할 수 있다.
			String[] names = {"홍길동", "김길동", "신길동"};
			for(int idx=0; idx<names.length;idx++) {
				System.out.println(idx +1+")" + names[idx]);
			}
			
			// 응용) 학생의 국어 점수를 배열로 처리하여(int[] kors) 반복문을 통해 출력하기
			// 총점(누적) 표시
			int[] kor = {80,70,50,60,85};
			int tot = 0;
				
			for(int i = 0; i < kor.length; i++) {
				System.out.println((i+1) + "번 학생의 국어점수 : " + kor[i]);
				tot += kor[i];
				System.out.println("누적점수 : " + tot);
			}
			
			
			
			
			// ArrayList를 이용한 반복문 예제 
			System.out.println("\n# 과일 데이터 확인 #");
			ArrayList<String> flist = new ArrayList<String>();
			flist.add("사과");
			flist.add("바나나");
			flist.add("딸기");
			for(int i=0; i<flist.size(); i++) {
				System.out.println(i+1 + ":" + flist.get(i));
			}
			flist.add("오렌지");
			System.out.println("\n# 추가후 데이터 확인 #");
			for(int i=0; i<flist.size(); i++) {
				System.out.println(i+1+" : " + flist.get(i));
			}
			// (int) (Math.random() * 배열의 크기) : 임의로 대상객체를 선택할 수 있다
			int ranIdx = (int) (Math.random() * flist.size());
			System.out.println("임의 선택 과일 : " + flist.get(ranIdx));
			
			
			// 응용) 가위바위보를 ArrayList<String>에 담아서 출력하고
			// 		임의의 가위바위보를 출력하세요
			ArrayList<String> rpc = new ArrayList<String> ();
			rpc.add("가위");
			rpc.add("바위");
			rpc.add("보");
			
			int ranRpc = (int) (Math.random() * 3);
			System.out.println("\n# 가위바위보 #");
			System.out.println("가위바위보 : " + rpc.get(ranRpc));
			
			
			
			
			// ArrayList<클래스>를 이용한 객체만들기,,?
			String[] shapes = {"♠", "♥", "♣", "◆"}; // 0~3
			String[] numbers = {"A","2", "3", "4", "5", "6", 
					"7", "8", "9","10", "J","Q","K"}; //0~12
			ArrayList<Card> clist = new ArrayList<Card> ();
			int cIdx = 0;
			
			// 이중 반복문으로 카드만들기..
			for(int i=0; i<shapes.length; i++) {
				// System.out.println("모양 index : " + i); 확인용
				for(int j = 0; j<numbers.length; j++) {
					// System.out.println("숫자 index : " + j); 확인용
					// ArrayList<VO>객체의 객체 생성과 함께 추가
					clist.add(new Card(shapes[i], numbers[j]));
					// ArrayList<VO> 객체 안에 index형식으로 객체를 가져옴
					Card d = clist.get(cIdx++); // 바로 위에서 추가한 것을 가져오는것,, 
					System.out.print(d.show() + "\t");
				}
				System.out.println();
			}
			
			
			Collections.shuffle(clist); // 카드를 무작위로 섞기 위함
			System.out.println("\n# 카드를 섞은 후 출력");
			for(int i=0; i<clist.size();i++) {
				System.out.print(clist.get(i).show()+"\t");
				if(i != 0 && i % 7 == 0) {
					System.out.println();
				}
			}
			
			
			// 응용) Fruit 클래스를 통해서 색상과 과일명 배열을 만들고, 생성자와 show() 메소드로 과일명(색상) 리턴처리
			// 		과일 3개를 ArrayList<Fruit>에 담고 출력하기 (6조)
			String[] colors = {"빨간색", "초록색", "노란색"};
			String[] fnames = {"사과", "멜론", "바나나"};
			ArrayList<Fruit> frulist = new ArrayList<Fruit>();
			int fcnt = 0;
			
			System.out.println("\n\n# 과일 리스트 #");
			for(int i = 0; i<colors.length; i++) {
				for(int j=0; j<fnames.length; j++) {
					frulist.add(new Fruit(colors[i], fnames[j]));
					Fruit fit = frulist.get(fcnt++);
					System.out.print(fit.show()+"\t");
				}
				System.out.println();
			}
			
			int ranFidx = (int) (Math.random() * (colors.length * fnames.length));
			Fruit ft = frulist.get(ranFidx);
			System.out.println("\n# 랜덤 과일 고르기 #");
			System.out.println(ft.show());
			
		}
	}


