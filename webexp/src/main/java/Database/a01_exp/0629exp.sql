
/*

#정리문제
1. emp30 복사테이블을 만들고 부서번호 10의 최대연봉을 사원번호 7521의 연봉으로 수정처리하기
2. emp55 복사테이블을 만들고 입사분기별 최고 급여자를 삭제 처리하기
3. merge의 기본 형식 2가지를 기본예제를 통해 설명하기
4. emp테이블의 1사분기에 입사한 사람을 기준으로 emp41테이블을 만들고
	emp테이블의 empno의 매칭기준으로 사원번호, 사원명, 직책명, 관리자번호, 입사일을 merge 처리하기
5. 변경/입력 대상 테이블은 emp37로
	데이터 8005, 김철수, 대리, 현재일입력, 3500, 300, 10을 merge를 통해 입력/수정처리하기 

~9:20분까지 제출

*/

-- 1. 
CREATE TABLE emp30
AS SELECT * FROM emp;

DROP TABLE emp30;

UPDATE emp30
	SET sal = (
			SELECT max(sal)
			FROM emp 
			WHERE deptno = 10)
WHERE empno = 7521;

SELECT * FROM emp30;


-- 2. 
-- where(컬럼1, 컬럼2) in (select 컬럼1, 컬럼2 from ...) 
-- 여러 컬럼과 여러 행을 처리할 때는 위와 같은 형식으로 다수의 컬럼을 나열하고 
-- in 구문을 활용한다. 
CREATE TABLE emp55
AS SELECT * FROM emp;

--입사분기별 최고 급여자를 삭제 처리하기
DELETE FROM emp55 
WHERE (TO_char(hiredate, 'Q'), sal) IN (
	select TO_char(hiredate, 'Q'),  max(sal) 
	FROM emp 
	GROUP BY to_char(hiredate, 'Q')
);

/*
3. Merge
	1) merge는 두 개 테이블을 병합해서 대상 테이블과 원본테이블의 데이터를
		동일하게 만드는 것을 처리할 수 있다.
	2) 형식
		(1) 두 개의 테이블 이용 : 데이터를 삽입/수정할 테이블과 기준이 되는 테이블을 선언
					두 테이블을 비교하여 테이블에 삽입/수정함
		(2) 가상테이블(dual) 이용 : 가상테이블인 dual을 이용해 외부에서 입력받은 데이터가
					입력/수정을 한번에 처리할 때 사용된다.
		
		merge into 테이블(변경/등록테이블) t
		using 테이블(기준테이블) o | dual
		on (t.기준컬럼 = o.기준컬럼)
		when matched then : on에 조건이 true 즉, 기준데이터가 있을 때
				update set 수정
		when not matched then : 없으면 추가
				insert 
				values 

*/

-- 형식1 : 두개의 테이블 이용하기
MERGE INTO emp55 s 
USING emp35 t 
ON (s.empno = t.empno) 
WHEN MATCHED THEN 
	UPDATE SET  s.ename = t.ename, 
				s.job = t.job,
				s.sal = t.sal
WHEN NOT MATCHED THEN 
	INSERT (empno, ename, sal, deptno) 
	VALUES (t.empno, t.ename, t.sal, t.deptno);
	
-- 형식2 : 가상테이블 사용하기
merge into emp55 s
using dual 
on (s.empno = 8001) 
when matched then
	update set s.ename = '오길동',
				s.job = '차장',
				s.sal = 7000,
				s.deptno = 20
when not matched then
	insert (empno, ename, job, sal, deptno)
		values (8002, '오길동', '차장', 7000, 20);

	
-- 4. 4. emp테이블의 1사분기에 입사한 사람을 기준으로 emp41테이블을 만들고
--	emp테이블의 empno의 매칭기준으로 사원번호, 사원명, 직책명, 관리자번호, 입사일을 merg

CREATE TABLE emp41 
AS SELECT * FROM emp 
WHERE to_char(hiredate, 'Q') = 1;

-- 사원번호는 위에 on으로 조건으로 사용하기 때문에 수정시 사용하지 못함 
MERGE INTO emp41 a
USING emp b
ON (a.empno = b.empno)
WHEN MATCHED THEN 
	UPDATE SET  a.ename = b.ename,
				a.job = b.job,
				a.mgr = b.mgr,
				a.hiredate = b.hiredate
WHEN NOT MATCHED THEN 	
	INSERT (empno, ename, job, mgr, hiredate)
	VALUES (b.empno, b.ename, b.job, b.mgr, b.hiredate);
	
-- 5. 

MERGE INTO EMP37 
USING daul
ON (s.empno = 8005)
WHEN MATCHED THEN 
	UPDATE SET s.ename = '김철수',
			s.job = '대리',
			s.hiredate = sysdate,
			s.sal = 3500,
			s.comm = 300,
			s.deptno = 10
WHEN NOT MATCHED THEN 	
	INSERT (empno, ename, job, hiredate, sal, comm, deptno)
	VALUES (8005, '김철수', '대리', sysdate, 3500, 300, 10);