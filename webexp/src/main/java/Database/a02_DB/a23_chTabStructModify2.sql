
/*
#테이블 이름 변경
rename 테이블명 to 변경할 테이블명;

#컬럼명 변경
alter table 테이블명
rename column 컬럼명 to 변경할 컬럼명;

*/

SELECT * FROM emp10;

-- 테이블 이름 변경
RENAME emp10 TO emp10_new;

SELECT * FROM emp10_new;

-- 칼럼명 변경
ALTER TABLE EMP10_NEW 
RENAME COLUMN empno TO NO;


-- 응용) 분기별 최고 연봉자의 테이블을 emp11로 만들고
-- 		해당 job은 데이터의 최대 크기로 확인하여 해당 크기 유형으로 변경하고
--		empno는 char(4)로 변경하여 만들고
--		테이블명을 emp_11 -> emp_upt, sal -> salary로 변경하기 (4조)

DROP TABLE emp11;

-- 분기별 최고 연봉자 테이블 emp11 
CREATE TABLE emp11
AS SELECT * FROM emp 
WHERE (sal, to_char(hiredate, 'Q')) IN (
	SELECT max(sal) sal, to_char(hiredate, 'Q')
	FROM emp 
	GROUP by to_char(hiredate, 'Q')
);

-- job 컬럼의 최대 크기 확인
SELECT max(LENGTH(job)) FROM emp11;

-- job 컬럼의 크기 변경
ALTER TABLE EMP11 
MODIFY job varchar(9);

-- empno 컬럼의 크기 변경
/*
empno는 문자를 넣을 수 있는 컬럼 추가 : empnos
empno와 문자형 empno컬럼의 복사테이블(생략가능) 만들고
empnos에 update로 데이터 수정
empno를 삭제 
empnos -> empno로 컬럼명 수정 

*/
CREATE TABLE emp_cpy
AS SELECT ename, to_char(empno) empno FROM emp11;

UPDATE emp11 
	SET empno = NULL;

SELECT * FROM emp11;

ALTER TABLE emp11 
MODIFY empno varchar2(4);

SELECT * FROM emp_cpy;

UPDATE emp_upt a
	SET empno = (
	SELECT empno
	FROM EMP_CPY b
	WHERE a.ename = b.ename
);

-- 테이블 이름 변경 
RENAME emp_upt TO emp_cpy;

RENAME emp11 TO emp_upt;

-- 테이블 컬럼명 변경
ALTER TABLE emp_upt
RENAME COLUMN sal TO salary;

SELECT * FROM emp_upt;

