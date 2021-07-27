
/*
#날짜 함수
1. 날짜형 데이터 타입에 사용하는 함수
	1970/1/1
	1/1000초 -> 1초 -> (60) 1분 -> (60)1시간
	-> (24)1일  -> calendar 규칙에 의해 28일/30일/31일 경우가 있음
	1(월) -> (12) 1년
	
2. 기본 연산
	기본 +1은 1일을 기준으로 처리된다
	1) 날짜 +/- 숫자 : 해당 일자의 일수를 가산(감산) 하여 처리
	2) 날짜 +/- 1/24 : 시간단위 연산 처리
	1일이 24시간이기 때문에 5시간 이후인 경우 날짜 5/24를 처리한다.
	cf) sysdate는 현재 날짜/시간을 나타낸다
	
*/

SELECT sysdate "현재날짜/시간",
	sysdate +1 "내일 24시간이후",
	sysdate -1 "전날 24이전날짜",
	sysdate +(8/24) "현재로부터 8시간"
	sysdate +(30/60/24) "현재로부터 30분이후" -- 30분/하루/1시간... 뭔솔,, ,
	-- 60분에서 30분 60분은 24시간중 1시간 뭐이런거같음
FROM dual;


-- 응용) 사원명, 입사일, 입사 후 120일(인턴기간), 입사 8시간전, 근무일수 
-- sysdate 활용
SELECT ename, hiredate, hiredate + 120 인턴기간,
	hiredate -(8/24) "입사 8시간전", -- 앞에 연산자-라서 전
	trunc(sysdate-hiredate) 근무일수
FROM emp; 

/*
#날짜 함수
1. sysdate : 오라클에서 서버시스템의 현재 날짜와 시간
2. months_between(날짜1, 날짜2) : 날짜 사이의 개월을 월단위로 계산
	ex) 1개월 -> 1, 15일 -> 0.5 
	1월을 기준으로 일/시/분/초 단위 등으로 소숫점으로 계산이 된다. 
3. 소숫점이하에 대한 처리는 trunc, floor를 이용해서 절삭 처리를 해준다.
	1.5개월을 개월차로 ceil, 개월수는 trunc, floor

*/
SELECT ename, hiredate, sysdate,
	MONTHS_BETWEEN(sysdate, HIREDATE) "근무개월수1",
	trunc(MONTHS_BETWEEN(sysdate, HIREDATE)) "정확한근무개월수",
	trunc(MONTHS_BETWEEN(sysdate, HIREDATE)/12) "근무연한3"
	-- 얼마나 근무했는지 근무연한.. 1년으로 나눠서 몇년했는지??
FROM emp01;


-- 응용) dual(현재시각?)을 이용해서 오늘로부터 100일 후 개월 수 출력
--		오늘로부터 1000일 후 연한, 개월 수 출력 (1조)

-- 개월수 : trunc(MONTHS_BETWEEN(sysdate+100, SYSDATE))
-- 연도 : trunc(MONTHS_BETWEEN(SYSDATE+1000, SYSDATE)/12)
-- 연도를 뺀 개월수 : 나머지값
-- 두 날짜 사이의 @@년 @@개월 Months_Between, Mod 활용 처리 

SELECT sysdate FROM dual;

SELECT ename, hiredate, sysdate,
	trunc(MONTHS_BETWEEN(sysdate+100, SYSDATE)) "근무개월수",
	trunc(MONTHS_BETWEEN(SYSDATE+1000, SYSDATE)/12) "1000후 년수",
	MOD(trunc(MONTHS_BETWEEN(SYSDATE+1000, SYSDATE)/12)) "1000후 dlf"
FROM emp01;

SELECT trunc(MONTHS_BETWEEN(sysdate+100, SYSDATE)) "100근무개월수",
	trunc(MONTHS_BETWEEN(sysdate+1000, SYSDATE)) "1000근무개월수",
	trunc(MONTHS_BETWEEN(SYSDATE+1000, SYSDATE)/12) "1000후 년수",
	mod(trunc(MONTHS_BETWEEN(SYSDATE+1000, SYSDATE)),12) "1000후 개월수"
FROM dual;


/*
4. add_months(날짜형 데이터, 추가할 개월수) :
	해당 날짜에 개월을 더한 날짜 계산

*/

SELECT sysdate, add_months(sysdate, 4) "오늘로부터 3개월후"
FROM dual;

-- 응용) 사원정보를 통해 부서별로 인턴기간을 다르게 처리한다고 한다
-- 		10 -> 1개월, 20 -> 2개월, 30 -> 3개월
--		사원명 부서번호 입사일 인턴기간만료를 출력하세요

SELECT ename 사원명, deptno 부서번호, hiredate 입사일, 
	add_months(hiredate, deptno/10) 인턴기간만료일
FROM emp;

/*
5. next_day(날짜, '요일') : 대상날짜로부터 다가오는 첫번째 요일에 해당하는 날짜
6. last_day(날짜) : 대상날짜의 월의 마지막날짜 
*/

SELECT sysdate, NEXT_DAY(sysdate, '금'),
	next_day(NEXT_DAY(sysdate, '금'), '금'),
	last_day(sysdate),
	LAST_DAY(SYSDATE)+1 
FROM dual;

-- 응용) 입사일을 기준으로 다가오는 첫번째 일요일 출력
--		입사일 기준으로 첫번째 급여는 입사월의 다음월의 첫번째 일을 기준으로 한다
--		사원명, 입사일, 첫번째 일요일, 첫급여일 출력 (3조)
-- 		첫급여일이 걍 다음달의 첫 요일이었음 

SELECT ename 사원명, hiredate 입사일, 
	next_day(hiredate, '일') 첫번째일요일, 
	last_day(hiredate)+1 첫급여일, --다음달 첫요일
	NEXT_DAY(add_months(next_day(hiredate, '일'), 1), '일') 첫급여일,
	add_months(next_day(hiredate, '일'), 1) 첫급여일
FROM emp;