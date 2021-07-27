package Java.a01_exp.month07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Java.a01_exp.z01_vo.Member;

public class a0709exp {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/*
	
	#전날 정리문제
	1. sql을 통해서 Dao에서 다중행 데이터와 단일행 데이터 처리방법의 차이기술하기
		- 단일행의 경우 한가지 데이터만 들어오기때문에 if문을 이용해 데이터가 들어오는지 확인후
		해당 행의 데이터를 VO객체에 삽입하여 해당 객체를 이용한다
		if(rs.next()) {
			참조변수 = new 생성자(rs.get데이터유형(순서), ..);
		}
		- 다중행의 경우 한가지 이상의 데이터가 들어오기 때문에 while문같은 반복문을 사용해서
		데이터가 들어오는지 판별 후 ArrayList<VO>객체에 담아준다 
		while(rs.next()) {
			list.add(new 생성자(rs.get데이터유형(순서),..));
		}
		
	2. PreparedStatement를 사용하는 이유와 기본 형식을 기술하기
		- 데이터의 보안과 많은 데이터를 처리하기 위해서 Statement 대신 PreparedStatment를 사용한다.
		
		private PreparedStatement pstmt; // pstmt 선언
		
		// DB연결로 가져올 데이터를 위한 sql문 작성
		String sql = "SELECT * \r\n"
				+ "	FROM emp01 \r\n"
				+ "	WHERE ename LIKE '%'||?||'%'\r\n"
				+ "	AND job LIKE '%'||?||'%'";
			
		// pstmt에 sql을 할당하고 query 진행
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, ename);
		pstmt.setString(2, job);
		rs = pstmt.executeQuery();
		
		
		1) sql injection 방지 : 동적 sql로 우회적으로 데이터가 인증처리되는 것을 막는다.
		2) 속도의 향상 : 매개값을 따로 전달함으로 동일한 sql로 인식하게 하여, 
    	컴파일 속도에 대한 향상으로 빠른 데이터 처리가 가능하게 한다.
 
		#기본형식 
			sql ="insert into emp02 values(?,?,?,?.....);
			pstmt = con.preparedStatement(Sql);
			pstmt.setInt(1,ins.getEmpno());
			pstmt.setInt(2,ins.getEname());
			pstmt.setInt(1,ins.getJob());
			.....

			rs = pstmt.excuteUpdate(); 
		
		
	3. DML처리의 기본 절차를 기본 예제와 함께 기술하기
	
		1) 기능 메소드 선언
			- public void insertEmp(Emp ins) 
		2) 연결 공통메소드 호출
		3) con.setAutocommit(false);
			- 자동 autocommit 발생 방지
		4) sql 선언 (입력 sql문)
			- insert into emp02 values(emp_seq.nextval, ?, ?, sysdate, ?, ?, ?);
		5) 대화 : PreparedStatement 처리
			- pstmt.setXXX(1, 데이터);
			- pstmt.setXXX(2, 데이터);
			- pstmt.setXXX(3, 데이터);
		6) 실행: executeUpdate();
		7) 커밋처리 : con.commit();
		8) 자원해제
		9) 예외처리 : SQLException에서 con.rollback();
		
	
	4. 회원테이블 Member를 만들고, id, pass를 받아 로그인처리하는 프로그램을
		PreparedStatment 처리형식으로 만들기 
		1) 회원테이블 만들기, 데이터 입력 : Member클래스
		2) sql 작성 및 확인 : insert into member values(회원번호, 아이디, 패스워드, 회원명, 권한, 포인트, 등록일) 
		3) VO 객체 작성 Member 
		4) 기본 전역변수 및 공통 연결 메소드 선언
		5) public void insertMember(Member ins) 
		6) ... 

	*/
	
	public void setCon() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(info, "scott", "tiger");
		
		System.out.println("접속 성공");
	}
	
	// 데이터 입력을 위한 메소드
	public Member login(String id, String pass) {
		Member mem = null;
				
		try {
			setCon();
			
			// 자동으로 커밋되서 잘못된 데이터를 넣지않도록 하기위해 방지
			con.setAutoCommit(false);
			
			String sql = "select * from Member where id = ? and pass = ?";
			
			System.out.println(" - sql 확인 : " + sql);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				mem = new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getDate(7)		
				);
			}
				

			// 제대로 진행되었다면 commit 진행
			con.commit();
			
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL 예외 발생 " + e.getMessage());
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (Exception e) {
			System.out.println("일반 예외 발생 : " + e.getMessage());
		} finally {

			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return mem;
	}
	
	public boolean wlogin(Member m) {
		boolean hasMember = false;
		
		
		try {
			setCon();
			
			// 자동으로 커밋되서 잘못된 데이터를 넣지않도록 하기위해 방지
			con.setAutoCommit(false);
			
			String sql = "select * from Member where id = ? and pass = ?";
			
			System.out.println(" - sql 확인 : " + sql);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPass());
			rs = pstmt.executeQuery();
			hasMember = rs.next();
				

			// 제대로 진행되었다면 commit 진행
			con.commit();
			
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL 예외 발생 " + e.getMessage());
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (Exception e) {
			System.out.println("일반 예외 발생 : " + e.getMessage());
		} finally {

			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return hasMember;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		a0709exp dao = new a0709exp();
		Member m = dao.login("himan", "7777");
		if(m != null) {
			System.out.println(m.getName());
			System.out.println("회원 등록 여부 : " 
					+ dao.wlogin(new Member("higirl", "8888")));
		}
		
	}
	


}
