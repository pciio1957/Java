
-- 5. 월단위로 추가하거나 두 날짜 사이의 개월수를 확인하는 함수
SELECT months_between(sysdate, hiredate) "근무개월수",
	add_months(hiredate, 4) "입사3개월후날짜"
FROM emp;

-- month 기본으로 해서 함수사용
-- add_months(컬럼, 추가할 개월수)
-- months_between(비교컬럼1, 비교컬럼2)

-- 6. 절삭/반올림/올림하는 경우 
/*
months_between함수처럼 계산을 하고나면 소숫점이하로 데이터를 표현할 때가 있다.
개월수나 연차를 나타낼때에는 소숫점이하는 필요없기 때문에 절삭처리를 한다.


-- 
날짜데이터의 경우 +1 : 날짜데이터는 1일을 기준으로 시간데이터는 소숫점으로 표기된다. 
월단위 처리 메소드를 통해서는 월을 1을 기준으로 그 이하의 데이터는 소숫점으로 표기된다.
floor() : 무조건 정수로 절삭처리 
trunc(데이터, 자리수) : 해당 자리수로 절삭처리 
round(데이터, 자리수) : 해당 자리수로 반올림처리
ceil() : 정수로 올림처리 

*/

-- 7. 3/4분기에 입사한 사원의 이름과 입사연월일 분기 출력
SELECT ename, hiredate, to_char(hiredate, 'Q"/4"') "분기"
FROM emp 
WHERE to_char(hiredate, 'Q') = '3';

-- 
SELECT ename, to_char(hiredate, 'YYYY/MM/DD') "입사년월일"
FROM emp 
WHERE to_char(hiredate, 'Q') = '3';
-- 8. nv1, nv2, nullif 함수의 차이점 기술하기
/*
nvl(데이터, null값일 때, 처리할 데이터) : 해당 칼럼에서 데이터가 null인경우에만 값을 할당해주는 함수
nvl2(데이터, null이 아닐 때 처리할 데이터, null일때 처리할 데이터) : 해당 칼럼의 데이터가 null이거나 null이 아닌 경우에 값을 할당해주는 함수
nullif(데이터1, 데이터2) : 할당된 두 데이터를 비교하여 동일하면 null을 반환하고 아니면 
	데이터1을 반환한다.
*/

-- nvl(컬럼명, 해당컬럼이 null일때 데이터)
-- nvl2(컬럼명, null이 아닐때 데이터, null일때 데이터)
-- nullif(비교1, 비교2) : 두개 컬럼이 동일할 때 null을 리턴 
--			그외는 비교1데이터 리턴

-- 9. decode와 case함수의 기본형식 
SELECT ename 사원명, decode(MOD(empno, 2), 0, '짝수', '홀수') 짝홀수
FROM emp;

SELECT CASE WHEN mod(empno,2) = 0 THEN '짝수'
			WHEN mod(empno,2) = 1 THEN '홀수'
		END 짝홀수, ename 사원명
FROM emp;

-- decode(컬럼, 케이스1일때, 출력할 데이터1, 그외의 출력데이터2)
--		짝수의 케이스를 지정해서 해당 데이터일때 switch case와 비슷한 구조로 되어있다. 
-- case 컬럼 
-- 		when 케이스1 then 처리할 데이터
--		when 케이스2 then 처리할 데이터
--		else 그외에 경우 처리할 데이터
--	end 
-- case when 비교|논리 then 처리할 데이터 
-- 		..
--		else 그 외 경우 처리할 데이터
--	end 



-- 10. 그룹함수를 이용해 job의 갯수 중복제거로 표시

SELECT DISTINCT count(job), JOB
FROM emp 
GROUP BY job;

-- 직책별 데이터 건수
SELECT job, count(job)
FROM emp 
GROUP BY job;

-- 직책의 전체 데이터 건수
SELECT count(job)
FROM emp;

-- 중복을 제외한 job의 갯수
SELECT count(DISTINCT job)
FROM emp;


