
/*

#인덱스란?
1. sql명령문 중에 주로 조회성 데이터의 처리 속도를 향상시키기 위해
	컬럼에 대해 생성하는 객체
2. 인덱스는 포인트를 이용해 테이블에 저장된 데이터를 랜덤 액세스하기 
	위한 목적으로 사용된다.
3. 인덱스가 필요한 경우
	1) where 절이나 join 조건절이 자주 사용되는 컬럼
	2) 전체 데이터 중에서 10~15% 이내의 데이터를 검색하는 경우 활용
	3) 두 개 이상의 컬럼이 where 절이나 조인 조건에서 자주 사용되는 경우
	4) 테이블에 저장된 데이터의 변경(입력, 수정, 삭제)가 드문 경우
	5) 열에 null값이 많이 포함된 경우 열에 광범위한 값이 포함된 경우

4. 형식
	create index 인덱스명
	on table명(컬럼명) ~14:13

*/

DROP TABLE emp33;

CREATE TABLE emp33 
AS SELECT * FROM emp;

SELECT * FROM emp33;

-- 데이터 딕셔너리를 통해서 index 정보 확인 : user_ind_columns
SELECT *
FROM USER_IND_COLUMNS 
WHERE table_name ='DEPT';

-- #인덱스 생성
-- create index 인덱스명 on 테이블(컬럼) 
CREATE INDEX idx_empno_emp33 
ON emp33(empno);


-- 응용) emp34 테이블에 empno를 index로 만든 후 
-- 데이터 딕셔너리를 통해 확인하기 (5조)

CREATE TABLE emp34 
AS SELECT * FROM emp;

SELECT * FROM emp34;

CREATE INDEX emp34
ON emp34(empno);

SELECT *
FROM user_ind_columns 
WHERE table_name = 'EMP34';


/* #인덱스의 종류
1. 일반 인덱스 : 데이터의 중복가능 인덱스
2. 고유 인덱스 : 유일한 값을 가지는 컬럼에 대해 생성하는 인덱스로 모든 인덱스 키는 
	테이블의 하나의 행과 연결되어있다. 
	- 기본 형식
		create unique index 인덱스명 
		on 테이블명(컬럼명)
3. 단일 인덱스 : 하나의 컬럼으로만 구성된 인덱스
4. 결합 인덱스 : 두 개 이상의 컬럼을 결합하여 생성하는 인덱스
	- 기본 형식
		create index 인덱스명
		on 테이블명(컬럼명1, 컬럼명2) 
5. 제약조건 가운데 프라이머리키는 자동으로 인덱스를 생성한다

#descending index 
1. 컬럼별로 특정한 컬럼의 정렬 순서를 별도로 지정하여 결합 인덱스를 생성하기 위한 방법을 말한다.
2. 형식
	create index 인덱스명 on 테이블명(컬럼명1 desc, 컬럼2 asc);

#함수기반 인덱스
1. 컬럼에 대한 연산이나 함수의 계산 결과를 인덱스로 생성하는 것을 말한다.
2. 함수 기반 인덱스는 insert, update시에 새로운 값을 인덱스에 추가한다.
3. 기본 형식
	create index 인덱스명 on 테이블(함수(컬럼));
	
*/

-- 고유인덱스 생성 
CREATE TABLE dept10
AS SELECT * FROM dept;

CREATE UNIQUE INDEX idx_dept10_deptno 
ON dept10(deptno);

SELECT *
FROM user_ind_columns 
WHERE table_name = 'DEPT10';


-- 응용) dept11 테이블을 복사테이블로 생성하고, dname을 고유인덱스로
--		생성한 뒤 확인하기 (6조)
DROP TABLE dept11;

CREATE TABLE dept11 
AS SELECT * FROM dept;

SELECT * FROM dept11;

CREATE UNIQUE INDEX idx_dept11_dname 
ON dept11(dname);

SELECT *
FROM user_ind_columns 
WHERE table_name = 'DEPT11';

DROP TABLE emp35; 

CREATE TABLE emp35 
AS SELECT ename, job, deptno, sal, hiredate FROM emp;

SELECT * FROM emp35;

-- 결합 인덱스 생성
CREATE INDEX idx_emp_ename_deptno 
ON emp35(ename, deptno);

SELECT *
FROM user_ind_columns 
WHERE table_name = 'EMP35';

-- 응용) 사원정보와 부서정보가 조인된 테이블에서 empno와 deptno를 제외한 
-- 	복사테이블 emp36을 생성하고 ename, dname이 결합된 결합인덱스를 
--	생성하고 확인하기 (1조)

DROP TABLE emp36;

SELECT * FROM emp;
SELECT * FROM dept;

CREATE TABLE emp36 
AS SELECT ename, job, mgr, hiredate, sal, comm, dname, loc 
FROM emp e, dept d
WHERE e.deptno = d.deptno;

SELECT * FROM emp36;

CREATE INDEX idx_emp36_ename_dname 
ON emp36(ename, dname);

SELECT *
FROM user_ind_columns 
WHERE table_name = 'EMP36';


-- descending index 작성하기 
CREATE TABLE empp37 
AS SELECT * FROM emp;

CREATE INDEX idx_emp37_deptno_ename
ON emp37(deptno DESC, ename asc);

-- desc로 인덱스를 하면 정렬의 우선순위로 먼저 데이터를 찾아준다
SELECT *
FROM user_ind_columns 
WHERE table_name = 'EMP37';

-- 응용) emp38을 deptno와 empno를 없애고 만들고 
-- 		ename은 역순위, job도 역순위로 인덱스 생성하기 (2조)

DROP TABLE emp38;

-- deptno와 empno가 없는 emp38 테이블 생성 
CREATE TABLE emp38 
AS SELECT ename, job, mgr, hiredate, sal, comm
FROM emp;

SELECT * FROM emp;
SELECT * FROM emp38;

-- ename과 job을 역순위로 인덱스 생성
CREATE INDEX idx_emp38_ename_job 
ON emp38(ename DESC, job desc);

-- 데이터 딕셔너리에서 확인
SELECT *
FROM user_ind_columns 
WHERE table_name = 'EMP38';


-- 함수기반 인덱스 생성하기 
CREATE TABLE emp39
AS SELECT * FROM emp;

CREATE INDEX uppcase_idx 
ON emp39(lower(ename));

SELECT *
FROM user_ind_columns 
WHERE table_name = 'EMP39';

SELECT *
FROM emp39
WHERE lower(ename) = 'king';


-- 응용) emp40 테이블을 만들고 문자열로 검색되는 모든 컬럼을 upper()함수가 적용된
--		함수기반 index로 만들기 (3조)
CREATE TABLE emp40
AS SELECT * FROM emp;

CREATE INDEX uppt_idx 
ON emp40(upper(ename), upper(job));

SELECT * FROM emp40;

SELECT *
FROM user_ind_columns
WHERE table_name = 'EMP40';

SELECT upper(ename), upper(job)
FROM emp40;