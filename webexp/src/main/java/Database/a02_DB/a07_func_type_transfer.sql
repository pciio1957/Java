
/*

#데이터 타입의 변환 
1. 오라클에서 사용하는 데이터 유형은 함수에 의해서 데이터 type을 변경할 수 있다.
2. 형변환 유형
	1) 묵시적 데이터 타입의 변환 
		조건문에서 정확하게 해당 type을 맞게 설정하지 않더라도 결과를 검색해주는 경우가
		있는데 이것은 오라클 시스템 내부에서 내부적으로 타입을 변환했기 때문이다.
		ex) select * from emp where sal >= '2000';
		이때 문제는 시스템에서 index라는 빠르게 검색해주는 내용에 대해서는 묵시적으로 
		함수가 적용된 형변환을 했기 때문에 효율적으로 처리되지 못한다.
		cf) index 책에서 책갈피를 끼워놓으면 빠르게 해당 내용을 찾을 수 있듯이
		DB시스템 내부에서 해당 객체를 설정해서 효과적으로 검색을 빠르게 한다.
	2) 명시적 데이터 타입의 변환
		일반적으로 데이터베이스는 변환함수를 이용해서 데이터타입을 변환하여 효과적으로 처리한다
			1) to_char(문자열로) : 숫자/날짜 타입을 문자열로 변환해주는 함수
				ex) 숫자형/날짜형 타입을 원하는 형식으로 화면에 출력할 때 활용한다.
			2) to_number(숫자로) : 날짜/문자 타입을 숫자로 변환해주는 함수
				ex) 문자형을 숫자로 변환해서 where 조건문이나/ 
					select 에서는 다른 컬럼과 연산이 필요할 때/ 
					입력이나 수정에서 문자열로 입력된 데이터를 숫자형으로 
					변환해서 등록할 때 활용된다. 
			3) to_date(날짜로) : 문자/숫자 타입을 날짜로 변환해주는 함수
				ex) 입력되는 데이터를 문자열형이고 특정한 형식으로 
					날짜형 타입의 컬럼에 입력할 때 사용된다. 

*/

-- 묵시적인 형변환,, 
SELECT *
FROM emp
WHERE sal >= '2000';

-- 위의 조건을 명시적으로 형변환
SELECT *
FROM EMP e 
WHERE sal >= TO_NUMBER('2000'); 


/*

#to_char
1. 날짜/숫자를 원하는 형식으로 데이터를 보기위해서 사용된다.
2. 기본 형식
	to_char(데이터, '출력할 형식')
3. 날짜형을 문자열로 표현하는 출력형식
	1) CC : 세기
	2) YYYY/YYY/YY/Y : 년도표기
	3) AD/A.D : AD/BC 표기
	4) Q : 분기
	5) MM/MONTH/MON : 월표기
	6) WW/W : 연도를 주단위로 표기/월을 주단위로 표기
	7) DDD/DD/D : 날짜 표기
	8) DY/DAY : 요일 표기
4. 주의할 점
	위에 있는 형식에 한글이나 특수문자를 혼합해서 표현할 떄는 
	'YYYY"년도" MM"월"' 이런식으로 표기해서 추가문자열을 처리한다 (엑셀같네)
*/

-- 한글이나 특수문자를 작성할때는 주의! 
SELECT ename, hiredate,
	to_char(hiredate, 'CC') "세기",
	to_char(hiredate, 'YYYY') "년도",
	to_char(hiredate, 'Q') "분기",
	to_char(hiredate, 'MM') "월",
	to_char(hiredate, 'YYYY"년 " MM "월" DD"일"') "날짜표기1",
	to_char(hiredate, 'CC"세기" WW"째 주" DAY') "날짜표기2"
FROM emp;


-- 응용1) @@@(사원명 ename)은 @@년 @@월에 입사하였습니다 출력
-- 응용2) 1/4분기에 입사한 사원의 이름ㅁ과 입사년월일 분기를 출력

-- 1.
SELECT ename || '은 ' || to_char(hiredate, 'YY"년 "MM"월에 입사하였습니다"')
FROM emp;

-- 2. 
SELECT ename 사원명, to_char(hiredate, 'YYYY"년 " MM"월 " DD"일 - " Q "/4"') 입사분기
FROM emp
WHERE to_char(hiredate, 'Q') = '1';



/*
4. date 타입의 시간 표시 형식
	1) AM/PM : 오전/오후 시간표시
	2) A.M/P.M : 오전/오후 시각표시
	3) HH/HH12 : 시각(1~12) 표시
	4) HH24 : 24시간(0~23시) 표시
	5) MI : 분
	6) SS : 초 

*/

