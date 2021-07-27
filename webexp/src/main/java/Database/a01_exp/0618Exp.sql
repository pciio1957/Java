
/*

# 전날 정리 문제
1. 일반 조인과 outer join의 차이점을 기술하세요.
	일반 Join은 테이블 간의 공통 컬럼을 기준으로 데이터를 조인하여 출력하는 것을 말하는데
	outer Join은 테이블간의 공통데이터가 없는 경우에도 특정한 테이블의 데이터는 
	null로 표기하여 출력처리하는 것을 말한다. 
	기준이 되는 테이블의 데이터를 확인하여 연결여부를 전체 보기 위한 내용이다.
	
2. outer join의 기본문을 dept, emp를 예제로 기술하세요.
	(아래)

3. self 조인이 무엇인지 emp 테이블의 empno, mgr을 기준으로 설명하세요.
	같은 테이블 내부에 존재하는 컬럼과 컬럼끼리의 JOIN관계를 설정하는 것을 말한다.
	두개의 컬럼에 특정한 연관관계가 있을 때 가능하다.
	일반적으로 계층형 sql에서 주로 활용된다.
	emp 테이블의 관리자번호(mgr)은 사원번호(empno)와 연관관계가 있다.
	
	
4. self 조인을 활용하여 사원명(부서명)의 관리자는 관리자명(부서명)을 출력하세요.
	(아래)
	
5. subquery의 개념을 정리하고, 1/4분기 최고 급여자를 예제로 출력처리하세요.
	sql의 포함관계에서 sql을 다시 처리하여 subquery의 결과값을 기준으로
	다시 main query를 수행시키는 것을 말한다. 
	(예제 아래)
	
	#subquery
	1. 단일결과 데이터처리 : 비교연산자(=, >=, >, <, <=, !=)
		subquery가 하나의 결과값으로 나올때 처리한다.
		select *
		from 테이블명
		where 컬럼 = (subquery);
		
	2. 다중결과 데이터처리 : in, exists, any, all
		결과값이 하나이상일 때 해당 다중의 결과를 기준으로 
		데이터를 처리할 때 활용된다
		1) 1개의 열을 기준으로 결과가 나올 때
			select *
			from 테이블명
			where 컬럼 in (subquery);
			- in의 경우 해당 컬럼의 데이터를 or로 연결해서 처리할 때 활용된다.
	
		2) 2개 이상의 열을 기준으로 결과가 나올 떄
			select *
			from 테이블명
			where (컬럼1, 컬럼2 ...) in (select 컬럼1, 컬럼2 ...);
			- 컬럼1 데이터와 컬럼2 데이터가 and로 나올 때를 기준으로 
			데이터를 로딩한다.
			
6. 3사분기에 입사한 사원들의 최소 연봉과 같은 사람을 출력하세요.
	(아래)
	
7. 분기별로 입사한 사람의 최고 연봉자들의 정보를 분기기준으로 정렬하여 출력하세요
	(아래) + 응용문제1, 2 (6조)
	
8. 직책별 최근 입사자 테이블, 사원테이블을 조인하여 사원 정보를 출력하세요. 
(테이블 subquery 활용)
	(아래) + 응용문제3 (5조)
	
8. emp테이블에서 컬럼job과 join할 테이블테이블 jobs라고 만들고 
   직책명 권한 직책등급으로 설정하여 처리하세요.
   데이터는 사원 대리 과장 차장 부장 입력하여 outer join되게 한후, 
   out join 결과 출력하세요
   
   

발표는 9:10분부터 시작

#각 조 별로 발표 내용에 대한 개선 및 도입 가능한 사항을 조별로 정리하여
발표 후 조장은 제출하기 

*/

-- 2. outer Join
-- null 값이 나올 수 있는 컬럼에 (+)를 표시한다
select e.*, d.*
from emp e, dept d
where e.deptno(+) = d.deptno; 


