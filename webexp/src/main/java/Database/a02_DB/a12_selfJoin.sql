
/*
#Self Join
1. 개요 
	하나의 테이블내에 있는 컬럼끼리 연결하는 조인이 필요한 경우에 사용된다.
	조인 대상 테이블이 자신 하나라는 거 외에는 EQUI JOIN과 동일하다
	
2. WHERE절을 사용한 Self Join
	하나의 테이블에서 두 개의 컬럼을 연결하여 EQUI JOIN
	FROM절에서 하나의 테이블에 테이블 변명지정
	ex) 부서테이블에서 where 절을 사용하여 self join 처리 

3. 형식
	select a.*, b.*
	from 테이블1 a, 테이블1 b
	where a.컬럼1 = b.컬럼2

예시) 
empno : 모든 사원의 고유 번호
mgr :  해당 사원을 관리하는 관리자의 사원 번호

ex) 7369의 사원명은 SMITH이고 이 사원의 관리자번호는 7902
	7902의 사원번호 이름은 FORD로 처리된다. 
직원이라서 애널리스트 FORD의 관리자번호는 7566 해당 사람은 매니저이고
이 매니저의 관리자는 king으로 제일 높은 사람이 관리자.
그러니까 사수를 ? 나타내는 느낌

*/

SELECT *
FROM emp;

-- 사원정보와 이 사원의 관리자 정보를 출력하기 
SELECT e.empno, e.ename, e.mgr, m.empno, m.ename 
FROM emp e, emp m 
WHERE e.mgr = m.empno;

SELECT '사원번호 ' || e.empno || ' : ' || e.ename || 
	'의 관리자번호는 ' || e.mgr || '이고 관리자의 이름은 ' || m.ename || '이다'  msg 
FROM emp e, emp m 
WHERE e.mgr = m.empno;

-- 테이블 내의 두 개의 연관관계 컬럼을 join으로 지정한다


-- 응용) 연봉 @@@인 사원 @@@의 관리자 @@의 연봉은 @@@입니다. 
--		self join을 이용해 출력하기 (3조)
SELECT e.empno 사원번호, e.sal 사원연봉, e.ename 사원명, 
	m.empno 관리자번호, m.ename 관리자명, m.sal 관리자연봉
FROM emp e, emp m 
WHERE e.mgr = m.empno;

/*
위 계층 관계의 테이블을 이해했으면 아래와 같은 하나의 테이블 내에 
계층 관계가 있는 데이터를 처리해보기

1. 테이블 만들기
family 테이블 
no(번호) pos(역할) name(이름) parno(부모번호)
1		할아버지 	홍말순 		0
2 		아버지 	홍판서 		1 
3 		아들1 	홍진희 		2
4 		아들2 	홍길동 		2

2. 데이터 입력
sample 데이터를 3개 이상 입력하기

3. sql을 이용해서 @@@의 부모이름은 @@@이다 출력하기 (4조)

*/

CREATE TABLE family(
	NO NUMBER,
	pos varchar2(30),
	name varchar2(30),
	parno NUMBER
);

INSERT INTO family values(1, '할아버지', '홍말순', 0);
INSERT INTO family values(2, '아버지', '홍판서', 1);
INSERT INTO family values(3, '아들1', '홍진희', 2);
INSERT INTO family values(4, '아들2', '홍길동', 2);

DELETE FROM family;

SELECT * FROM FAMILY ;

SELECT f.name||'의 부모이름은 ' || m.name || '이다'
FROM family f, family m 
WHERE f.parno = m.no;