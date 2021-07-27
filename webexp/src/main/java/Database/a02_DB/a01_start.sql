SELECT * FROM emp;
-- ctrl + enter : 밑에 결과가 나옴 

/*
#복사테이블 만들기 
create table 테이블명 
as select * from 복사할 테이블명; 	
*/

CREATE TABLE emp01
AS SELECT * FROM emp;
SELECT * FROM emp01;
-- 로딩할 특정 컬럼 지정 : SELECT 컬럼명1, 컬럼명2

SELECT empno, ename, job
FROM emp01;
-- 여기서 오류.. 해결

/*
 #select 명령문
 1. 테이블에 저장된 데이터를 검색하기 위한 명령문
 2. select 명령문에서 select 절과 from 절이 필수적
 3. 사용법
 	select 
 		* : 테이블에 있는 전체 컬럼
 		컬럼명1, 컬럼명2 : 해당 컬럼을 지정할 때
 		disticnt 컬럼명 : 중복되는 데이터를 삭제
 		from 테이블명 
 		where 조건;
 		
 */


-- 응용1) emp, dept, salgreade, bonus 테이블있는지 확인
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;
SELECT * FROM BONUS; 
-- bonus는 안에 아무것도 없는듯?? (데이터 아무것도 없다고 함)

-- 응용2) emp 테이블에 ename, job, hiredate, deptno 컬럼 검색
SELECT ename, job, hiredate, deptno
FROM emp;

/*
2. 컬럼명 별칭 처리하기
1) 기본형식
	select 컬럼명 as 별칭명,
		컬럼명 as 별칭명,
		컬럼명 별칭명,
		컬럼명 " 안 녕 하 세 요"
	from 테이블
	해당 테이블 구조 안에 있는 컬럼명이 별칭명으로 호출하여 출력한다
	별칭명은 공백으로 처리도 가능하다 
	별칭명에 공백이나 특수문자(한글포함)이 필요할 때 " " 로 감싸준다
	as는 alias의 줄인말 
 */

SELECT empno AS NO, ename AS name,
	job job01,
	hiredate "입사일 입니다"
FROM emp;

-- 중복배제 : 1개의 칼럼이 같지 않게 처리
SELECT DISTINCT deptno 
FROM emp;

-- 중복배제 : 2개 컬럼에서 같지 않게 처리 (겹치는 애들 제거함)
SELECT DISTINCT mgr, deptno
FROM emp;

-- 응용3) alias 형식으로 사원번호(empno), 사원명(ename), 관리자번호(mgr)
--		으로 출력처리하기 

SELECT empno AS "사원번호(empno)", 
		ename "사원명(ename)",
		mgr "관리자번호(mgr)"
FROM emp;

-- empno : 사원번호, ename : 사원명, job : 직책명
-- mgr : 관리자번호, hiredate : 입사일, sal : 급여,
-- comm : 보너스, deptno : 부서번호
SELECT * FROM emp;

-- deptno : 부서번호, dname : 부서명, loc : 부서위치
SELECT * FROM DEPT;

/*
#데이터와 산술연산자의 concatnate(문자열 연결) 처리
1. 컬럼에 있는 숫자형 데이터는 사칙연산자 처리가 가능하다(+, -, *, /)
2. 문자열 연결은 DB에서는 '문자열1'||'문자열2'로
	문자열 데이터를 표시하고 연결 처리를 한다
*/

SELECT empno, empno+1000 "empno+1000",
		empno*20 "empno*20",
		ename || '님은 회사원입니다!' msg,
		sal, comm, sal+comm "sal+comm"
FROM emp;

-- 응용4) 사원의 이름은 @@@입니다, 부서번호는 @@@입니다
-- 응용5) 사원명(부서번호), 급여의 10% 표시, 급여의 10%와 급여의 합산 출력
-- (2조)

SELECT '사원의 이름은 ' || ename || '입니다' msg,
		'부서번호는 ' || empno || '입니다' msg
FROM emp;

-- 풀이 원래 이렇게 하라고 하셨는데 내가 위로 풀어버림
SELECT '사원의 이름은 ' || ename || '입니다',
		'부서번호는 ' || empno || '입니다' msg
FROM emp;

SELECT ename || '(' || empno || ')',
		sal*0.1 "급여의 10%",
		sal+(sal*0.1) "급여합산"
FROM emp;

-- 응용6) 사원번호 empno이고, 급여는 연봉으로 sal 만원입니다. 
--		alias명은 "소개"

SELECT '사원번호 ' || empno || '이고, 급여는 연봉으로 ' 
		|| sal || '만원입니다' AS "소개"
FROM emp;


