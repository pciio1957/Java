
/*
#조인
1. 하나의 SQL 명령문에 의해 여러 테이블에 저장된 데이터를
	한번에 조회할 수 있는 기능을 말한다.
2. 관계형 데이터베이스 분야의 표준으로 자리잡고 있다.
3. 두개 이상의 테이블을 결합한다는 의미이다.

#조인 사용 예시
(1) 사원 정보 테이블에서 해당 관련 부서 정보를 가지고 와서
	부서번호 정보를 통해서 부서정보를 출력할 때
-> 조인이 필요하지 않은 경우
	
(2) 연봉이 3000이상인 사원의 정보와 부서정보를 한꺼번에 확인할때
-> 조인이 필요한 경우

*/

-- (1-1) 연봉이 3000이상인 사원이 있는 부서번호를 가져온다 -> 조인X
SELECT deptno
FROM emp 
WHERE sal >= 3000;

-- (1-2) 위에서 확인된 부서번호를 통해서 부서 테이블의 상세정보 확인  -> 조인X
SELECT *
FROM DEPT d 
WHERE deptno IN (10, 30);

-- (2-1) 연봉이 3000이상인 사원의 정보와 부서정보를 한꺼번에 확인 -> 조인O
SELECT e.*, d.*
FROM emp e, dept d 
WHERE e.deptno = d.deptno;

-- 더 자세하게
SELECT empno, ename, sal, e.deptno, dname, loc
FROM emp e, dept d 
WHERE e.deptno = d.deptno AND sal >= 3000;


-- select 선택 컬럼 : 중복된 컬럼만 alias 이름을 지정해도 된다. e.deptno
-- from 테이블명 별칭, 테이블명 별칭 : 조인할 테이블을 별칭과 함께 나열한다.
-- where 별칭.컬럼명 = 별칭.컬럼 : 두개 테이블에서 공통으로 연결한 컬럼명을
-- 			별칭과 함께 join해준다. inner join이라고 한다.
-- and 기타조건 : 그 외 조인한 내용의 데이터를 기준으로 조회 조건을 처리한다.

-- 응용1) 부서명, 사원명을 조인으로 출력하기
-- 응용2) 1/4분기에 입사한 사원의 부서명, 부서위치, 사원명, 분기를 출력하기
-- 응용3) 부서명이 'SALES'인 사원의 사원명과 부서명을 출력하기 (2조)

-- 일치하는 데이터만 출력
SELECT dname, ename -- 출력할 데이터 컬럼
FROM emp e, dept d  -- 테이블명
WHERE e.deptno = d.deptno; -- 조인관계에 있는 컬럼 지정 

SELECT dname, loc, ename, to_char(hiredate, 'Q')
FROM emp e, dept d 
WHERE e.deptno = d.deptno
and to_char(hiredate, 'Q') = '1';

SELECT ename, dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND dname = 'SALES';

SELECT *
FROM dept;

-- 공통되는 값을 가지는 컬럼은 반드시 소속된 테이블을 지정해야한다.
SELECT ename, dname, e.deptno
FROM emp e, dept d;

SELECT ename, dname, e.deptno
FROM emp e, dept d
WHERE e.deptno = d.deptno 
AND d.deptno = 10;


-- 응용1) 급여가 1000~3000 사이의 부서명, 사원명, 급여를 출력하기
-- 응용2) 부서위치(loc)별 평균급여를 출력하기(부서위치, 평균급여)
-- 응용3) 하반기 입사한 사람의 이름과 상/하반기 구분

SELECT dname, ename, e.sal
FROM emp e, dept d 
WHERE e.deptno = d.deptno 
AND sal>=1000 AND sal<3000;
-- AND sal BETWEEN 1000 AND 3000; 이렇게 처리가능 

SELECT loc, avg(sal)
FROM emp e, dept d 
WHERE e.deptno = d.DEPTNO 
-- 통합된 하나의 테이블에서 그룹 처리
GROUP BY loc;

-- 하반기 입사한 사람의 이름과 상/하반기 구분, 부서명, 부서위치
-- to_char(hiredate, 'Q') : 1, 2(상반기) , 3, 4 (하반기)
-- to_char(hiredate, 'MM') : 1~6(상반기), 7~12(하반기)
-- oracle 서버에서는 숫자형 문자열은 자동 형변환을 

