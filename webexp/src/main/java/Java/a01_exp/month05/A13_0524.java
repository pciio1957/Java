package Java.a01_exp.month05;

import java.util.ArrayList;

public class A13_0524 {
	
	/*
	1. 클래스의 구성요소의 특징과 활용에 대해 기술하기
	2. 가계부의 입출입 내역을 클래스로 만들고, 입출입 내역과 잔액 출력하기
		Record (날짜, 내용, 구분, 금액)
			메소드 : write(구분, 금액) 구분으로 수입이면 금액을 +로 
					지출이면 금액을 - 리턴하여 처리하기
					위 입출입내역 Record를 3개 정도 만들고 현 잔액을 출력하기
	3. Visitor(방문객 이름, 나이)이 Museum(박물관)에 방문한 내용을 1:1 관계로 처리하세요
	4. BookStore에 서점명 구매도서(Book)을 1:다 관계로 구매와 구매내역을 처리하는 프로그램 만들기
	5. Computer(회사명, 기타객체, add(부품), showInf()) 객체 안에 Cpu(제조사, 사양), 
		Ram(제조사, 사양), Hdd(제조사, 사양)을 할당하여 showInfo()로 해당 컴퓨터의 부품내역을 출력하기
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. 클래스의 구성요소
		// 		1) 필드 : 해당 객체의 데이터 공유, 전역변수 지정.. 
		//		2) 생성자 : 필드(속성값)의 초기화 처리
		//		3) 메소드 : 기능처리
		
		
		// 2. 가계부
		Record rc1 = new Record("5/15", "일당");
		Record rc2 = new Record("5/16", "책사기");
		Record rc3 = new Record("5/16", "당근");
		Record rc4 = new Record("5/17", "점심");
		
		int rtot = 0;
		System.out.println("# 2. 가계부 수입지출내역 #");
		rtot += rc1.write("수입", 50000);
		rtot += rc2.write("지출",12000);
		rtot += rc3.write("수입",3000);
		rtot += rc4.write("지출",8000);
		
		System.out.println("현 잔액 : " + rtot);
		
		
		// 3. 방문록 작성
		Museum ms = new Museum("미술");
		ms.write();
		ms.visit(new Visitor("홍길동", 30));
		ms.write();
		
		
		// 4. 서점 구매내역
		BookStore bs = new BookStore("교보");
		bs.buy(new Book01("자바", "홍길동", 12000, 2));
		bs.buy(new Book01("DB", "김길동", 18000, 1));
		bs.buy(new Book01("SQL", "남길동", 5000, 4));
		bs.buy(new Book01("이클립스", "이길동", 7000, 3));
		
		
		System.out.println("총 합계 금액 : " + bs.bookSum());
		
		
		// 5. 컴퓨터 부품내역
		Computer com1 = new Computer("삼성");
		
		System.out.println("\n# 5. 컴퓨터 부품추가 #");
		com1.add(new Cpu("인텔", "i5"));
		com1.add(new Cpu("라이젠", "5600X"));
		com1.add(new Ram("삼성", "8G"));
		com1.add(new Ram("삼성", "16G"));
		com1.add(new Hdd("씨게이트", "512GB"));
		com1.add(new Hdd("도시바", "2TB"));
		
		com1.showInf();

		
		
	}
}


// 2.
class Record {
	private String rDate;
	private String rCon;
	private String rSub;
	private int rPrice;
	
	
	public Record(String rDate, String rCon) {
		super();
		this.rDate = rDate;
		this.rCon = rCon;
	}


	public int write(String rs, int rp) {
		
		if(rs.equals("수입")) {
			System.out.println("[" + rDate + "] " + rCon + " : +" + rp);
			return +rp;
		} else {
			System.out.println("[" + rDate + "] " + rCon + " : -" + rp );
			return -rp;
		}
	}
}

// 3번문제
class Visitor {
	private String vName;
	private int vAge;
	
	public Visitor(String vName, int vAge) {
		super();
		this.vName = vName;
		this.vAge = vAge;
	}
	
	public void info() {
		System.out.print(vName + "(" + vAge + ")가 ");
	}
	
	
}

class Museum {
	private Visitor vt;
	private String mName;
	
	public Museum(String mName) {
		super();
		this.mName = mName;
	}
	
	public void visit(Visitor v) {
		vt = v;
		System.out.println("\n# 박물관에 방문했습니다! #");
	}
	
	public void write() {
		
		System.out.println("\n# 3. 박물관에 방문할까요? #");
		if(vt != null) {
			vt.info();
			System.out.println(mName + "에 방문했습니다");
		} else {
			System.out.println("박물관에 방문하지 않았습니다....");
		}
	}	
}


// 4번문제
class BookStore {
	private ArrayList<Book01> bList;
	private String storeName;
	
	
	
	public BookStore(String storeName) {
		super();
		this.storeName = storeName;
		bList = new ArrayList<Book01> ();
	}

	public void buy(Book01 b) {
		bList.add(b);
		System.out.println(b.getbName() + "(" + b.getBwriter() +
				", " + b.getbPrice() + ") - " + b.getbCnt() + "개 구매 완료" );

	}
	
	public int bookSum() {
		System.out.println("\n#" + storeName + "에서 구매하신 물품목록 #");
		
		int tot = 0;
		System.out.println("책명\t글쓴이\t가격\t갯수\t");
		for(Book01 b:bList) {
			tot += b.info();
		}
		
		return tot;
	}
	
	
}

class Book01 {
	private String bName;
	private String bwriter;
	private int bPrice;
	private int bCnt;
	
	public Book01(String bName, String bwriter, int bPrice, int bCnt) {
		super();
		this.bName = bName;
		this.bwriter = bwriter;
		this.bPrice = bPrice;
		this.bCnt = bCnt;
	}
	
	public int info() {
		
		System.out.println(bName + "\t" + bwriter + "\t" + bPrice 
				+ "\t" + bCnt + "\t" + (bPrice * bCnt));
		return bPrice * bCnt;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public int getbPrice() {
		return bPrice;
	}

	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}

	public int getbCnt() {
		return bCnt;
	}

	public void setbCnt(int bCnt) {
		this.bCnt = bCnt;
	}
}

// 5번문제
class Computer {
	private String comName;
	private ArrayList<Cpu> cpu;
	private ArrayList<Ram> ram;
	private ArrayList<Hdd> hdd;
	
	public Computer(String comName) {
		super();
		this.comName = comName;
		cpu = new ArrayList<Cpu> ();
		ram = new ArrayList<Ram> ();
		hdd = new ArrayList<Hdd> ();
	}
	
	public void add(Cpu c) {
		//System.out.println("부품추가");
		if(cpu != null) {
			cpu.add(c);
			System.out.println("- " + c.getcSpec() + "/" 
						+ c.getcMake() + " : CPU 추가");
		} else {
			System.out.println("부품이 추가되지 않았습니다.");
		}
	}
	
	public void add(Ram r) {
		if(ram != null) {
			ram.add(r);
			System.out.println("- " + r.getrSpec() + "/" 
						+ r.getrMake() + " : RAM 추가");
		} else {
			System.out.println("부품이 추가되지 않았습니다.");
		}
	}
	
	public void add(Hdd d) {
		if(hdd != null) {
			hdd.add(d);
			System.out.println("- " + d.gethSpec() + ", " 
						+ d.gethMake() + " : HDD 추가");
		} else {
			System.out.println("부품이 추가되지 않았습니다.");
		}
	}
	
	

	public void showInf() {
		System.out.println("\n# 부품 내역 #");
		System.out.println("제조사\t사양");
		if(cpu != null) {
			for(Cpu c:cpu) {
				System.out.println(c.getcSpec() + "\t" + c.getcMake());
			}
		} 
		if(ram != null) {
			for(Ram r:ram) {
				System.out.println(r.getrSpec() + "\t" + r.getrMake());
			}
		} 
		if(hdd != null) {
			for(Hdd h:hdd) {
				System.out.println(h.gethSpec() + "\t" + h.gethMake());
			}
		}
	}
}

class Cpu {
	private String cMake;
	private String cSpec;

	public Cpu(String cMake, String cSpec) {
		super();
		this.cMake = cMake;
		this.cSpec = cSpec;
	}
	
	public String getcSpec() {
		return cSpec;
	}

	public String getcMake() {
		return cMake;
	}

	public void setcMake(String cMake) {
		this.cMake = cMake;
	}

	public void setcSpec(String cSpec) {
		this.cSpec = cSpec;
	}
}

class Ram {
	private String rMake;
	private String rSpec;
	
	public Ram(String rMake, String rSpec) {
		super();
		this.rMake = rMake;
		this.rSpec = rSpec;
	}

	public String getrMake() {
		return rMake;
	}

	public void setrMake(String rMake) {
		this.rMake = rMake;
	}

	public String getrSpec() {
		return rSpec;
	}

	public void setrSpec(String rSpec) {
		this.rSpec = rSpec;
	}
}


class Hdd {
	private String hMake;
	private String hSpec;
	
	public Hdd(String hMake, String hSpec) {
		super();
		this.hMake = hMake;
		this.hSpec = hSpec;
	}

	public String gethMake() {
		return hMake;
	}

	public void sethMake(String hMake) {
		this.hMake = hMake;
	}

	public String gethSpec() {
		return hSpec;
	}

	public void sethSpec(String hSpec) {
		this.hSpec = hSpec;
	}
}