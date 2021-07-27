package Java.a01_exp.month05;

import java.util.ArrayList;

public class A13_0524ans {
	// 선생님풀이
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		/*
		1. 클래스의 구성요소
		class 클래스명 {
			private int num01; // 필드
			클래스명(int num01) { // 생성자로 주로 필드를 초기화함
				this.num01 = num01;
				// 객체가 생성될때 바로 초기화가 필요할 필드인지?
				// 메소드를 통해서 변경하는 부분인지 초기화해야함
				// cf) 구매하는 경우에는 cnt를 기능메소드로 처리 
				//	입고하는 경우 물건명과 입고의 갯수를 같이 담아서 처리해야한다.
		}
		// 기능메소드 : 어떤 입력값이 나오는지, 처리해야하는 내용을 잘 고려해야함
		// 		주 처리내용 : 저장, 누적, 조건/반복처리
		// 		리턴할 데이터 여부 판단도 잘 해야함 이클래스를 통해서 외부에서 데이터처리시 리턴값 필요
		public void buy(int cnt) {
			this.cnt = cnt;
		}
				
		 */
		
		
		// 2번문제 
		Record2 r1 = new Record2();
		Record2 r2 = new Record2();
		Record2 r3 = new Record2();
		
		int tot = 0;
		tot += r1.write("5/1", "이월금", true, 300000);
		tot += r2.write("5/25", "차비", false, 5000);
		tot += r3.write("5/25", "식비", false, 10000);
		System.out.println("총 잔액 : " + tot);
		
		System.out.println("# 하나의 객체로 기능 메소드 처리 #");
		Record2 r4 = new Record2();
		int tot2 = 0;
		// 기능메소드를 처리한 경우 각각의 데이터를 변경할 수 있기 때문에
		//	하나의 객체로 사용이 가능하다.
		tot2 += r4.write("5/1", "이월금", true, 300000);
		tot2 += r4.write("5/25", "차비", false, 5000);
		tot2 += r4.write("5/25", "식비", false, 10000);
		System.out.println("총 잔액 : " + tot2);

		
		// 3번문제
		Museum2 m01 = new Museum2("유럽 고대 명화전");
		m01.showVisitor();
		m01.setVis(new Visitor2("홍길동", 25));
		m01.showVisitor();
		
		
		// 4번문제
		BookStore2 bs2 = new BookStore2("교보문고");
		bs2.showBuyList();
		bs2.buyBook(new Book2("자바", 18000, "김길동", 2));
		bs2.buyBook(new Book2("복습", 5000, "홍길동", 5));
		bs2.buyBook(new Book2("신호처리", 11000, "이길동", 3));
		bs2.showBuyList();
		
		
		// 5번문제
		// 1단계 ) computer 하위에 선언 
		// 2단계 ) ArrayList에 할당해서 처리
		// 3단계 ) 다형성 설정 추상클래스로 선언해서 처리, ArrayList<PartComp>
		Computer2 c1 = new Computer2("맥PC");
		c1.setCpu(new Cpu2("MS", "3.6Hz"));
		c1.setRam(new Ram2("삼성", "16GB"));
		c1.setHdd(new Hdd2("삼성", "512GB"));
		
		// 다형성 처리한 Computer22
		System.out.println("\n# 다형성 처리한 부품목록 #\n");
		Computer22 c22 = new Computer22("삼성PC");
		c22.ShowPartList();
		c22.addPartComp(new Cpu22("MS", "3.6Hz"));
		c22.addPartComp(new Ram22("애플", "16GB"));
		c22.ShowPartList();
		
	}

}

// 2번 record
class Record2 {
	private String date;
	private String content;
	private boolean isIncome;
	private int money;
	
	public int write(String date, String content, boolean inIncome, int money) {
		this.date = date;
		this.content = content;
		this.isIncome = isIncome;
		this.money = money;
		System.out.println("\n# 입출금 내역 등록 #");
		System.out.println("날짜 : " + date);
		System.out.println("내용 : " + content);
		System.out.println("구분 : " + (isIncome?"수입":"지출"));
		System.out.println("금액 : " + money);
		
		return isIncome?money:-money;
	}
}

