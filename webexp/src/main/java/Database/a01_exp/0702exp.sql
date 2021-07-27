
/*

# 정리문제
1. 테이블 컬럼의 테이블 타입을 변경할 시, 제약사항을 기술하세요.
	 - 바꾸려고 하는 컬럼에 데이터가 있는지/없는지 확인
	 
	 1) 데이터가 없는 구조만 되어있는 경우 :  제약이 거의 없다
	 2) 데이터가 있는 경우 : 
	 		- 데이터 타입이 같은 경우 
	 		(1) 작은 데이터에서 큰 데이터로 변경 : 가능
	 		(2) 큰 데이터에서 작은 데이터로 변경 : 실제 데이터 저장 크기 안에서 가능 
	 			ex) 크기 설정을 varchar2(50)을 설정했으나 실제 데이터는 
	 				max(length(컬럼명))으로 확인하여 해당 크기 안에서 변경 가능하다.
	 
2. emp의 구조만 있는 emp12 테이블을 생성하고, 숫자형 컬럼을 문자형으로 변경하세요.
	(아래 풀이)
	
3. 테이블명과 컬럼명을 변경시키는 코드를 기술하세요.
	1) 테이블명 변경
		rename 테이블명 to 바꿀테이블명;
	2) 컬럼명 변경
		alter table 테이블명
		rename column 컬럼명 to 바꿀컬럼명;
		
4. 인덱스의 기본형식과 유형을 기술하세요.
	1) 기본형식 
		create index 인덱스명
		on 테이블명(컬럼명); 
	2) 유형 
		(1) 일반인덱스 : 데이터의 중복가능 인덱스(단일인덱스를 포함)
		(2) 고유인덱스 : 유일한 값을 가지는 컬럼에 대해 생성하는 인덱스로 모든 인덱스 키는 
				테이블의 하나의 행과 연결되어있다. 
				- 기본 형식
					create unique index 인덱스명 
					on 테이블명(컬럼명)
		(3) 단일인덱스 : 하나의 컬럼으로만 구성된 인덱스
		(4) 결합인덱스 : 두 개 이상의 컬럼을 결합하여 생성하는 인덱스
				- 기본 형식
					create index 인덱스명
					on 테이블명(컬럼명1, 컬럼명2...)
		(5) descending index (역방향 인덱스) : 컬럼별로 정렬 순서를 별도로 지정하여 
				결합 인덱스를 생성하기 위한 방법을 말한다.
				- 기본 형식
					create index 인덱스명 on 테이블명(컬럼명1 desc, 컬럼2 asc);
		(6) 함수기반 인덱스 : 컬럼에 대한 연산이나 함수의 계산 결과를 인덱스로 생성하는 것을 말한다.
				- 기본 형식
					create index 인덱스명 on 테이블(함수(컬럼)); 

5. emp38테이블에 index로 deptno(내림차순)와 empno(오름차순)로 중복 처리되게 하세요.
	(아래) 
	
6. user01/8888계정을 생성하고, 접속하여 테이블을 생성하세요.
	(아래) 
	
7. 부서정보가 함께 있는 부서명별 최고 급여자 사원 정보가 있는 emp13테이블을 만들고,
    mgr은 관리자명으로 데이터유형과 데이터를 변경 처리하세요.

중간 발표는 9:10부터 하겠습니다. 발표담당자 메시지주세요
~12:30분까지 제출하기 

각 조별로 발표 내용 확인하고 그 중에 우리 조에 도입해서 
우리 조의 코드나 발표내용을 발전할 수 있는 사항 분석하기 

*/

-- 2. 
DROP TABLE emp12;

CREATE TABLE emp12 
AS SELECT * FROM emp WHERE 1=0; 

SELECT * FROM emp12;

-- 숫자형 컬럼에서 문자형 컬럼으로 바꾸기
ALTER TABLE emp12 
MODIFY empno varchar2(30);

ALTER TABLE emp12 
MODIFY mgr varchar2(30);

ALTER TABLE emp12 
MODIFY sal varchar2(30);

ALTER TABLE emp12 
MODIFY comm varchar2(30);

ALTER TABLE emp12 
MODIFY deptno varchar2(30);


-- 3. 테이블명/컬럼명 변경하기 
RENAME emp12 TO emp12_copy;

ALTER TABLE emp12_copy
RENAME COLUMN sal TO salary;


-- 5. emp38 테이블의 정렬 인덱스 생성
DROP TABLE emp38;