SELECT to_char(sysdate,'A M HH:MI:SS') "시간"
FROM dual;

-- 응용) emp 테이블에서 사원명, 입사일+현재시간표현을 혼합해서 표기하기
--		YYYY년 @@월 @@일 @@시(24시간기준) @@분 @@초 (5조)
-- 내가 이해하기로는 입사일 @년 @월 @일까지 + 현재시간 @시 @분 @초 
-- hiredate에 시간이 없어서 연결하라고 하신듯 

SELECT ename, to_char(hiredate, 'YYYY"년 " MM"월 " DD"일 "') ||
	to_char(sysdate, 'HH24"시 " MI"분 " SS"초" ') 입사일+현재시간
FROM emp;


/*
5. 숫자형 데이터를 문자열 형식으로 변환 처리
	1) 기본형식 to_char(숫자형 데이터, '형식')
	2) 주요형식
		주의) 해당 자리수 이상의 데이터가 처리될때는 #으로 채워서 표기된다.
		9999 : 기본 자리수에 맞게 처리
		0000 : 해당 자리수 이하일때 0으로 채워짐
		$ : 앞에 $표기 처리
		. : 특정한 자리를 표기 소수점
		, : x특정한 위치에 ,를 표기 
*/

SELECT ename, sal,
	to_char(sal, '99999') "형식1", 
	to_char(sal, '00000') "형식2",
	to_char(sal, '$9999') "형식3",
	to_char(sal, '9,999') "형식4",
	to_char(sal, '9,999.999') "형식5"
	to_char(sal*100000, '9,999.999') "형식6"
FROM emp;


-- 응용) 사원명, 급여, 급여2(천단위 콤마&앞에 $표기, 소숫점 1자리 표기) 출력하기 (4조)
SELECT ename 사원명, sal 급여, TO_char(sal, '$999,999.9') 급여2
FROM emp;



/*
#to_number
1. 매개변수로 받은 숫자형 문자열을 숫자로 변환하여 연산이 가능하도록 처리한다.
2. 기본 형식 : to_number(문자열)
cf) 주로 자동형변환이 일어나서 사용되지 않는 경우도 많으나, 명시적인 처리로
해당 타입에 대한 구분을 할때 사용한다


#to_date
1. 숫자와 문자로 구성된 문자열을 날짜 데이터를 변환하는 함수 
2. 기본 형식 : to_date('문자열데이터', '형식')
	해당 문자열이 어떤 데이터를 내포하고 있는지를 확인해야지 처리가 가능하다
	조회와 등록시 많이 활용된다.
	안에 사용되는 형식은 to_char에서 사용한 형식과 동일하다

*/

-- to_number를 사용하면 자동형변환
SELECT '25'+25, to_number('25')+25 
FROM dual;

INSERT INTO emp02(ename, hiredate) 
values('홍길동', to_date('2020-01-01', 'YYYY-MM-DD'));

SELECT * FROM emp02;


-- 응용1) '1000' 문자열을 sal값과 비교하여 이상인 데이터를 조회하기
-- 응용2) emp01 사원번호와 사원명(김길동)으로 날짜 (2020/12/31 23:59:59)
-- 		데이터를 입력하여 처리하기 (3조)
SELECT *
FROM emp
WHERE sal >= to_number('1000');

SELECT * FROM emp01;

-- empno, ename, hiredate를 위 입력형식에 맞게 처리 
-- hiredate는 date형식으로 문자열을 넣으려고하면 안 넣어짐 
-- 그래서 to_date를 사용하는 것 
INSERT INTO emp01(empno, ename,hiredate)
values(to_number('10'), '김길동', 
to_date('2020/12/31 23:59:59', 'YYYY/MM/DD HH24:MI:SS'));


-- 응용3) emp01 사원번호, 부서번호, 사원명, 날짜(2021-06-09 12:15:25)를
--		입력하기 
INSERT INTO emp01(empno, deptno, ename, hiredate) 
values(to_number('7899'), 10, '신길동', 
to_date('2021-06-09 12:15:25', 'YYYY-MM-DD HH:MI:SS'));

SELECT * FROM emp01;



SELECT ename 이름, to_char(hiredate, 'Q"/4"') "분기",  to_char(hiredate, 'YYYY/MM/DD')
FROM emp
WHERE to_char(hiredate, 'Q') = 2;