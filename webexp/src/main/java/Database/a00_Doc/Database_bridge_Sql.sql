
SELECT * FROM emp02;

-- 이름 중간에 A가 들어가는 사람 조회 
SELECT * 
FROM 
WHERE ename LIKE '%A%';


-- 응용문제용
SELECT * FROM dept;

SELECT deptno, empno, ename, job, sal
FROM emp02
WHERE deptno=10;

-- 여러 행을 사용하는 데이터 ArrayList<VO>
SELECT * FROM emp;

-- 단일행의 결과값을 받은 데이터 VO
SELECT sum(sal), avg(sal), count(*)
FROM emp;

-- 단일행의 단일변수 (숫자)
SELECT count(*)
FROM emp;

-- 단일행의 단일변수 : 최고 급여자의 이름 (문자열형)
SELECT ename
FROM emp 
WHERE sal = (SELECT max(sal) FROM emp);

-- 단일행의 단일변수 (boolean형)
-- key를 입력하여 있는지 여부만 확인할 때 
-- JAVA에서 re.next()로 boolean을 리턴할 수 있다.
 SELECT *
 FROM EMP e 
 WHERE empno = 7780;
 


-- 0708
SELECT * FROM emp;

-- 1) 숫자형 데이터 조회 : 사원번호로 검색
SELECT * FROM emp WHERE empno = 7369;

/*
#프로그래밍에서는 위 내용을 sql로 만들어서 처리 매개변수로 넘겨오는 숫자변수
public ArrayList<Emp> getEmpno(int empno) {
	String sql = "select * from emp where empno = " + empno; 
}
*/

-- 2) 문자열 데이터 조회 : 이름이 ALLEN인 사람 조회
SELECT *
FROM emp 
WHERE ename = 'ALLEN';

/*
#프로그래밍에서는 위 내용을 sql로 만들어서 처리 매개변수로 넘겨오는 문자열변수
public ArrayList<Emp> getEname(String ename) {
	String sql = "select * from emp where empno like '" + ename + "'"; 
}
*/

SELECT *
FROM emp 
WHERE ename LIKE '%'||'A'||'%'
AND job LIKE '%'||'MAN'||'%';

/*
#프로그래밍에서는 위 내용을 sql로 만들어서 처리 매개변수로 넘겨오는 문자열변수
public ArrayList<Emp> getEname(String ename, String job) {
	String sql = "select * from 
	emp where empno like '%'||'" + ename + "'||%' 
	and job like '%'||'" + job + "'||'%'"; 
}

더 많은 데이터가 들어온다면 
public ArrayList<Emp> getEname(Emp sch) {
	String sql = "select * from 
	emp where empno like '%'||'" + sch.getEname() + "'||%' 
	and job like '%'||'" + sch.getJob() + "'||'%'"; 
}
*/


-- a03_DaoSch의 검색 키워드 
SELECT *
FROM emp01 
WHERE ename LIKE '%'||'A'||'%'
AND job LIKE '%'||'C'||'%';


-- 응용문제의 sql문
SELECT *
FROM emp e, dept D 
WHERE e.deptno = d.deptno
AND ename LIKE '%'||''||'%'
AND dname LIKE '%'||''||'%';

-- 단일객체 sql문
SELECT *
FROM emp02
WHERE empno = 7369;

-- 다중객체 sql문
SELECT *
FROM dept
WHERE deptno = 10;


-- 응용) A05_PreparedDao.java에서 기능메소드 추가하여
-- PreparedStatement를 활용하여 위 sql을 처리하기 (4,5조)
SELECT *
FROM emp01
WHERE ename LIKE '%'||?||'%'
AND job LIKE '%'||?||'%';


-- 등록처리
SELECT * FROM emp02;

DELETE FROM emp WHERE empno IS NULL;

INSERT INTO emp02 values(emp_seq_01.nextval, '홍길동', '사원', 7902, sysdate, 3500, 1000, 10);
INSERT INTO emp02 values(emp_seq_01.nextval,?, ?, ?, sysdate, ?, ?, ?);

CREATE SEQUENCE emp_seq_01
START WITH 7935 
INCREMENT BY 1 
MAXVALUE 9999
MINVALUE 1000
CYCLE; 


-- 응용) 등록처리 

CREATE TABLE dept02
AS SELECT * FROM dept;

DROP TABLE dept02;

INSERT INTO dept02 values(11, '회계', '서울');
INSERT INTO dept02 values(?, ?, ?);

SELECT * FROM dept02;

SELECT * FROM dept;


-- 0709 정리문제
-- 1) 회원테이블 만들기, 데이터 입력 : Member클래스
-- 2) sql 작성 및 확인 : insert into member VALUES
-- (회원번호, 아이디, 패스워드, 회원명, 권한, 포인트, 등록일)

SELECT * FROM MEMBER;
DROP TABLE MEMBER;

CREATE TABLE member(
	mno number PRIMARY KEY,
	id varchar2(30),
	pass varchar2(20),
	name varchar2(50),
	auth varchar2(20),
	point number,
	regdte date
);

CREATE SEQUENCE member_seq
	START WITH 1000
	MINVALUE 1000
	MAXVALUE 9999;
	
SELECT member_seq.nextval FROM dual;

INSERT INTO MEMBER values(member_seq.nextval, 'higirl', '8888', '홍리나', 'admin', 2000, sysdate);

SELECT * FROM MEMBER;


-- 수정처리
-- 1. 수정구문, emp02 
SELECT * FROM emp02;

UPDATE emp02
	SET ename = '',
		job = '', 
		mgr = 7839,
		to_char
		
SELECT * FROM dept02;
