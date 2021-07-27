
SELECT * FROM emp;

/*

#Between 구문
1. 컬럼명 between A and B
	동일한 결과 내용으로 컬럼명 >= A and 컬럼명 <= B
	
 */

-- sal가 1000에서 2000사이 데이터 출력
SELECT * FROM EMP e 
WHERE sal BETWEEN 1000 AND 2000;

-- 응용) empno가 7600에서 7900 사이의 데이터 출력
SELECT * FROM emp 
WHERE empno BETWEEN 7600 AND 7900;

/*

#null 데이터 처리
1. 데이터가 할당되지 않는 경우를 의미함
	' ' 공백으로 들어간 데이터와 숫자형인 경우 
	0으로 들어간 데이터와 차이가 있다는 것을
	반드시 확인해야 한다
2. 처리 내용
	1) 조건문 처리 (where)
		컬럼명 is null : 해당 컬럼에 데이터가 할당되지 않는 경우
		컬럼명 is not null : 해당 컬럼에 데이터가 할당된 경우 
	2) 함수 처리 nvl
		nvl(컬럼명, null일때 나올 데이터)
		숫자형 nvl(comm, 0) : 숫자형이 null일때 출력되는 값은 0
		문자형 nvl(ename, '') : 문자형이 null일때 출력되는 값 ''
	* 주의! : 컬럼과 null일 때 나올 데이터는 동일해야한다.
	* nvl(ename, 0) x : 해당 컬럼의 데이터 유형에 맞게 default 데이터를 할당해야 한다. 
	* nvl(comm, '') X 
	* nvl(''||comm, '') O : 숫자형의 데이터를 ''을 결합(||)해서 문자열로 만듬 
		
 */

SELECT * FROM emp;

-- comm이 null인 경우에 숫자가 안되기에 연산이 되지 않는다.
-- 이때 nvl을 활용하면 해당 내용에 대한 연산이 가능해진다.
SELECT sal, comm, sal + comm "합산",
		sal + nvl(comm,0) "합산2"
FROM emp;

-- 프로그램으로 처리하여 나타날 0과 null을 동일시하여 
-- 처리 조건에도   사용할 수 있다.
SELECT sal, comm 
FROM emp 
WHERE nvl(comm,0) != 0;


-- 응용1) 사원명과 관리자번호(mgr) - null 인경우 0으로 출력하기
-- null 경우가 1개 있는데 그 데이터를 0으로 표시
SELECT ename nvl(mgr, 0) mgr
FROM emp;

-- 응용2) 중복되지 않는 관리자번호를 출력하세요 - null이 아닌 경우만
-- (1조) 각 조별 전달시 진도 및 이해도 %를 표기해서 요청사항과 함께 전달  
SELECT *
FROM emp 
WHERE nvl(mgr, 0) != 0; -- XXX

-- 중복되지 않는 관리자 번호이므로 distinct 사용
SELECT DISTINCT mgr
FROM EMP e 
WHERE nvl(mgr, 0) != 0;


/*

#in 구문
1. 데이터는 or 조건에 관련된 내용은 이거나로 
	해당 조건 이외에 조건에 대한 내용을 논리적으로 
	처리해준다.
2. 이때 하나의 컬럼을 기준으로 많은 or 조건을 처리할 때
	효과적이고 간편하게 처리하기 위하여 in 구문을 제공한다.
	
 */

SELECT ename, deptno
FROM emp
WHERE deptno = 10 OR deptno = 20;

-- or 조건으로 특정 지정 컬럼을 처리할 수 있음
SELECT empno, ename, deptno
FROM emp
WHERE empno = 7369 OR empno = 7521 OR empno = 7654;

-- 많은 or 조건이 있을때 효과적으로 처리하기 위해서
-- 컬럼명 in (데이터1, 데이터2) : 해당 칼럼에 데이터1이거나 데이터2인 결과 출력 
SELECT empno, ename, deptno
FROM emp
WHERE deptno IN (10,20);

SELECT empno, ename, deptno
FROM emp
WHERE empno IN (7369, 7521, 7654);

-- 응용) job이 SALESMAN이거나 MANAGER인 경우 in 구문을 이용한 출력
SELECT *
FROM emp
WHERE job IN ('SALESMAN', 'MANAGER');

-- 위에 처럼 사용하는 경우도 있지만 많이 사용되는 방법은 아래와 같다
-- subquery : 수행된 결과값을 기준으로 다시 조회 조건을 처리하는 구문

-- 부서번호가 30번인 사원번호를 검색해서 그 사원번호에 해당하는 사원정보 처리
SELECT *
FROM EMP e
WHERE empno IN(
SELECT empno
FROM emp 
WHERE deptno = 30);

-- 연봉이 최고인 사람의 정보를 출력하세요
SELECT max(sal) -- 연봉이 젤 큰 사람
FROM emp ;

SELECT *
FROM emp 
WHERE sal IN (
	select max(sal)
	from Emp 
);

