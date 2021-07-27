
/*

#instr(지정한 문자열 데이터|컬럼, '검색문자')
앞의 in은 index의 줄임말
1. 특정한 문자열을 검색해서 해당 문자열의 위치를 index로 반환처리하는 함수이다.
	ex) 주로 대용량의 문자열 데이터를 검색해서 해당 문자의 위치를 index로 표현해 
		위치를 찾아 처리할 때 필요로 한다.
		
2. 추가 형식 
	instr(지정한 문자열 데이터 | 컬럼, '검색문자', 시작위치, 검색된 횟수)

*/
-- instr을 이용해 검색 문자의 index를 반환
SELECT instr('sql*plus', '*') FROM dual;


-- 응용) job 컬럼에서 'A'문자가 나오는 위치를 검색하여 위치를 출력하기
-- 해당 문자가 없을 때는 0, 있을 때는 순번 index(1부터 시작)로 처리해준다.
SELECT job, instr(job, 'A') FROM emp;


-- 추가형식에 따른 사용/ 2번째에 있는 문자 찾기
SELECT instr('sql*plus', '*') sh1,
	instr('sql*pl*s', '*', 1, 2) sh2
FROM dual;

/*
#lpad(left padding), rpad(right padding)
1. 전체 문자의 크기를 지정하고, 그 크기보다 못할 때
	왼쪽으로 또는 오른쪽을 특정한 문자를 추가하는 기능을 말한다.
2. 형식
	lpad(데이터, 크기지정, 덧붙일문자열)
	rpad(데이터, 크기지정, 덧붙일문자열)
*/
SELECT lpad('sql', 5, '*') sh1,
		rpad('sql', 5, '#') sh2
FROM dual;

-- 응용) 사원테이블에 ename은 전체 6으로 job은 8로 설정하여 
--		ename은 왼쪽에 #기호를 job은 오른쪽에 @기호를 추가하여 처리하기
SELECT lpad(ename, 6, '#') ename, rpad(job, 8, '@') job
FROM emp;

-- cf) 단일행 함수는 delect, where, insert, update에서도 활용된다.


/*

#ltrim/rtrim
1. 왼쪽/오른쪽에 지정한 문자열을 삭제하여 처리할 때 활용된다. 
2. trim 과의 차이점 : 
	trim('양쪽 삭제 문자' from 데이터) trim은 양쪽 문자를 모두 삭제한다.

*/

SELECT ltrim('****sql*****', '*') s1, 
		rtrim('****sql*****', '*') s2,
		trim('*' FROM '****sql**') s3
FROM dual;

-- 눈에 안보이는 공백이 있는 경우 trim을 통해서 공백을 제거한 후 길이수 검색
-- trim의 경우 한글자만 검색조건으로 줄수 있으니 공백을 한칸으로 지정
SELECT ltrim('****sql*****', '*') s1, 
		rtrim('****sql*****', '*') s2,
		trim('*' FROM '****sql**') s3,
		length('    sql    ') s4,
		trim(' ' FROM '    sql     ') s5,
		length(trim(' ' FROM '    sql     ')) s6
FROM dual;






-- 응용) job 뒤에 있는 'MAN'을 삭제 처리하여 출력하기 - 사원명, 직책, 출력1
SELECT ename, job, rtrim(job, 'MAN')
FROM emp;


/*

#숫자형 처리함수
1. 숫자형 데이터를 
2. 종류
	1) round : 지정한 소숫점 자리로 반올림 처리를 해준다.
		round(데이터, 자릿수)
		자릿수 : 
			+값은 소숫점 이하 자리수를 말한다.
			ex) round(45.2431, 2) -> 45.24
			-값은 소숫점 기준을 10, 100, 1000 단위로 처리해주는 것을 말한다.
				10단위 이상의 자릿수 반올림 처리
			round(2456435, -3) -> 2456000
	2) trunc : 지정한 소숫점 자리까지 남기고 절삭처리
		trunc(데이터, 자릿수) cf) floor() : 정수로 절삭
	3) mod : 데이터베이스에서 산술연산자 %대신 쓰이는 나머지 처리 함수를 말한다
		mod(데이터, m) : 데이터를 m으로 나눈 나머지값
		ex) mod(10,3) -> 1
	4) ceil : 지정한 값보다 큰 수 중에서 가장 작은 정수
		소숫점이하의 내용에 대하여 올림 정수
	5) floor : 지정한 값보다 작은 수 중에서 가장 큰 정수
		소숫점이하의 내용에 대하여 내림 정수 
		
*/

-- 자리수에 따른 반올림 처리 round(데이터, 자리)
SELECT round(243323.233, 3), round(243323.233, 1),
	round(243323.233,-1) "10단위", round(243323.233, -2) "100단위",
	round(243323.233, 3) "1000단위"
FROM dual;

-- 응용) 사원명과 sal을 출력하되, sal은 15% 인상금액을 100자리 
--		단위와 소숫점 1자리 단위로 반올림 처리해 출력하기 (4조)
SELECT ename, round(sal*1.15, -2) 인상1, round(sal*1.15, 1) 인성2
FROM emp;


-- 절삭 : trunc(데이터, 자릿수) 
SELECT trunc(2734.5343, 2) sh1, 
		trunc(2734.5343) sh2, 
		trunc(2734.5343, -2) sh3
FROM dual;

-- 응용) 급여를 부서번호 기준으로 %(부서번호가 10이면 10%/20이면 20%)로
--		올해 인상급여를 지정한다고 할대 100자리 단위 절삭과 소숫점 2자리로 출력
SELECT ename, sal, deptno || '%' "보너스",
	sal*(deptno/100) "소숫점표기",
	trunc(sal+(deptno/100), -2) "인상분2" ,
	trunc(sal+(deptno/100), 2) "인상분3"
FROM emp;


-- mod : % 대신 활용
SELECT mod(10,3) s1, mod(10,2) s2 FROM dual;

-- 응용) 사번이 짝수인 데이터를 사번, 이름, 구분자(0/1)로 표시하기 (6조)
SELECT empno 사번, ename 이름, mod(empno, 2) "구분자(0/1)"
FROM emp
WHERE MOD(empno, 2) = 0;
-- 짝수인 데이터만 나와야하므로 조건에 작성~!! ==을 써야할지 = 써야할지 고민함,,