-- 3. seif join
SELECT e.ename 사원명, m.empno 관리자번호, m.ename 관리자명
FROM emp e, emp m 
WHERE e.mgr = m.empno;
	

-- 4. self join
SELECT e.ename|| '(' || e.deptno || ')의 관리자는 ' || 
	m.ename|| '(' || m.deptno || ')' show
FROM emp e, emp m 
WHERE e.mgr = m.empno;


-- 5. subquery, 1분기의 최고연봉자
SELECT *
FROM emp 
WHERE sal = (
	SELECT max(sal)
	FROM emp 
	WHERE to_char(hiredate, 'Q') = '1'
);


-- 6. subquery, 3분기의 최소연봉자
SELECT *
FROM emp 
WHERE sal = (
	SELECT min(sal)
	FROM emp 
	WHERE to_char(hiredate, 'Q') = '3'
);


-- 7. 분기별 최고연봉자 
SELECT to_char(hiredate, 'Q') 분기, max(sal)
from emp 
GROUP BY to_char(hiredate, 'Q')
ORDER BY 분기;

SELECT to_char(hiredate, 'Q') 분기, e.*
FROM emp e 
WHERE (to_char(hiredate, 'Q'), sal) IN (
	SELECT to_char(hiredate, 'Q'), max(sal)
	from emp 
	GROUP BY to_char(hiredate, 'Q')
)
ORDER BY 분기;
-- 분기별로 최대값을 기준으로 해당 데이터를 검색처리한다. 


-- 응용1) 직책별 최저연봉에 해당하는 데이터를 subquery로 출력하기
-- 응용2) empno를 짝홀수로 나눠 짝수/홀수별로 최고연봉자의 사원 정보를 나타내기(6조)

SELECT *
FROM emp 
WHERE (job, sal) in (
	SELECT job, min(sal) 
	FROM emp 
	GROUP BY job
);

SELECT * FROM emp;

SELECT decode(MOD(empno,2),0,'짝수',1,'홀수') 짝홀수, e.*
FROM emp e
WHERE (decode(MOD(empno,2),0,'짝수',1,'홀수'), sal) IN (
	SELECT decode(MOD(empno,2),0,'짝수',1,'홀수'), max(sal)
	FROM emp 
	GROUP BY decode(MOD(empno,2),0,'짝수',1,'홀수')
);

-- 풀이
SELECT decode(MOD(empno,2),0,'짝수',1,'홀수') 짝홀수, e.*
FROM emp e
WHERE (MOD(empno,2), sal) IN (
	SELECT MOD(empno,2), max(sal)
	FROM emp 
	GROUP BY MOD(empno,2)
);


-- 8.
SELECT *
FROM (
	SELECT job, max(hiredate) mhire
	FROM emp 
	GROUP BY job) a, emp b
WHERE a.job = b.job
AND a.mhire = b.hiredate;


-- 응용3) 입사분기별 최고급여 테이블과 사원테이블을 조인관계하여
--		입사분기별 사원정보를 출력하기 (5조)

-- 안에 가져오는 데이터를 연결을 시켜줘야하는 것
-- a.sal = m.sal만 설정하게 되면 같은 최고 급여가 있을 경우 같이 출력됨
-- 검색을 1분기, 4분기별로 추가하여 where 조건을 하는 경우에 문제발생함
SELECT to_char(hiredate, 'Q'), m.*
FROM (SELECT to_char(hiredate, 'Q') div, max(sal) sal
	FROM emp 
	GROUP BY to_char(hiredate, 'Q')) a, emp m 
WHERE a.div = to_char(hiredate, 'Q') 
AND a.sal = m.sal;



-- 9. 
SELECT ename, job
FROM emp; 

-- 간단하게 테이블 만드는 방법
CREATE TABLE jobs 
AS SELECT DISTINCT job, 
		'권한		' auth, 
		'   	'grade
FROM emp;

SELECT * FROM jobs;

-- join
SELECT e.ename, e.job, j.*
FROM emp e, jobs j 
WHERE e.job(+) = j.job;