-- 부서별 최고 연봉자의 정보를 출력
SELECT *
FROM emp 
WHERE (deptno, sal) IN (
	select deptno, max(sal)
	from Emp 
);

-- 단일값이 명확한 경우에는 = (대입연산자)를 이용하여 처리한다.

SELECT *
FROM emp
WHERE sal = SELECT max(sal) FROM emp;


/*

#like 연산자를 이용한 keyword 조건 검색
1. 칼럼에 저장된 문자열 중에서 like 연산자에서 지정한 문자 패턴과
	부분적으로 일치하면 참이 되어 조건문에서 검색되게 하는 것을 말한다.
	ex) 사원명에 'A'라는 문자열을 포함하면 조회되도록 하라
		1) 위치 상관없이 검색 : 컬럼명 like '%A%'
		2) A로 시작하면 검색 : 컬럼명 like 'A%'
		3) N으로 끝나는 검색 : 컬럼명 like '%N'
		4) 자릿수 위치에 맞는 데이터 검색 :
			세번째 자리에 A가 나오는 데이터 검색 : 검색컬럼명 like '__A%'
	
*/

-- 'A'라는 문자열을 포함되면 조회되게 해라
SELECT *
from emp
WHERE ename LIKE '%A%';

-- 'A'로 시작하는 문자열을 조회하라
SELECT *
FROM emp 
WHERE ename LIKE 'A%';

-- 'N'으로 끝나는 문자열을 조회하라
SELECT empno, ename
FROM EMP
WHERE ename LIKE '%N';

-- 세번째 자리에 A가 나오는 데이터를 조회하라
SELECT empno, ename
FROM EMP
WHERE ename LIKE '__A%';


-- 응용1) job 컬럼에 MAN이라는 글자가 포함되는 문자열 조회하기
-- 응용2) ename 에서 A로 시작하는 글자와 
--     A를 포함하는 글자가 있는 데이터를 구분해서 sql 2개 작성
-- 응용3) ename이나 job의 마지막에서 두번째 글자가 E가 들어가는 데이터 조회하기 (2조)

-- 1)
SELECT *
FROM emp 
WHERE job LIKE '%MAN%';

-- 2)
SELECT *
FROM emp 
WHERE ename LIKE 'A%';

SELECT *
FROM emp 
WHERE ename LIKE '%A%';

-- 너무 비슷해서 문제 바꿔서 푸심/ 끝나는 글자 & 포함하는 글자
SELECT *
FROM emp 
WHERE ename LIKE '%S';

SELECT *
FROM emp 
WHERE ename LIKE '%S%';

-- 3)
SELECT *
FROM emp 
WHERE ename LIKE '%E_' OR job LIKE '%E_';


/*

#정렬처리
1. SQL 명령문에서 검색된 결과는 테이블에 데이터가 입력된 순서대로 출력
2. 데이터의 출력 순서를 특정 컬럼을 기준으로 오름차순/내림차순으로 정렬하는 경우가 발생한다.
3. 여러개의 컬럼에 대해 정렬 순서를 지정해서 처리해야 할 경우가 발생한다.
	- 입사일은 오름차순, 급여 기준으로 내림차순
4. 기본적인 정렬 방법
 	- 문자값을 알파벳순으로 출력하고, 한글은 가나다라 순으로 출력된다.
 	- 숫자 값은 가장 작은 값으로 먼저 출력된다.
 	- 날짜 과거의 날짜 순으로 출력된다.
 5. 기본 형식
 	select *
 	from 테이블
 	where ...
 	order by 컬럼명[ASC/DESC]
 	asc : default로 오름차순 정렬
 	desc : 역순으로 정렬 

*/

-- 조별과제할때 상단에서 누른다고 했는데 정확히 어떤 부분인지 모르겠ㅇ,, 
-- 사원번호를 역순으로 사원번호와 이름을 조회
SELECT empno, ename
FROM emp  
ORDER BY empno DESC;


-- 응용1) 입사일을 기준으로 역순으로 출력하기 
-- 응용2) 연봉을 오름차순으로 출력하기
-- 응용3) 부서번호 오름차순, 연봉 내림차순으로 동시에 처리, 출력하기
-- 응용1,2는 이해했습니다 3번은 제대로 적용이 된건지 모르겠습니다.. 
-- 이해도 70%..?

-- 1.
SELECT *
FROM emp
ORDER BY HIREDATE DESC;

-- 2. default이므로 생략해도 가능~! 
SELECT sal 
FROM emp
ORDER BY sal;

-- 3.
SELECT deptno, sal
FROM emp
ORDER BY deptno, sal DESC;

-- 테이블명(별칭).* : 내가 찾는 데이터를 앞에 쓰고 뒤에 나머지 정보들을 출력하는것 
-- 이렇게 했을때만 적용이 되는건지??? a.* 하려는데 적용이 안됨
SELECT deptno "부서번호", sal "급여", a.*
FROM emp a -- FROM 테이블명 별칭
ORDER BY deptno, sal DESC;
