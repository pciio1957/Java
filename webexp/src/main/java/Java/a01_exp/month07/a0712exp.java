package Java.a01_exp.month07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Java.z01_vo.Emp;
import Java.z01_vo.Product;

public class a0712exp {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/* # 지난 주 정리문제
	3. DML 처리 순서를 정리하세요.
	
		DML(insert, update, delete) 처리
		1) 기능 메소드 선언
			public void insertEmp(Emp ins) 
		2) 연결 공통메소드 호출
		3) con.setAutocommit(false);
			자동 autocommit 발생 방지
		4) sql 선언 (insert, update, delete)
			insert into emp02 values(emp_seq.nextval, ?, ?, sysdate, ?, ?, ?);
		5) PreparedStatement 처리
			pstmt.setXXX(1, 데이터);
			pstmt.setXXX(2, 데이터);
			pstmt.setXXX(3, 데이터);
		6) executeUpdate();
		7) con.commit();
		8) 자원해제처리
		9) 예외처리 - rollback();
		
		1) sql 작성 : 생성 및 insert, update, delete, sequence
		2) 조건이나 입력할 데이터를 받은 구조 VO 클래스 선언
		3) con.autocommit(false)
		4) con.preparedStatement(sql)
		5) 매개변수 처리 pstmt.setXXX(순서, 데이터)
		6) rs = pstmt.executeUpdate()
		7) con.commit()
		8) 자원해제
		9) 예외처리 (SQLException) 블럭에 con.rollback()
		
	4. PreparedStatement를 활용하여, Product 테이블을 만들고,
    	물건정보 등록, 조회, 수정 처리하세요.
    	
	~ 09:30 제출상황을 보고 추가시간을 드리겠습니다.
	
	*/
	
	// DB연결 메소드 
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

	// DB 조회 
	public ArrayList<Product> getPdList() {
		ArrayList<Product> plist = new ArrayList<Product>();
		
		try {
			setCon();
			
			String sql = "select * from product";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				plist.add(new Product
						(rs.getString(1),
						 rs.getString(2),
						 rs.getInt(3),
						 rs.getInt(4))
				);
			}
			
			rs.close(); pstmt.close();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
		
		return plist;
	}
	
	// 이름, 가격 조건이 있는 조회
	public ArrayList<Product> searchPd(Product sch) {
		ArrayList<Product> plist = new ArrayList<Product>();
		
		try {
			setCon();
			
			String sql = "SELECT *\r\n"
					+ "FROM product \r\n"
					+ "WHERE name LIKE '%'||?||'%' AND price BETWEEN ? AND ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getName());
			pstmt.setInt(2, sch.getFr_price());
			pstmt.setInt(3, sch.getTo_price());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				plist.add(new Product
						(rs.getString(1),
						 rs.getString(2),
						 rs.getInt(3),
						 rs.getInt(4))
				);
			}
			
			rs.close(); pstmt.close();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
		
		return plist;
	}
	
	// 물건 정보 삽입
	public void insertPd(Product product) {
		
		try {
			setCon();
			
			// 자동으로 커밋되서 잘못된 데이터를 넣지않도록 하기위해 방지
			con.setAutoCommit(false);
			
			String sql = "INSERT INTO product values('PRO'||prod_seq.nextval, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setInt(3, product.getCnt());
			pstmt.executeUpdate();

			con.commit();
			
			pstmt.close(); con.close();
			
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
	}
	
	// 물건 정보 수정
	public void modifyPd(Product product) {
		
		try {
			setCon();
			
			con.setAutoCommit(false);
			
			String sql = "update product set \r\n"
					+ "price = ?, cnt = ? \r\n"
					+ "where pno = ?";
				
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product.getPrice());
			pstmt.setInt(2, product.getCnt());
			pstmt.setString(3, product.getPno());
			pstmt.executeUpdate();
			
			con.commit();
			
			pstmt.close();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
	
	// 물건 삭제처리
	public void DeletePd(String pno) {
		try {
			setCon();
			
			con.setAutoCommit(false);
			
			String sql = "delete from product where pno = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pno);
			pstmt.executeUpdate();
			
			con.commit();
			
			con.close(); pstmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a0712exp dao = new a0712exp(); 
		ArrayList<Product> pdList = new ArrayList<Product>();
		pdList = dao.getPdList();
		
		System.out.println("1. 리스트 조회");
		System.out.println("번호\t물건명\t가격\t재고");
		for(Product p:pdList) {
			System.out.print(p.getPno() + "\t");
			System.out.print(p.getName() + "\t");
			System.out.print(p.getPrice() + "\t");
			System.out.print(p.getCnt() + "\n");
		}
		System.out.println();
//		
//		dao.insertPd(new Product("번호", "키위", 7000, 30));
//		pdList = dao.getPdList(); // 입력 확인용
//		
//		System.out.println("2. 입력 확인용");
//		System.out.println("물건명\t가격\t재고");
//		for(Product p:pdList) {
//			System.out.print(p.getPno() + "\t");
//			System.out.print(p.getName() + "\t");
//			System.out.print(p.getPrice() + "\t");
//			System.out.print(p.getCnt() + "\n");
//		}
//		System.out.println();
		
		dao.modifyPd(new Product(2000, 3, "PRO1000"));
		pdList = dao.getPdList(); // 입력 확인용
		
		System.out.println("3. 수정 확인용");
		System.out.println("물건명\t가격\t재고");
		for(Product p:pdList) {
			System.out.print(p.getPno() + "\t");
			System.out.print(p.getName() + "\t");
			System.out.print(p.getPrice() + "\t");
			System.out.print(p.getCnt() + "\n");
		}
		System.out.println();
		
		
		pdList = dao.searchPd(new Product("", 0, 5000));
		
		System.out.println("4. 이름&가격 조회용");
		System.out.println("번호\t물건명\t가격\t재고");
		for(Product p:pdList) {	
			System.out.print(p.getPno() + "\t");
			System.out.print(p.getName() + "\t");
			System.out.print(p.getPrice() + "\t");
			System.out.print(p.getCnt() + "\n");
		}
		
		// 잘못 입력한 텀블러 삭제
		String pnum = "PRO1007";
		dao.DeletePd(pnum);
		
		pdList = dao.getPdList(); // 입력 확인용
		
		System.out.println("5. 삭제 확인용");
		System.out.println("물건명\t가격\t재고");
		for(Product p:pdList) {
			System.out.print(p.getPno() + "\t");
			System.out.print(p.getName() + "\t");
			System.out.print(p.getPrice() + "\t");
			System.out.print(p.getCnt() + "\n");
		}
		
	}

}
