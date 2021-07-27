
/*

#테이블의 구조 변경
1. 개요
	테이블을 사용하다보면 여러가지 상황에 따라 테이블의 구조를 변경하는 
	경우가 발생한다. 테이블의 구조를 변경하는데 필요한 명령어를 파악하고
	테이블 구조의 변경시 발생하는 데이터 처리에 대한 내용 파악하기 
	
	- 유형
	컬럼의 추가, 삭제, 속성 변경, 제약조건 변경 등
	
	1) 컬럼 추가 
		alter table 테이블명
		add 컬럼명 데이터유형 [default 디폴트데이터, 제약조건]
		

*/

DROP TABLE emp14;

CREATE TABLE emp14
AS SELECT empno, ename, job, sal FROM emp;

SELECT * FROM emp14;

-- emp14 테이블에 address 컬럼 추가하는데 기본값은 '주소입력없음'
ALTER TABLE EMP14 
ADD address varchar2(20) DEFAULT '주소입력없음';

-- 응용) emp15로 부서명, 사원명, 직책, 급여로 복사테이블을 만들고
--		해당 테이블에 bonus 컬럼을 추가하고 default 데이터로 0을 입력하기 (3조)

DROP TABLE emp15;

CREATE TABLE emp15
AS SELECT dname, ename, e.job, e.sal 
FROM emp e, dept d 
WHERE e.deptno = d.deptno;

ALTER TABLE emp15
ADD bonus NUMBER DEFAULT 0;

SELECT * FROM emp15;


-- 컬럼 삭제 
-- alter table 테이블명 drop column 컬럼명;

SELECT * FROM emp15;

ALTER TABLE emp15
DROP COLUMN job;

-- 응용) 부서별 최고급여자의 테이블을 emp16으로 만들고
--		deptno 컬럼을 삭제처리하세요 (4조)
CREATE TABLE emp16
AS SELECT * FROM emp
WHERE (deptno, sal) IN (
	SELECT deptno, max(sal)
	FROM emp 
	GROUP BY deptno
); 

SELECT * FROM emp16;

ALTER TABLE emp16
DROP COLUMN deptno;

-- 조건용
SELECT *
FROM emp 
WHERE (deptno, sal) in (
	SELECT deptno, max(sal)
	FROM emp 
	GROUP BY deptno
);


