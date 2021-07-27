SELECT * FROM emp;

-- 1. SELECT문의 기본형식
-- 		1) SELECT * FROM emp; : emp 테이블의 모든 칼럼 보기
-- 		2) SELECT empno FROM emp; : emp 테이블의 empno 칼럼 보기

-- 2. 사원정보
SELECT deptno, empno, ename, sal 
FROM emp;

-- 3. 별칭선언의 기본형식
-- SELECT empno AS EMP,
--		ename "사원명"
--		deptno deptNumber
-- FROM emp;
SELECT ename "이 름",
		sal "연 봉"
FROM emp;

-- 4. 사원정보 출력
SELECT '부서는 ' || dname || '이고 사원번호는 ' || empno || 
		', 급여는 ' || sal || ', 보너스는 ' || comm || '입니다'
FROM emp, dept;

-- 5. JDBC란
--   DB 서버에 접속할 때 필요한 프로그램 모듈들을 JAVA로 만들어서 처리한 
-- 	 CLASS의 압축판이다.
-- 	 자바에서 DB를 접속할 수 있도록 도와주는 JAVA API이다. 

-- 6. 필요한 서버 등록 정보
-- 	 oracle 다운로드 후 설치시 관리자 비밀번호 : 1111
--   scott.sql 파일에 접근하기 위한 ID/PW : SCOTT/tiger
--   sqlplus에 진입하기 위한 username/Pw : system/1111
--   이클립스의 데이터베이스 연결시 xe 설정, 포트번호 1521 
--   	DB 연결을 위한 ojdbc6.jar 연결, jdbc Driver 클래스 연결