SELECT ename "사원명", to_char(hiredate, 'Q'),
	CASE WHEN to_number(to_char(hiredate, 'Q')) <= 2 THEN '상반기'
		WHEN to_number(to_char(hiredate, 'Q')) > 2 THEN '하반기'
		-- else 로 하반기 처리도 가능 
	END "구분",
		dname "부서명", loc "부서위치"
FROM emp e, dept d 
WHERE e.deptno = d.deptno
AND to_char(hiredate, 'Q') >= 3;


-- 응용4) 부서이름별 최근에 입사한 사람의 입사일을 출력하기 (부서이름, 최근입사일)
-- 응용5) 전체 평균연봉을 확인하고, 평균연봉이상은 상급, 미만은 하급으로 나누어
--		부서명, 사원명, 연봉, 연봉구분을 부서번호가 10, 20인 경우를 출력하기(6조)

-- 4. 실행안됨
SELECT dname "부서이름", hiredate "입사일"
FROM emp e, dept d 
WHERE e.deptno = d.deptno 
GROUP BY dname
HAVING max(hiredate);

-- 날짜에서도 최근과 최초를 알수있다. 
SELECT max(hiredate) "최근", min(hiredate) "최초"
FROM emp;

-- emp 테이블에는 부서번호밖에 없음 
SELECT deptno, max(hiredate) "부서별 최근입사일"
FROM emp 
GROUP BY deptno;

-- 부서이름을 이용하기 위해서는 dept 테이블과 join해야함
-- 두개의 테이블을 조인관계 안에서 group 처리
-- 풀이답
SELECT dname "부서명", max(hiredate) "최근입사일"
FROM emp e, dept d 
WHERE e.deptno = d.deptno
GROUP BY dname;


-- 응용6) 부서위치별(loc), 최초 입사한 사람의 입사일을 출력 
SELECT loc, min(hiredate)
FROM emp e, dept d 
WHERE e.deptno = d.deptno
GROUP BY loc;



-- 확인용
SELECT dname, to_char(hiredate, 'YYYY')
FROM emp e, dept d;

-- case when 조건1 then 데이터1
--		when 조건2 then 데이터2
--		else 데이터3
--	end

-- sal >= (select avg(sal) from emp) : select 안에 있는 subquery
SELECT avg(e.sal) "전체 평균연봉", 
	CASE WHEN sal > avg(sal) THEN '상급'
		ELSE '하급'
		END "연봉구분", dname, ename, e.sal 
FROM emp e, dept d 
WHERE e.deptno = d.deptno 
AND deptno IN (10,20);
						

-- 응용7) 부서이름, 팀(청/백), 이름을 출력하되 연봉이 3000미만일때
--		팀(청/백) : 사원번호가 홀수일때는 청, 짝수일때는 백팀으로 처리

SELECT dname, decode(MOD(empno,2), 0, '백팀', 1, '청팀') "팀", ename 
FROM emp e, dept d 
WHERE e.deptno = d.deptno 
AND sal < 3000;

SELECT *
FROM DEPT d 
WHERE deptno = 20;

SELECT ename, e.deptno
FROM emp e, dept d 
WHERE e.deptno = d.deptno;

-- emp테이블의 별칭 e로 설정하면 emp를 지칭한다
-- where emp.deptno = dept.deptno 
-- emp 테이블의 deptno와 dept테이블의 deptno를 연동해서
-- 두 테이블의 정보를 한번에 확인하기 위하여 사용한다. 

SELECT e.*, d.*
FROM emp e, dept d 
WHERE e.deptno = d.deptno;

-- 전체가 연결을 만들어 하나의 테이블로 사용할 수 있다
-- 1. select로 선택해서 보여주고자 하는 컬럼을 출력할 수 있다.
-- 2. where 조건을 통해서 조회 조건을 만들 수 있다
-- 3. 여러가지 함수나 group함수를 활용할 수 있다.

SELECT e.*, d.*
FROM emp e, dept d 
WHERE e.deptno = d.deptno
AND sal >= 2000;


-- #natural join
-- 테이블1 natural join 테이블2
-- 테이블1과 테이블2의 공통 컬럼을 자동으로 join 시켜서 처리해주는 
-- oracle에서 지원하는 코드이다.
-- sql : ANSI 방식의 sql표준과 + 각 DB 서버마다 지원하는 sql 

SELECT *
FROM emp NATURAL JOIN dept;

