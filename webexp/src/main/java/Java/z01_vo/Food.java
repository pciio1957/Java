package Java.z01_vo;
// Jsp에 파일 불러오기 : javaexp.z01_vo.Food 패키지명.클래스명 복사
public class Food {
	private String fname;
	private int fprice;
	private String fLoc;
	
	public Food() {
		super();
	}

	public Food(String fname, int fprice, String fLoc) {
		super();
		this.fname = fname;
		this.fprice = fprice;
		this.fLoc = fLoc;
	}
	
	// field에 대한 직접적인 접근하지 못하지만,
	// 간접적으로 입력하는 메소드/호출하는 메소드를 분리시켜
	// 처리하게 해준다. 
	public String getfname() {
		return fname;
	}

	public int getfprice() {
		return fprice;
	}

	public String getfLoc() {
		return fLoc;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getFprice() {
		return fprice;
	}

	public void setFprice(int fprice) {
		this.fprice = fprice;
	}

	public void setfLoc(String fLoc) {
		this.fLoc = fLoc;
	}
	
	

}
