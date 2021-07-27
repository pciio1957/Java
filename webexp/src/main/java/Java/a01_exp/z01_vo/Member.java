package Java.a01_exp.z01_vo;

import java.util.Date;

public class Member {
	private int mno;
	private String id;
	private String pass;
	private String name;
	private String auth;
	private int point;
	private Date regdte;
	
	public Member() {
		super();
	}
	
	public Member(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}

	public Member(int mno, String id, String pass, String name, String auth, int point, Date regdte) {
		super();
		this.mno = mno;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.auth = auth;
		this.point = point;
		this.regdte = regdte;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getRegdte() {
		return regdte;
	}

	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}
}
