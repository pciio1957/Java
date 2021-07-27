
/*
#merge
1. 한번에 조건에 따라 여러가지 DML을 분기적으로 사용될 때
	사용하는 명령어로 오라클에서 지원하고 있는 sql이다
2. 예제
	조건문을 이용해서 해당 테이블의 특정한 컬럼값이 있으면 update 구문을 처리하고 
	데이터가 없으면 insert 구문을 처리하는 sql을 예시로 들어본다. 
	1) 기본형식
	merge into 테이블 a
	useing 테이블 b
	on 테이블 a와 테이블의 b의 특정 컬럼의 데이터 비교 
	when matched then 해당 데이터가 있는 경우 
		update set : 수정처리
	when not matched then 
		insert values : 등록처리 
		
		
#두 개의 테이블 비교 처리
	MERGE INTO emp36 s 
	USING emp35 t 
	ON (s.empno = t.empno) 
	WHEN MATCHED THEN 
		UPDATE SET  s.ename = t.ename, 
					s.job = t.job,
					s.sal = t.sal
	WHEN NOT MATCHED THEN 
		INSERT (empno, ename, sal, deptno) 
		VALUES (t.empno, t.ename, t.sal, t.deptno); 
		
		
#가상테이블(dual)
1. 가상테이블 dual을 이용해서 외부에서 입력된 데이터가 있을 때는 update 처리
	없을 때는 insert 처리 
	
	// 사원정보를 입력할 때 key인 empno가 있을 때는 나머지 정보는 수정처리
		없을 때는 입력처리 
		merge into emp36 s
		using dual 
		on (s.empno = 8001) -- 외부에서 form으로 데이터를 입력하는 경우
		when matched then
			update set s.ename = '마길동' ,
						s.job = '사원',
						s.sal = 5000,
						s.deptno = 10
		when not matched then
			insert (empno, ename, job, sal, deptno)
			values (8001, '마길동', '사원', 5000, 10);



*/

CREATE TABLE emp35
AS SELECT * FROM emp;

DROP TABLE emp36;

-- 데이터가 없어서 조건 변경 : 연봉이 1000~ 2000 사이 
CREATE TABLE emp36
AS SELECT * FROM emp 
WHERE sal BETWEEN 1000 AND 2000;

SELECT * FROM emp35;
SELECT * FROM emp36;

-- where가 따로 필요없음 on으로 조건을 줬기때문
-- when matched then : emp36과 emp35 컬럼에 empno가 동일한 경우 
-- merge into emp36 s : 수정 내지, 입력 대상이 되는 테이블은 emp36
-- using emp35 t : emp36을 변경/입력위해서 조건을 처리할 테이블은 emp35
-- 즉 emp36의 특정컬럼을 수정하는 것임 
MERGE INTO emp36 s 
USING emp35 t 
ON (s.empno = t.empno) 
WHEN MATCHED THEN 
	UPDATE SET  s.ename = t.ename, 
				s.job = t.job,
				s.sal = t.sal
WHEN NOT MATCHED THEN 
	INSERT (empno, ename, sal, deptno) 
	VALUES (t.empno, t.ename, t.sal, t.deptno);
-- 즉 emp35의 특정 컬럼을 emp36의 특정 컬럼에 입력 처리 
-- emp36 테이블을 조회해보면 앞의 데이터는 다 들어가 있는데 밑에 설정한건 설정값만 들어감


-- 응용) emp37 테이블을 emp의 부서번호가 20인 데이터를 기준으로 생성하고
--		emp37테이블을 수정/등록하되 emp의 사원정보가 있으면 
--		사원명, 급여, 부서정보를 수정하고 
-- 		그 외는 사원정보의 사원번호, 사원명, 급여, 부서정보를 입력하세요

CREATE TABLE emp37
AS SELECT * FROM emp
WHERE deptno = 20;

DROP TABLE emp37;

SELECT * FROM emp37;

