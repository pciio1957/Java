
/*

#non equi join
1. 조인하는 두개의 테이블의 값이 동일하지 않고, 범위로서
	join하는 경우를 말한다.
	
*/

-- 1
SELECT ename, sal
FROM emp; 

-- grade : 등급 / losal :  / hisal : 
SELECT *
FROM SALGRADE;

SELECT ename, sal, grade
FROM emp e, salgrade s 
WHERE sal BETWEEN losal AND hisal;


-- 응용1) 4등급에 해당하는 사원들의 정보 출력하기
-- 응용2) SMITH의 급여와 등급 출력하기
-- 응용3) job이 SALESMAN인 사람의 급여와 등급 출력하기

SELECT grade "등급", ename "사원명", sal "연봉"
FROM emp e, salgrade s 
WHERE sal BETWEEN losal AND hisal
AND grade = 4;

SELECT sal, grade 
FROM emp e, salgrade s 
WHERE sal BETWEEN losal AND hisal 
AND ename = 'SMITH';

SELECT sal, grade
FROM emp e, salgrade s 
WHERE sal BETWEEN losal AND hisal 
AND job = 'SALESMAN';

-- 응용) 부서별 최고급여와 그 등급을 출력하기 (MSAL은 alias라서 대문자 유의)
SELECT deptno, MSAL, grade
FROM (SELECT deptno, max(sal) MSAL
	FROM emp E 	
	GROUP BY deptno), salgrade s 
WHERE msal BETWEEN losal AND hisal;

SELECT deptno, max(sal) MSAL
	FROM emp e 
	GROUP BY deptno;

SELECT DISTINCT deptno -- 중복 제거 
FROM emp;

SELECT *
FROM dept;



/*
#outer join
1. EQUI JOIN의 조인 조건에서 양측 칼럼 값 중, 어느 하나라도 Null이면
	'=' 비교 결과가 거짓이 되어 Null값을 가진 행은 조인 결과로 출력 불가
	null에 대해서 어떠한 연산을 적용하더라도 연산 결과는 null 
	
	일반적인 EQUI JOIN의 예 :
	학생 테이블의 학과번호 칼럼과 부서 테이블의 부서번호 칼럼에 대한 
	EQUI JOIN (student.deptno = department.deptno)인 경우
	학생 테이블의 deptno 칼럼이 Null인 경우 해당 학생은 결과로 출력되지 못함
	
2. EQUI JOIN에서 양측 칼럼 값중의 하나가 null이지만 조인 결과로
	출력할 필요가 있는 경우 Outer Join 사용
	
	outer join의 예 :
	학생 테이블과 교수 테이블을 EQUI JOIN 연산자인 '(+)' 기호 사용
	조건 : 지도 학생을 한명도 배정받지 못한 교수 이름도 반드시 함께 출력
	
3. (+) 기호를 사용한 Outer join
	where 절의 조인 조건에서 outer join 연산자인 '(+)' 기호 사용
	★조인 조건문에서 Null이 출력되는 테이블의 컬럼에 (+) 기호 추가★
	
4. 기본구문
	select table.column, table1.column
	from tabel1, table2
	where table1.column(+) = table2.column
	또는 ; table1.column = table2.column(+)	
	
*/
-- emp 테이블에 사용된 deptno는 10~30인데
SELECT DISTINCT deptno
FROM emp;

-- dept 테이블에는 deptno가 10~40까지임
SELECT *
FROM dept;

SELECT e.ename, e.deptno, d.deptno, dname
FROM emp e, dept d
WHERE e.deptno(+)= d.deptno;

-- 이와 같이 dept에는 있으나 emp에 해당되지 않아 보이지 않는 데이터도
-- join 현황에서 확인하고자 할때 outer join을 이용한다. 


-- 응용1) 사원테이블과 부서테이블을 아웃조인하여 아래와 같이 출력하기
-- 	 사원명 부서명 : 사원명이 할당되지 않았을 때 nvl을 이용해 할당된 사원없음 표시 (2조)
SELECT d.deptno 부서번호, dname 부서이름, nvl(ename, '할당된 사원없음') 사원명
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

-- 응용2) 부서별 인원수를 표시하되 부서에 할당된 인원이 없으면 0으로 표기 
--		출력내용 : 부서명 인원수 (2조)
SELECT dname 부서이름, nvl(count(e.DEPTNO), '0') 부서별인원
FROM emp e, dept d 
WHERE e.deptno(+) = d.deptno
GROUP BY dname;

-- 그냥 count를 써도 null이면 0으로 표시 
-- e.deptno가 해당 컬럼에 null을 제외한 데이터를 count하여 처리한다
-- 그러므로 outer join에 의해서 할당되지 않는 데이터는 0으로 처리되어
-- 그룹함수의 적용 결과를 볼 수 있다.
SELECT dname 부서이름, count(e.DEPTNO) 부서별인원
FROM emp e, dept d 
WHERE e.deptno(+) = d.deptno
GROUP BY dname;