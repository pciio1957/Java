
/*
#전날 내용 정리
1. 그룹함수의 기본 형식을 기술하기
	select 컬럼명, 그룹함수명1(), 그룹함수명2()...  
	from 테이블명
	where 조건
	group by 그룹 기준이 되는 컬럼명
	having 그룹함수의 조건지정;

2. 그룹함수의 종류와 내용을 기본예제를 통해서 기술하기
	종류 : count(), max(), min(), sum(), avg() 등.. 
	
	count() : 행의 개수를 구하는 함수
	max() : null 데이터가 있는 행을 제외한 모든 행의 최대값
	mim() : null 데이터가 있는 행을 제외한 모든 행의 최소값
	sum() : null 데이터가 있는 행을 제외한 모든 행의 합
	avg() : null 데이터가 있는 행을 제외한 모든 행의 평균값
	stddev() : null 데이터가 있는 행을 제외한 모든 행의 표준편차
	variance() : null 데이터가 있는 행을 제외한 모든 행의 분산

3. 전체 내용을 그룹함수로 처리하는 부분과 특정 컬럼의 데이터를 기준으로
그룹함수를 처리할때 코드의 차이점을 예제로 기술하기
	1) 전체 내용을 그룹함수로 처리하는 부분 : select 그룹함수로 작성하여
		해당 칼럼의 정보를 그룹함수로 처리해 출력한다. 조건을 줄때는 where에 작성.
	2) 특정 컬럼의 데이터를 기준으로 그룹함수 처리 : 그룹함수의 조건의 경우
		having에 작성해주어야 한다. 그 조건에 맞는 그룹함수가 처리된다.
		
-> 풀이
	1) 전체내용을 그룹함수로 처리 : 특정한 컬럼의 데이터를 기준으로 하지않고
		테이블내에 특정한 컬럼의 전체 데이터를 기준으로 함수처리한다.
		select count(*), sum(sal) 
		from emp; 
		- count(*) : emp 테이블의 전체를 카운트한 갯수 
		- sum(컬럼명) : emp 테이블의 특정한 컬럼의 전체 총계
	
	2) 특정 컬럼의 데이터를 기준 : 특정 컬럼명의 데이터를 기준으로
		데이터를 그룹으로 나누어서 처리하는 것을 말한다. 
		select deptno, sum(sal)
		from emp
		group by deptno;
		-> 부서번호 데이터 종류별로 급여의 합계를 처리하여 출력
		
		select deptno, sum(sal)
		from emp 
		group by deptno
		order by deptno; -- 정렬 추가


4. 입사월별 인원수를 출력하세요 (입사월, 인원)
	(아래에 풀었습니다)

5. 직책(job)별 최고 급여자가 2000이상인 경우를 출력하기 (직책, 최고급여)
	(아래에 풀었습니다)
	
6. 조인테이블의 연결이 없는 카티시안 조인과 equi join의 차이점을 기술하기
	equi join의 경우 두 개의 테이블에서 공통되는 컬럼을 조건으로 
	연결해줘야한다. 그렇게 되면 두 개의 테이블의 데이터를 모두 사용가능하다.  

	->
	카티시안 조인 : 테이블간의 공통 컬럼 연결없이 조회처리한다.
		데이터건수가 테이블건수 X 테이블건수로 나타난다.
	equi joim : 테이블간의 공통 컬럼으로 연결하여 해당 내용을 조회 처리한다.
		데이터건수는 두 테이블간의 데이터의 연결된 것을 기준으로 나타난다.
		
	- 카티시안 조인
	select count(*)
	from emp, dept;
	
	- equi join
	select count(*)
	from emp e, dept d
	where e.daptno = d.deptno;
	

7. 급여가 2000~4000 사이의 사원의 번호, 이름, 부서명을 출력하기
	(아래에 풀었습니다)

8. non equi join 이란 무엇인가?
	조인하려는 두 개의 테이블의 값이 동일하지 않고 
	범위로서 join하는 방법을 말한다. 
	
	-> 두개의 테이블의 데이터를 비교하여 =(비교연산자)가 아닌 
	범위나 다른 형태로 데이터를 비교하여 join하는 것을 말한다.
	
	ex) 급여 등급 테이블과 사원테이블의 급여를 between으로 비교하는 것을 예시로 들수있다. 

9. salgrade의 1,2등급에 해당하는 사원 정보를 출력하기
	(아래에 풀었습니다)
	
*/

-- 2. 그룹함수의 종류 - 부서별 정보
SELECT count(ename) 인원수, max(sal) 최고급여, min(sal) 최저급여,
	sum(sal) 급여합, avg(sal) 급여평균 
FROM emp
GROUP BY deptno;

SELECT deptno, count(*), sum(sal), max(sal)
FROM emp 
GROUP BY deptno;

-- 4. 입사월별 인원수
SELECT to_char(hiredate, 'MM') 입사월, count(ename) 인원
FROM emp 
GROUP BY to_char(hiredate, 'MM')
ORDER BY 입사월; -- alias 적용해서 이렇게도 가능 (신기)

SELECT to_char(hiredate, 'MM')
FROM emp;

-- 응용1) 사원번호별 짝수/홀수인 사원의 건수를 출력
-- 응용2) 입사 분기별 건수 출력하기

-- 아 홀수, 짝수로 데이터나누는데 이름을 출력하라고 해서 오류난듯..
-- decode(mod(empno,2), 0, '짝수', '홀수')
SELECT decode(MOD(empno,2), 0, '짝수', 1, '홀수') 구분, count(*) 건수
FROM EMP e
GROUP BY MOD(empno, 2);

SELECT mod(empno, 2), count(*)
FROM emp 
GROUP BY mod(empno, 2);

SELECT to_char(hiredate, 'Q') 분기, count(*) || '건' "건수"
FROM EMP e 
GROUP BY to_char(hiredate, 'Q')
ORDER BY to_char(hiredate, 'Q');

-- 5. 직책별 최고 급여자가 2000이상인 경우 출력
-- group by의 모든 내용을 표시를 해야함 
SELECT job 직책, max(sal) 
FROM emp 
GROUP BY JOB 
HAVING max(sal) >= 2000;

-- 7. 급여가 2000~4000 사이의 사원의 번호, 이름, 부서명 출력
SELECT empno 사원번호, ename 사원명, dname 부서명
FROM emp e, dept d 
WHERE e.deptno = d.deptno 
AND sal BETWEEN 2000 AND 4000;

-- 9. salgrade
SELECT ename 사원명, sal 급여, grade 등급
FROM emp e, salgrade s 
WHERE sal BETWEEN losal AND hisal
AND s.GRADE IN (1, 2);

SELECT * FROM SALGRADE s ;

SELECT e.*, grade
FROM emp e, salgrade s 
WHERE sal BETWEEN losal AND hisal 
AND grade IN (1,2);