CREATE TABLE emp38
AS SELECT * FROM emp;

CREATE INDEX idx_emp38_deptno_empno
ON emp38(deptno DESC, empno asc);


-- 6. user01/8888계정을 생성 후 접속하여 테이블 생성 
/*
1) 계정생성 : create user 계정명 identidied by 비밀번호;
2) session 권한 부여 : grant create session to 계정명;
3) 자원에 대한 사용 권한 부여 : grant resource to 계정명;
4) 계정의 테이블 스페이스 지정 : alter user 계정 defalut tablespace 테이블스페이스명;
5) 계정의 테이블 스페이스 용량 지정 :
	alter user 계정명 quota unlimeited on 테이블스페이스명; 
  
*/


CREATE USER user01 IDENTIFIED BY 8888; -- 1) 계정생성
GRANT create SESSION TO user01; -- 2) SESSION 권한 부여
GRANT resource TO user01; -- 3) 자원에 대한 권한 부여 

-- 4,5) 테이블 스페이스 지정
ALTER USER user01 default tablespace users;
ALTER USER user01 quota unlimited ON users;

-- cmd 접속 후 user01 계정과 연결한 후 아래 실행 (간단한 테이블 생성)
CREATE TABLE Product(
	pname varchar2(30)
);

grant CONNECT, RESOURCe, UNLIMTITED tablespace
	to himan2 identified by 9999;


-- 7. 부서정보가 함께 있는 부서명별 최고 급여자 사원 정보가 있는 emp13테이블을 만들고,
--    mgr은 관리자명으로 데이터유형과 데이터를 변경 처리하세요.

/*

#하는 순서
1) 부서정보가 함께 있는 부서명별 최고 급여자 사원정보가 있는 emp13 테이블 생성
2) 내부조인에 의해서 사원번호와 관리자명이 있는 테이블 생성 
3) emp13 테이블의 mgr update로 null 처리
4) emp13 테이블의 mgr varchar2(20)으로 변경
5) emp13 테이블의 mgr에 mgrtab의 empno를 기준으로 update 처리  
 * 이거보다 쉽게하는 방법은 복사테이블을 만들때 복사할 컬럼으로 하나 추가해서 옮기고 변경하기..
 * 
*/

DROP TABLE emp13;

CREATE TABLE emp13 
AS SELECT * FROM emp;

SELECT a.deptno, dname, max(sal)
FROM emp a, dept b
GROUP BY dname
WHERE a.deptno=b.deptno;


SELECT b.deptno, dname, max(sal)
FROM (
	SELECT a.detpno, max(sal)
	FROM emp) a, dept B 
GROUP BY dname
WHERE a.deptno = b.deptno;


-- 풀이.. 어려웡
DROP TABLE emp13;

SELECT dname, max(sal)
FROM emp e, dept D 
WHERE e.deptno = d.deptno
GROUP BY dname;

-- 조건이 and로 되어있는데 뒤에는 서브쿼리로 emp13테이블 생성 
CREATE TABLE EMP13 
AS SELECT e.*, dname, loc 
FROM emp e, dept d 
WHERE e.empno = d.deptno 
AND (dname, sal) IN (
SELECT dname, max(sal)
	FROM emp e, dept D 
	WHERE e.deptno = d.deptno
	GROUP BY dname
);

SELECT * FROM emp13;

-- 사원명과 관리자명 가져오기 
-- 2) 내부조인으로 직원의 관리자번호를 출력함 
SELECT e.empno, e.ename, e.mgr, m.ename 
FROM emp e, emp m 
WHERE e.mgr = m.empno;

-- 생성
CREATE TABLE mgrtab 
AS SELECT e.empno, m.ename
FROM FROM emp e, emp m
WHERE e.mgr=m.empno;

SELECT * FROM mgrtab;

-- 3) emp13 테이블의 mgr update로 null 처리 
UPDATE emp13 	
	SET mgr = NULL;

SELECT * FROM emp13;

-- 4) emp13테이블의 mgr varchar2(20)으로 변경
ALTER TABLE EMP13 
MODIFY mgr varchar2(20);

-- 5) emp13 테이블의 mgr에 mgrtab의 empno를 기준으로 update 처리
UPDATE emp13 a 
SET mgr = (
	SELECT ename 
	FROM mgrtab b 
	WHERE a.empno = b.empno
);

SELECT * FROM emp13;