-- 11. 부서별 최고 연봉자가 3000이상인 부서
SELECT *
FROM emp 
GROUP BY deptno
HAVING max(sal) >= 3000;

-- 그룹화를 하고 그 그룹화로 나오는 데이터만 출력해야 제대로 실행됨
-- 그룹화되서 이름이나 개인으 ㅣ정보는 못보는데 개인정보 출력하라고 해서 안됨
SELECT deptno, max(sal) 
FROM emp 
GROUP BY deptno
HAVING max(sal) >= 3000;

SELECT a.*
FROM (SELECT deptno, max(sal)
	FROM EMP e 
	GROUP BY DEPTNO 
	HAVING max(sal)>=3000) a, dept b 
WHERE a.deptno = b.deptno;

SELECT * FROM dept;

-- 응용1) 분기별 최고 급여자가 2000이상으로 소속된 부서정보를 출력하기 (1조)
SELECT d.deptno 부서번호, dname, loc 
FROM (SELECT max(sal)
	FROM emp 
	GROUP BY to_char(hiredate, 'Q')
	WHERE max(sal) >= 2000) a, dept d
WHERE a.deptno = d.deptno;

-- 풀이
-- 1) 분기별 최고 급여자
SELECT to_char(hiredate, 'Q') 분기, max(sal) 최고급여
FROM emp 
GROUP BY to_char(hiredate, 'Q')
HAVING max(sal) >= 2000; 

-- 2) 부서정보와 join된 사원테이블
SELECT *
FROM emp e, dept d 
WHERE e.deptno = d.deptno;
-- 분기별 최고 급여자와 부서정보와 join된 사원테이블을 조인관계를
-- 설정하여 부서정보를 출력해야한다.

-- 3) 위의 두 테이블을 조인해야하는데 모르겠음 ㅎ 
SELECT d.*
FROM (
	-- 우선 분기별 최고 급여자를 뽑아낸 후 // 해당 테이블에서 부서정보를 뽑을 수 없음
	-- 분기별 최고 급여자 -> 사원정보를 통해서 -> 부서정보 
	-- 1) 분기별 최고 급여자 추출 : 사원정보(분기정보, 급여정보를 조인)
	-- 2) 사원정보와 부서정보 조인 : 부서번호로 조인 
	SELECT to_char(hiredate, 'Q') q, max(sal) msal
	FROM emp 
	GROUP BY to_char(hiredate, 'Q')
	HAVING max(sal) >= 2000) a, emp e, dept d 
WHERE a.q = to_char(e.hiredate, 'Q') -- 사원정보에서 분기정보 조인
AND a.msal = e.sal -- 사원정보에 급여정보를 조인 
AND e.deptno = d.deptno; -- 사원정보와 부서정보 조인

-- 12. 급여가 2000~3000 사이의 부서명, 사원명, 급여 출력 (기본조인)
SELECT dname 부서명, ename 사원명, sal 급여
FROM emp e, dept d 
WHERE e.deptno = d.deptno
AND sal BETWEEN 2000 AND 3000;


-- 13. 서브쿼리 종류
/*
	(1) where 조건 결과를 통한 subquery
		1) 단일 데이터 subquery
			select * 
			from emp 
			where sal = (select max(sal) from emp);
		2) 다중 데이터 subquery
			selectt * 
			from emp 
			where (deptno, sal) in (
				select deptno, max(sal)
				from emp 
				group by deptno 
			);
	(2) 테이블 subquery 
		select *
		from (select * from emp where sal>3000) e,
			(select * from dept where deptno = 10) d
		where e.deptno = d.deptno;
	(3) select subquery
		select (select max(sal) 
				from emp
				where deptno = a.deptno) "소속부서최고급여", 
			a.*
		from emp a;
*/


-- 14. 2등급
SELECT e.ename, e.sal, s.grade 
FROM emp e, salgrade S  
WHERE sal BETWEEN losal AND hisal
AND grade = 2;