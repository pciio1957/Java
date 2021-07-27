
/*

#그 외의 subquery
1. table 자체에 대한 subquery

2. select 선택열에서 subquery 처리

*/

SELECT *
FROM (
	SELECT deptno, max(hiredate) hiredate
	FROM emp 
	GROUP BY deptno
) a, emp b 
WHERE a.hiredate = b.hiredate;


SELECT *
FROM (
	SELECT deptno, max(hiredate) hiredate
	FROM emp 
	GROUP BY deptno
) a, emp b 
WHERE a.hiredate = b.hiredate
AND a.deptno = b.deptno
ORDER BY a.deptno;

SELECT * FROM emp;

-- 중간에 서브쿼리에 해당하는 내용만 뽑아서 emp a로 지정해서 연관관계를 설정 
SELECT *
FROM (SELECT empno, deptno, sal
	FROM emp 
	WHERE sal BETWEEN 1000 AND 2000
) a, dept d 
WHERE a.deptno = d.deptno;


-- 응용1) 연봉이 2000~ 4000인 사원의 부서번호, 사원명, 사원번호, 이름의 
--		subquery를 하여 테이블과 부서테이블을 join하여 출력하기
-- 응용2) 부서별 최저 연봉의 사원정보와 부서정보를 join하여 출력하기

SELECT *
FROM (SELECT deptno, ename, empno
	FROM emp 
	WHERE sal BETWEEN 2000 AND 4000
) a, dept d 
WHERE a.deptno = d.deptno;

SELECT a.*, dname, loc
FROM (SELECT deptno, min(sal) misal
	FROM emp
	GROUP BY deptno
) a, dept d 
WHERE a.deptno = d.deptno;


-- 테이블 subquery 이해하기 위한 응용 문제 풀이
-- 응용1) 중복되지 않는 관리자 번호리스트 테이블과 사원테이블을
--		mgr, empno로 조인하여 관리자번호, 관리자명, 직책을 출력하기
-- 응용2) 부서별 최근 입사자 테이블과 사원테이블을 부서번호로 조인하여 출력하기
-- 응용3) 연봉인 3000~4000에 해당하는 사원 테이블과 부서정보 테이블을 조인하여 출력하기(4조)

-- 모르겠음 헝 위에 mgr만 틀림,, 
SELECT mgr, ename, job 
FROM (SELECT DISTINCT mgr
	FROM emp) a, emp b 
WHERE a.mgr = b.empno;

SELECT b.empno "관리자번호", ename, job
FROM (SELECT DISTINCT mgr
FROM emp) a, emp B 
WHERE a.mgr = b.empno;

SELECT *
FROM (SELECT deptno, max(hiredate) maxhire
	FROM emp 
	GROUP BY deptno) a, dept b 
WHERE a.deptno = b.deptno;


SELECT * FROM emp;

-- 0623 응용문제 풀기 : 테이블 subquery 연습예제
-- 1. 연봉이 3000이상인 사원정보 테이블1, 부서테이블2 조인하여 
-- 		사원명, 연봉, 부서명, 부서위치 출력
SELECT ename 사원명, sal 연봉, dname 부서명, loc 부서위치 
FROM emp e, dept d 
WHERE e.deptno = d.deptno 
AND sal >= 3000;

-- 서브쿼리를 이용한 예제라서 이렇게 작성해야함 
SELECT ename 사원명, sal 연봉, dname 부서명, loc 부서위치
FROM (SELECT *
	FROM emp 
	WHERE sal >= 3000) e, dept d
WHERE e.deptno = d.deptno; 


-- 2. 부서별 최근입사자 테이블1, 사원테이블2, 부서테이블3 조인하여 
--		부서명, 사원명, 입사일 출력하기 
SELECT c.dname, b.ename, b.hiredate 
FROM (SELECT deptno, max(hiredate) 
	FROM emp 
	GROUP BY deptno)a, emp b, dept c 
WHERE a.deptno = b.deptno 
AND a.deptno = c.deptno;
-- 그룹화를 했는데 왜 두개씩 나오는지..? 
-- 조건설정을 덜 해서 데이터가 많이 나오는 거였음 

-- 풀이(조건설정이 덜 됨)
SELECT deptno, max(hiredate) mhire
FROM emp 
GROUP BY deptno; -- 첫번째 테이블

-- 공통컬럼일때는 반드시 alias이름을 설정한다. 
-- 개별컬럼일 떄는 테이블 alias를 생략할 수 있다.
-- 테이블간의 join은 공통 컬럼을 파악하여 해당 컬럼간의 조인을 처리한다.
SELECT dname 사원명, ename 부서명, b.hiredate 입사일
FROM (SELECT deptno, max(hiredate) mhire
	FROM emp 
	GROUP BY deptno) a, emp b, dept c 
WHERE a.deptno = b.deptno -- 먼저 a, b를 연결
AND a.mhire = b.hiredate -- 구한 값의 같은걸 연결하기 위해서 연결
AND b.deptno = c.deptno; -- 부서이름을 뽑아내기 위해서 b, c 연결 

-- 3. 분기별 최고급여자 테이블1, 사원테이블2를 조인하여
--		분기, 사원명, 급여 출력하기 (6조)
SELECT to_char(hiredate, 'Q'), ename 사원명, sal 급여
FROM (SELECT deptno, to_char(hiredate, 'Q') 분기, max(sal) mxsal
	FROM emp 
	GROUP BY 분기) a, emp b 
WHERE a.deptno = b.deptno;


-- 풀이 (alias 사용이랑 조건설정이 잘못됨)
SELECT to_char(hiredate, 'Q') part, max(sal)
FROM emp 
GROUP BY to_char(hiredate, 'Q');-- 첫번째 테이블 

SELECT part, ename, b.sal
FROM (SELECT to_char(hiredate, 'Q') part, max(sal) sal
		FROM emp 
		GROUP BY to_char(hiredate, 'Q')) a, emp b
WHERE a.part = to_char(b.hiredate, 'Q') 
AND a.sal = b.sal
ORDER BY part;