class Visitor2 {
	private String name;
	private int age;
	
	public Visitor2() {
		super();
	}

	public Visitor2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}	
	
	
}

class Museum2 {
	private String name;
	private Visitor2 vis;
	
	public Museum2() {
		super();
	}

	public Museum2(String name) {
		super();
		this.name = name;
	}

	public void setVis(Visitor2 vis) {
		this.vis = vis;
		System.out.print(name + "박물관에 ");
		System.out.print(vis.getName() + "이 방문했씁니다.\n");	
	}
	
	public void showVisitor() {
		System.out.println(name + "박물관에 방문한 방문객 정보");
		if(vis != null) {
			System.out.println("이름 : " + vis.getName());
			System.out.println("나이 : " + vis.getAge());
		} else {
			System.out.println("방문객이 없습니다!");
		}
	}
}


// 4번문제
class Book2 {
	private String title;
	private int price;
	private String writer;
	private int cnt;
	
	public Book2(String title, int price, String writer, int cnt) {
		super();
		this.title = title;
		this.price = price;
		this.writer = writer;
		this.cnt = cnt;
	}
	
	public int showBuyInfo(int idx) {
		System.out.print((idx+1) + "\t");
		System.out.print(title + "\t");
		System.out.print(writer + "\t");
		System.out.print(price + "\t");
		System.out.print(cnt + "\t");
		System.out.print((price * cnt) + "\n");
		
		return price*cnt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}

class BookStore2 {
	private String name;
	private ArrayList<Book2> blist;
	
	public BookStore2(String name) {
		super();
		this.name = name;
		// 동적 물건 처리 객체 초기화, 생성해서 할당한거라 null인지 판별불가능
		blist = new ArrayList<Book2>();
	}

	// 구매할 물건을 전체 저장
	public void setBlist(ArrayList<Book2> blist) {
		this.blist = blist;
	}
	
	// 하나하나 구매 목록을 추가 처리 
	public void buyBook(Book2 b) {
		blist.add(b);
	}
	
	public void showBuyList() {
		System.out.println(name + "서점에서 구매한 도서리스트");
		// 객체가 생성되고 할당되지 않으면 사이즈는 0이라서 목록이 없는것
		// if(객체 != null) 로 객체가 할당되었는지 확인
		// 생성자에서 동적인 배열 객체인 ArrayList를 생성했기때문에
		// 메모리 확인보다는 크기를 기준으로 처리해야한다.
		if(blist.size() == 0) {
			System.out.println("구매 목록이 없습니다");
		} else {
			// 인덱스 번호를 출력하기때문에 for1번방법 사용
			System.out.println("번호\t도서명\t저자\t가격\t권수\t총계");
			int tot = 0;
			for(int idx = 0;idx<blist.size(); idx++) {
				Book2 b2 = blist.get(idx);
				tot += b2.showBuyInfo(idx);
			}
			System.out.println("총 구매 비용 : " + tot);
		}
	}
}

class Cpu2{
	private String company;
	private String spec;
	
	public Cpu2(String company, String spec) {
		super();
		this.company = company;
		this.spec = spec;
	}
	
	public void showInfo() {
		System.out.println("# CPU 사양 #");
		System.out.print(company + "\t");
		System.out.print(spec + "\n");
	}
}

class Ram2{
	private String company;
	private String spec;
	
	public Ram2(String company, String spec) {
		super();
		this.company = company;
		this.spec = spec;
	}
	
	public void showInfo() {
		System.out.println("# RAM 사양 #");
		System.out.print(company + "\t");
		System.out.print(spec + "\n");
	}
}

class Hdd2 {
	private String company;
	private String spec;
	
	public Hdd2(String company, String spec) {
		super();
		this.company = company;
		this.spec = spec;
	}
	
	public void showInfo() {
		System.out.println("# HDD 사양 #");
		System.out.print(company + "\t");
		System.out.print(spec + "\n");
	}
}

class Computer2 {
	private String company;
	private Cpu2 cpu;
	private Ram2 ram;
	private Hdd2 hdd;
	
