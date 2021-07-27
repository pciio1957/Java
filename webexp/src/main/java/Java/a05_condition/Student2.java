package Java.a05_condition;

public class Student2 {
	private String sNum;
	private String sKor;
	private String sEng;
	private String sMath;
	
	public Student2(String sNum, String sKor, String sEng, String sMath) {
		super();
		this.sNum = sNum;
		this.sKor = sKor;
		this.sEng = sEng;
		this.sMath = sMath;
	}
	

	public void show(String name) {
		System.out.print(name + "\t");
		System.out.print(sNum + "\t");
		System.out.print(sKor + "\t");
		System.out.print(sEng + "\t");
		System.out.println(sMath);
	}

	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

	public String getsKor() {
		return sKor;
	}

	public void setsKor(String sKor) {
		this.sKor = sKor;
	}

	public String getsEng() {
		return sEng;
	}

	public void setsEng(String sEng) {
		this.sEng = sEng;
	}

	public String getsMath() {
		return sMath;
	}

	public void setsMath(String sMath) {
		this.sMath = sMath;
	}

}
