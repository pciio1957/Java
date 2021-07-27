
/*

#마무리문제
1. sal+comm으로 연산하는 경우 comm null인 경우 문제가 발생한다.
	어떤 문제이고 이것을 해결하려면 어떤 처리를 하는지 정리하기
2. 오라클에서 사용하는 주요 데이터 타입의 종류를 예시와 함께 기술하기
3. 문자열을 저장하는 데이터 중, 고정형과 가변형이 있다. 두 데이터 유형의 차이점을 기술하기
4. 데이터 유형을 확인하고 학생테이블(번호, 이름, 국어, 영어, 수학)을 만들고 데이터를 입력하세요
5. 스포츠 스타의 이름, 소속사, 올해 성적을 입력하는 테이블을 만들고 데이터를 입력하고 조회하기
6. select에서 쓰이는 컬럼과 where 조건의 비교 연산자에 쓰이는 컬럼은 어떤 차이가 있는가?
7. where 조건에 쓰이는 비교 연산자의 종류와 논리 연산자의 종류를 기술하기
8. between, in 구문의 기본형식을 선언하고 기본 예제 기술하기
9. 부서 10과 30에 속하는 모든 사원의 이름과 부서번호를 이름과 알파벳 순으로 정렬되도록 질의문 만들기
10. 1982년도에 입사한 모든 사원의 이름과 입사일 출력하기(like %활용)
11. 보너스가 급여의 20%이상이고 부서번호가 30인 모든 사원에 대해 이름, 급여, 그리고 보너스 출력하기
	급여(sal), 보너스(comm)
12. like 키워드에서 %, _ 의 의미를 기술하고 간단한 예제 만들기
13. 가장 최근에 입사한 사원의 이름과 입사일을 출력하기 (in subquery)  
*/

-- 확인용
SELECT * FROM emp;

-- 1.
-- comm의 경우 데이터가 null인 경우가 포함되어 있어서 문제가 발생한다.
-- 이경우 nvl함수를 이용하여 null값을 0으로 치환하여 계산하도록 한다.
-- nvl(컬럼명, "null일때 나오는 데이터") 
-- 문자형의 경우 nvl(컬럼명, 'null일때 나올 데이터')
-- 숫자형의 경우 nvl(컬럼명, null일때 나올 데이터)


-- 2.
-- 오라클에서 주로 사용되는 데이터타입 
-- char(size) : 고정 길이 문자 데이터 타입으로 최대 2000자
-- varchar2(size) : 가변 길이 문자 데이터 타입으로 최대 4000자
-- NUMBER(p,s) : 정밀도(p)와 스케일(s)로 표현되는 숫자 데이터 타입
-- DATE : 날짜 데이터 타입

CREATE TABLE Confirm (
	name char(20),
	auth varchar2(20),
	hp NUMBER,
	today DATE
);


-- 3.
-- 고정형 : 해당 문자열의 공간에 할당하는 데이터를 넣고 남은 공간에 공백을 삽입한다.
-- 가변형 : 할당된 문자열만큼만 할당되어 빈 공간이 없다. 


-- 4.
CREATE TABLE Student(
	num NUMBER,
	name varchar2(20),
	kor NUMBER,
	eng NUMBER,
	math NUMBER
);

INSERT INTO Student values(1, '홍길동', 80, 70, 85);

SELECT * FROM Student;


-- 5.
CREATE TABLE SportStar (
	name varchar2(20),
	appart varchar2(20),
	grade NUMBER -- 등수로 처리.. 
);

INSERT INTO SportStar VALUES('허재', 'MBC', 3);
INSERT INTO SportStar VALUES('현주엽', 'SBS', 2);

SELECT * FROM SportStar;


-- 6.
-- select의 컬럼 : 해당 컬럼을 화면에서 출력해서 정보를 확인할 수 있게 함
-- where의 컬럼 : 해당 컬럼의 데이터에서 비교연산자에 맞는 데이터를 추출함


-- 7.
-- where 조건의 비교연산자
--  1) ! (not) :
--		해당 조건이 아닐 때 사용
-- 	2) Between : 
--		컬럼명 between 데이터A and 데이터B 형태로 사용, 
--		연속된 데이터의 조건 처리할때 사용
--  3) is null/is not null : 
--		컬럼명 is null/ is not null 형태로 사용, 
--		해당 컬럼의 데이터가 null인지/아닌지 판별하는데 사용
--  4) null 판별 후 설정데이터 리턴 : nvl함수
--		숫자형의 경우 : nvl(컬럼명, null일때 출력할 데이터) 
--		문자형의 경우 : nvl(컬럼명, 'null일때 출력할 데이터') 
--		함수 안에 입력한 컬럼명의 데이터가 null일 경우 null 대신 설정한 문자열 출력
--  5) in : 
--		조건이 ~이거나, ~거나인 경우 or 조건을 사용하는데, 많은 or을 처리해야할때 사용
--  6) like : 
--		문자열안에 포함된 문자열을 판별하는데 사용, 포함된 경우나 자리를 정해 기술도 가능
--  7) 정렬 : 
--		입력 순서대로 출력하는 데이터를 오름차순/내림차순 설정하여 출력
--		기본 정렬 순서는 오름차순(asc)이며 내림차순(desc)은 따로 기술해야함

-- where 조건의 논리연산자
--  1) and :
--		조건이 A이고 B일때 사용, 두개 모두 해당되야 함
--	2) or :
--		조건이 A이거나 B일때 사용, 둘 중 하나만 해당되도 됨


-- 8.
--  1) where 컬럼명 between A and B :
SELECT sal 
FROM emp 
WHERE sal BETWEEN 2000 AND 4000;

--  2) where 컬럼명 in(데이터A, 데이터B) :
SELECT ename, job
FROM emp 
WHERE job IN ('SALESMAN', 'MANAGER');


-- 9. 
SELECT ename, deptno
FROM emp 
WHERE deptno in(10, 30) 	
ORDER BY ename; 
-- 이름의 알파벳순서로 정렬되도록 함


-- 10. 
SELECT ename, hiredate 
FROM emp 
WHERE TO_CHAR(hiredate, 'YYYY')  LIKE '1982';

SELECT ename, hiredate
FROM emp 
WHERE hiredate LIKE '1982%'; -- 이렇게 하면 데이터가 안나옴...ㅜㅜ 


-- 11. 
SELECT ename, sal, comm
FROM emp
WHERE comm > sal*0.2 AND deptno = 30;


-- 12. 
--  1) % : 모든 문자가 해당되고, 문자수도 상관없다.
--	2) _ : 모든 문자가 해당되지만 글자수는 한글자로 제한되어 있다.
SELECT ename
FROM emp 
WHERE ename LIKE '%S%'; -- S가 포함된 문자열 조회

SELECT ename
FROM emp 
WHERE ename LIKE '_O%'; -- 두번째 글자가 O인 문자열 조회


-- 13.
SELECT ename, hiredate 
FROM emp 
WHERE hiredate IN (
SELECT max(HIREDATE)
FROM emp
);