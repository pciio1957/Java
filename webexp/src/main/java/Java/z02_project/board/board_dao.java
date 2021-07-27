package Java.z02_project.board;
//package javaexp.z05_project.sample_board;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import org.springframework.stereotype.Repository;
//
//public interface board_dao {
//	   public int totCnt(BoardSch sch);
//	   public ArrayList<Board> boardList(BoardSch sch);
//	   /*
//	   {
//	      // 조회데이터
////	      sch.getWriter() // 작성자
////	      sch.getSubject() // 제목
//	      
////	      // 출력한 데이터
//	      ArrayList<Board> list  = new ArrayList<Board>();
//	      list.add(new Board());
//	      list.add(new Board());
//	      list.add(new Board());
//	      list.add(new Board());
//	      
//	      return list 
//	   }
//	   */
//	   public void insertBoard(Board insert);   
//	   public void uploadFile(BoardFile ins);
//	   public Board getBoard(int no);
//	   public ArrayList<BoardFile> fileInfo(int no);
//	   public void uptReadCnt(int no);
//	   public void updateBoard(Board upt);
//	   public void updateFile(HashMap<String, String> hs);
//	   public void deleteBoard(int no);   
//	   public void deleteFile(int no);
//	   public Member login(Member mem);
//	}