	public Computer2(String company) {
		super();
		this.company = company;
	}
	
	public void showInfo() {
		System.out.println("# 컴퓨터 #");
		System.out.println("제조사 : " + company);
		
		if(cpu != null) {
			cpu.showInfo();
		} else {
			System.out.println("CPU 장착이 되지않았습니다");
		}
		
		if(ram != null) {
			ram.showInfo();
		} else {
			System.out.println("RAM 장착이 되지않았습니다");
		}
		
		if(hdd != null) {
			hdd.showInfo();
		} else {
			System.out.println("HDD 장착이 되지않았습니다");
		}
	}

	// 기능 메소드를 통해 부품 장착
	public void setCpu(Cpu2 cpu) {
		this.cpu = cpu;
	}

	public void setRam(Ram2 ram) {
		this.ram = ram;
	}

	public void setHdd(Hdd2 hdd) {
		this.hdd = hdd;
	}	
}

//5번문제 다형성 설정
abstract class PartComp {
	private String kind;
	private String company;
	private String spec;
	
	public PartComp(String kind, String company, String spec) {
		super();
		this.kind = kind;
		this.company = company;
		this.spec = spec;
	}

	public void showCom() {		
		System.out.print(kind + "\t");
		System.out.print(company + "\t");
		System.out.print(spec + "\n");
	}
	
	abstract void show2();

	public String getKind() {
		return kind;
	}
}

class Cpu22 extends PartComp {
	
	public Cpu22(String company, String spec) {
		super("CPU", company, spec);
	}

	@Override
	void show2() { // 하위 객체마다 추가적으로 처리할 내용
		// TODO Auto-generated method stub
	
		//System.out.println("# CPU 정보 #");
		// 공통 정보를 사용할 수 있게 처리
		showCom();
	}
}

class Ram22 extends PartComp {
	
	public Ram22(String company, String spec) {
		super("RAM", company, spec);
		// TODO Auto-generated constructor stub
	}

	@Override
	void show2() {
		// TODO Auto-generated method stub
		//System.out.println("# RAM 부품 정보 #");
		showCom();
	}
	
}

class Hdd22 extends PartComp {
	
	public Hdd22(String company, String spec) {
		super("Hdd", company, spec);
		// TODO Auto-generated constructor stub
	}

	@Override
	void show2() {
		// TODO Auto-generated method stub
		//System.out.println("# HDD 부품 정보 #");
		showCom();
	}
}

class Computer22 {
	private String company;
	private ArrayList<PartComp> plist; // 여기가 추가됨
	private Cpu2 cpu; // 각 하나씩 추가해야했음
	private Ram2 ram;
	private Hdd2 hdd;
	
	public Computer22(String company) {
		super();
		this.company = company;
		plist = new ArrayList<PartComp>();
	}
	
	// 상위 = 하위(); -> 다형성이 일어나서 가능
	// PartComp pc = new Cpu22("Ms", "3.6Hz");
	public void addPartComp(PartComp pc) {
		// 각 부품을 할당할 수 있게 됨
		plist.add(pc);
		System.out.println("# 부품 장착 #");
		System.out.println(pc.getKind() + "추가 장착 \n");
	}
	
	public void ShowPartList() {
		System.out.println("# 컴퓨터의 부품 현황 #");
		System.out.println("컴퓨터 제조사 : " + company);
		if(plist.size() == 0) {
			System.out.println("부품없음\n");
		} else {
			System.out.println("종류\t제조사\t사양");
			for(PartComp c:plist) {
				// 재정의한 메소드 호출
				// 각 부품별로 다르게 정의한 내용이 출력된다.
				c.show2();
			}
		}
	}
	
	// 기능 메소드를 통해 부품 장착
	public void setCpu(Cpu2 cpu) {
		this.cpu = cpu;
	}

	public void setRam(Ram2 ram) {
		this.ram = ram;
	}

	public void setHdd(Hdd2 hdd) {
		this.hdd = hdd;
	}	
}