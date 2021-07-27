package Java.a01_exp.month07;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import Java.z01_vo.Emp;

public class a0708exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		  
		# 정리문제
		1. Dao의 주요 필드 4가지의 역할을 기술하세요.
			1) jdbc드라이버를 메모리에 로딩
			2) 서버에 접속
			3) 기능메소드를 통해 데이터를  조회, 등록, 수정, 삭제 처리함 
			4) 사용한 자원들을 해제한다
			
			1) Connection : 연결객체로 DB서버와 연결기능
			2) Statement, PreparedStatement : sql을 실행하는 객체
			3) ResultSet : select의 결과를 2차원형식으로 받는 객체
				필드는 각 기능메소드에서 공통적/중복적으로 사용되기 때문에 선언하여
				참조변수로 활용할 수 있다
			ex) setCon() 기능메소드에 의해서 Connection 객체에 데이터를 할당처리한다
		
		2. jdbc 드라이버의 역할에 대하여 기술하세요
			DB 연결에 필요한 패키지와 메소드들을 사용할 수 있도록 import해서 사용한다. 
			
			java로 서버에 접속하기 위해서는 복잡한 프로그램이 필요하다
			이 중에서 공통적인 부분을 클래스로 만들어 압축하여 
			개발자의 서버 접속에 필요한 대부분의 내용 중 변경이 필요없는 부분을
			각 DB 서버회사에서 만들어 제공하고 있다. 이것을 드라이버라고 한다.
			java database connection driver로 접속할 때 메모리에 로딩하여 시작한다
			
		3. 특정 서버 접속정보 처리 기능객체와 메서드의 매개변수값을 기술하세요.
			public void setCon() throws SQLException {

				try {
					// 필수예외처리 
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String info = "jdbc:oracle:thin:@localhost:1521:xe";
					con = DriverManager.getConnection(info, "scott", "tiger");
					System.out.println("접속 성공");
		
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			1) jdbc드라이버를 Class.forName("드라이버명") 메모리로딩
			2) DriverManager.getConnection("드라이버, 접속ip, port, sid", "계정","비밀번호") 
				-> 결과 리턴값으로 Connection에 메모리를 할당 처리한다 
			
		4. 기능 메서드(조회) 구현의 순서와 핵심코드를 기술하세요
			public ArrayList<Emp> getEmpList() {
				ArrayList<Emp> emplist = new ArrayList<Emp>();
		
				// 1. 연결 공통메소드 호출 - Connection객체가 생성됨
				try {
					setCon();
			
			
					// 2. 사용할 sql문 작성
					String sql = "select * from emp02";
		
					// 3. statement 객체를 생성하고
					//	1) setCon()을 통해서 만들어지는 Connection 객체의 
					//		기능 메소드를 통해서 Statement 객체 생성
					stmt = con.createStatement();
					
					// 4. ResultSet 객체를 생성한다
					//	1) Statement가 지원하는 기능메소드인 executeQuery에
					//		매개변수로 sql을 입력 (sql문 처리)
					//	2) 그 수행 결과를 담기위한 ResultSet 객체에 할당한다.
					rs = stmt.executeQuery(sql);
					
					// 5. VO객체의 ArrayList에 데이터 삽입
					// 가져올 데이터의 수를 파악하고 조건문/반복문을 적절하게 사용해서
					//	데이터를 변수나 ArrayList에 담는다. 
					int rowCount = 0;
			
					System.out.println("사원번호\t사원명\t직급\t관리자번호\t입사일\t월급\t보너스\t부서번호");
					while(rs.next()) {
						System.out.print(rowCount++ + "\t");
						System.out.print(rs.getInt("empno") + "\t");
						System.out.print(rs.getString("ename") + "\t");
						System.out.print(rs.getString("job") + "\t");
						System.out.print(rs.getInt("mgr") + "\t");
						System.out.print(rs.getDate("hiredate") + "\t");
						System.out.print(rs.getDouble("sal") + "\t");
						System.out.print(rs.getDouble("comm") + "\t");
						System.out.print(rs.getInt("deptno") + "\n");
					
						emplist.add(new Emp(rs.getInt("empno"), 
								rs.getString("ename"),
								rs.getString("job"),
								rs.getInt("mgr"),
								rs.getDate("hiredate"),
								rs.getDouble("sal"),
								rs.getDouble("comm"),
								rs.getInt("deptno")
						));
			
					}
			
					System.out.println("ArrayList의 데이터갯수 : " + emplist.size());
					
					rs.close(); 
					stmt.close();
					con.close();
			}
			
			0) sql 작성
				입력, 결과값 확인
				select *
				from emp
				where ename like '%' || ' ' || '%'
				and job like '%'||' ' ||'%'; 
				
			1) 기능메소드의 구조 만들기
				결과로 어떤 데이터를 가져올 것 인지? -> 리턴값 형식/객체 작성 -> ArrayList
				DB서버에 입력데이터는 무엇인지? -> 매개변수 선언 
				리턴할 객체 선언과 할당
				public ArrayList<Emp> empList(Emp sch) {
					ArrayList<Emp> list = new ArrayList<Emp>();
					
					return list;
				}
				
			2) 공통 연결메소드 호출 setCon()과 기본 try예외처리문 
				Connection con에 메모리가 로딩된 상황
				
			3) Statement 필드에 선언한 대화객체에 메모리 로딩
				stmt = con.createStatement();
				대화객체 만들기
			
			4) ResultSet 객체 만들기, stmt에 sql로 수행된 결과 객체 메모리 로딩
				rs = stmt.executeQuer(sql);
			
			5) while문, if문을 통해서 rs의 next()로 행단위로 이동하면서 
				rs.getXXX("컬럼명"|순서index)로 가져온 데이터를 객체에 할당
				
				while(rs.next()) {
					list.add(new Emp(rs.getInt("empno"), ..));
				}
			
			6) 자원의 해제 : 역순위로 자원해제 처리 
				rs.close(); stmt.close(); con.close();
			
			7) 기타 예외내용 처리 
			
		5. ResultSet 객체의 주요 메서드와 그 기능을 기술하세요.
			next() : 행단위로 이동하면서 다음 순서의 데이터를 가져온다
			getString() : 문자열형의 데이터를 가져온다
			getInt() : 정수형의 데이터를 가져온다
			getDouble() : 실수형의 데이터를 가져온다 
			getDate() : 날짜형의 데이터를 가져온다 
			
			getString("컬럼명") : 해당 컬럼의 문자열형 데이터를 가져온다
			getString(1) : 해당 인덱스 번호의 문자열형 데이터를 가져온다.
			
		
		6. ResultSet의 ArrayList 변환 과정을 기술하세요.
			1) 단일 데이터의 경우 : if문으로 조건에 맞는 데이터 가져오기
				if(rs.next()) {
					System.out.print(rs.getString(1));
					System.out.print(rs.getString(2));
				}
			
			2) 다중 데이터의 경우 : 조회처럼 여러 데이터를 가져올때 사용
				while(rs.next()) {
					System.out.print(rs.getString(1));
					System.out.print(rs.getInt(2));
				}
		
		~9:20까지 제출해주세요..
		 
		*/

	}

}