-- 일치하는 정보가 있으면 정보 수정하고 없으면 추가해라.
-- 근데 일치하는 정보가 있으면 사원명, 급여, 부서번호를 update하는데
-- on에 empno가 있어서 제외했는데 set에 추가해야하는지 마는지????
-- >>>> 사원번호를 수정하는거에서 제외함.. 조건이라서 그런가?! 기준이라서

-- s.sal = t.sal 하면 sal의 10배인 값이 emp37에 들어감 
MERGE INTO emp37 S 
USING emp t 
ON (s.empno = t.empno) 
WHEN MATCHED THEN 
	UPDATE SET s.ename = t.ename,
				s.sal = t.sal, 
				s.deptno = t.deptno
WHEN NOT MATCHED THEN 
	INSERT (empno, ename, sal, deptno) 
	VALUES (t.empno, t.ename, t.sal, t.deptno);
	

-- 응용2) 상반기에 입사한 데이터를 emp기준으로 emp38 테이블을 만들고
--		empno38 테이블에 사원번호 기준으로 직책/관리자/입사일(올해기준)/급여를 수정하고
--	 	해당 데이터가 없으면 사원번호, 사원명, 직책, 입사일(현재시간), 급여, 부서번호를 입력처리하기 (6조)

-- 상반기 데이터만 담은 테이블 
CREATE TABLE emp38
AS SELECT * FROM emp 
WHERE to_char(hiredate, 'MM') BETWEEN 1 AND 6;

SELECT * FROM emp38;

-- 현재년도 + 입사월일 : to_date(to_char(sysdate, 'YYYY') || to_char(hiredate, 'MMDD'), 'YYYYMMDD')
MERGE INTO emp38 s 
USING emp o
ON (s.empno = o.empno) 
WHEN MATCHED THEN 	
	UPDATE SET s.job = o.job, 
			s.mgr = o.mgr,
			s.hiredate = 
			to_date(to_char(sysdate, 'YYYY') 
			|| to_char(hiredate, 'MMDD'), 'YYYYMMDD'),
			s.sal = o.sal
WHEN NOT MATCHED THEN 	
	INSERT (empno, ename, job, hiredate, sal, deptno)
	VALUES (o.empno, o.ename, o.job, sysdate, o.sal, o.deptno);
	

-- 현재 연도와 hiredate의 월일
SELECT to_char(sysdate, 'YYYY') "현재연도",
	to_char(hiredate, 'MM') "월",
	to_char(hiredate, 'DD') "일"
FROM emp;

-- 마길동 > 오길동(내용바꿔서) > 오길동(내용바꿔서)
-- 이미 있으면 수정하고 없으면 추가하는 것
merge into emp36 s
using dual 
on (s.empno = 8001) -- 외부에서 form으로 데이터를 입력하는 경우
when matched then
	update set s.ename = '오길동',
				s.job = '차장',
				s.sal = 7000,
				s.deptno = 20
when not matched then
	insert (empno, ename, job, sal, deptno)
		values (8002, '오길동', '차장', 7000, 20);
		
	
-- 응용) 변경/입력 대상 테이블은 emp37
-- 		데이터 9001, 마길동, 신입, 현재일입력, 3500, 30을 입력/수정처리하세요
-- 		입력된 내용과 수정된 내용 확인하기 (6조, 1조)
	
MERGE INTO emp37 e
USING dual
ON (e.empno = 9001)
WHEN MATCHED THEN 	
	UPDATE SET e.ename = '마길동',
				e.job = '대리',
				e.hiredate = sysdate,
				e.sal = 4500,
				e.deptno = 20
WHEN NOT MATCHED THEN 
	INSERT (empno, ename, job, hiredate, sal, deptno)
	VALUES (9001, '마길동', '대리', sysdate, 4500, 20);
	
SELECT * FROM emp37;


-- 데이터 무결성
SELECT *
FROM emp;

SELECT * 
FROM dept;