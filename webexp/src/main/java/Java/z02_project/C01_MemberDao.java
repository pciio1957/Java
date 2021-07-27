package Java.z02_project;

// DAO(database access object)
public class C01_MemberDao {
	// 로그인시 처리할 메소드
	public String login(Member m) {
		// 데이터를 받아서 처리
		// 아직 Db를 못하니까 이정도로 가져온다, 처리한다만 보여줌
		System.out.println("# Db 처리(로그인) #");
		System.out.println(m.getId());
		System.out.println(m.getPass());
		// return "성공";
		// 밑에 himan&7777은 DB가 없어서 선언한거
		// 아니면 
		return m.getId().equals("himan") && 
				m.getPass().equals("7777")?"성공":"실패";
	}
	
	public String insert(Member insert) {
		
		// 아직 db연결을 안했으니까 했다고 출력처리함
		System.out.println("# DB 처리(회원가입) #");
		System.out.println(insert.getId());
		System.out.println(insert.getPass());
		System.out.println(insert.getName());
		System.out.println(insert.getAuth());
		System.out.println(insert.getEmail());
		
		return "회원 등록 성공";
	}

}