/*
 #select sql 명령문의 표준 형식
 select *|컬럼명 : 열(column)단위로 나타날 데이터
 from 테이블명 테이블별칭: 대상 테이블, 여러개가 있으면 as alias명으로 지정 가능
 where 조건문 : 행(row)단위로 나타나 데이터 필터링(filterring) 처리
 group by 그룹할 컬럼 지정 : 특정 컬럼 기준으로 합산, 갯수, 최대/최소값 나타냄
 having 그룹의 조건을 지정 : 그룹 컬럼의 조건을 지정할 떄 
 order by 정렬할 우선순위 컬럼 지정
 
 */

SELECT deptno, sal -- 컬럼 단위로 전체 행을 지정
FROM emp
WHERE sal >= 3000; -- 조건을 통해서 행단위로 필터링함

-- 그룹별로 가장 연봉이 많은 사람의 수를 체크한다
SELECT deptno, max(sal) "그룹별 최대연봉",
		count(*) "그룹별 건수"
FROM EMP 
GROUP BY deptno;
-- group by : 그룹할 컬럼 부서번호를 겹치지 않게 그룹화한 후 

-- deptno, sal 컬럼 단위로 전체 행을 지정
SELECT deptno, sal
FROM emp;

SELECT deptno, max(sal) "그룹별 최대연봉",
		count(*) "그룹별 건수"
FROM emp
GROUP BY deptno -- 그룹할 컬럼 부서번호를 겹치지 않게 그룹화한 후
HAVING max(sal) >= 3000; -- HAVING 그룹함수의 조건

SELECT deptno, sal
FROM emp
ORDER BY sal desc; -- 특정 컬럼 기준으로 순차정렬/역순정렬 
-- desc : 내림차순 정렬 


/*
#where 조건문 
1. 질의에서 필요한 관계대수(=, >=, <=, >, <)로 select의 컬럼에 대하여
 	row 단위로 조건에 해당한다.
2. 관계대수를 연결하는 and, or, subquery(중첩질의)를 통해서
	row단위를 필터링(filtering)한다.

*/

-- 연봉이 2000~4000 사이인 사원의 정보를 출력하세요
SELECT *
FROM emp
WHERE sal >= 2000 AND sal <= 4000;

-- 부서번호가 10인 데이터를 출력하세요
SELECT *
FROM emp
WHERE deptno = 10;

-- 응용1) job(직책)이 'salesman' 인 사원의 정보 출력하기
SELECT *
FROM EMP e
WHERE job = 'SALESMAN';

-- 응용2) sal이 2000 이상인 사원의 사원명, 급여, 부서번호 출력하기
SELECT ename, sal, deptno 
FROM EMP e 
WHERE sal >= 2000;

-- 응용3) 연봉이 1000~3000 이고 부서번호가 10인 사원의 사원번호, 사원명,
--		급여, 부서번호 출력하기
SELECT empno, ename, sal, deptno
FROM EMP e 
WHERE sal >= 1000 AND sal <= 3000 AND deptno = 10;

SELECT empno "사원번호", ename "사원명", 
		sal "급여", deptno "부서번호"
FROM EMP e 
WHERE sal >= 1000 AND sal <= 3000 AND deptno = 10;

/*

#비교연산자
1. != 
	not(조건문) : 해당 조건이 아닐때 

2. is not null : null이 아닐 때
	ex)  컬럼 = null(x) -> 컬럼명 is null
		컬럼 != null(x) -> 컬럼명 is not null

#논리연산자
1. or 
2. and 


 */

SELECT *
FROM emp
WHERE deptno = 20;


-- != 와 not은 같음 (=결과가 같다)
SELECT *
FROM emp
WHERE deptno != 20;

SELECT *
FROM emp
WHERE NOT(deptno = 20);

-- not()은 실제로 이렇게 사용 
-- 아래 조건과 같음(deptno != 20 or sal >= 30000);
SELECT *
FROM emp
WHERE NOT(deptno = 20 AND sal >= 3000);


SELECT sal, comm 
FROM emp 
WHERE comm = NULL; -- -> 원하는 NULL인 데이터가 보이지 않는다

SELECT sal, comm 
FROM EMP e 
WHERE comm IS NULL; -- -> 이렇게 해야 보인다. / null인 값 검색

SELECT sal, comm 
FROM EMP e 
WHERE comm IS NULL; -- -> 이렇게 해야 보인다. / NULL이 아닌 값 검색


-- emp 테이블 전체 내용 보기 
SELECT *
FROM emp;

-- 응용) comm이 null이 아니거나 부서번호가 10인 데이터 검색
SELECT *
FROM EMP e 
WHERE comm IS NOT NULL AND deptno = 10;