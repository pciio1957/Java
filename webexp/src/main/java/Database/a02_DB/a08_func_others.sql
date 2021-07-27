
/*
#중첩함수
1. 가장 내부에 있는 함수 f1의 결과값을 다음 함수 f2에 인수로 적용하고
	다시 f2의 결과값을 f3에 인수로 사용할 때 활용하는 함수형태를 말한다.
	f3(f2(f1(데이터, 매개변수), 매개변수), 매개변수)
	- 특정한 데이터에서 여러가지 함수의 기능을 처리하고자 할 때 활용된다

*/

-- 현재 데이터의 입사년도를 올해연도로 변경하여 출력하려고 한다
-- 합쳐서 날짜데이터로 변경처리
-- 중첩함수 : to_date(to_char(sysdate, 'YYYY')
SELECT ename, to_char(sysdate, 'YYYY') "올해연도",
	to_char(hiredate, 'MMDD') "사원의 입사월일",
	to_char(sysdate, 'YYYY') || to_char(hiredate, 'MMDD') "올해입사년월",
	to_date(to_char(sysdate, 'YYYY') || 
	to_char(hiredate, 'MMDD'), 'YYYYMMDD') "날짜형데이터"
FROM emp;


-- 응용) 입사일의 분기를 추출하여 해당 보너스의 기준으로 설정하려고 한다
-- 	1) 입사일(hiredate), 분기(to_char, 'Q'), 급여(sal)
-- 	2) 분기 1-> 10%, 2 -> 20%, 3 -> 30%, 4 -> 40%
--		to_char(hiredate, 'Q')*10 : 묵시적 형변환으로 일어나는 부분
--  3) 급여와 연산하여 보너스금액 출력
--		to_char(@@@, 'Q'), 숫자형데이터 to_number()
--	4) 입사일, 분기, 급여, 보너스(%), 보너스, 최종금액 출력하기 (1조)

SELECT hiredate 입사일, to_char(hiredate, 'Q') 분기,
	sal 급여, to_char(hiredate, 'Q')*10 "보너스(%)",
	sal*to_number(to_char(hiredate, 'Q'))/10 보너스,
	sal+sal*to_number(to_char(hiredate, 'Q'))/10 최종금액
FROM emp;



/*
#일반함수
1. nvl(데이터, null값일 때, 처리할 데이터)
	해당 데이터가 null값일 때 처리할 데이터를 설정함으로 null에 대한
		연산 처리시 필요하다

2. nvl2(데이터, null이 아닐 때 처리할 데이터, null일때 처리할 데이터)
	기준이 되는 데이터가 null일때 아닐때를 처리하는 함수로, 그 데이터가 null이 
	아닐때 출력할 데이터, null일때 출력될 데이터를 반환하는 함수이다
	
3. nullif(데이터1, 데이터2) 
	두 개의 매개변수로 받는 데이터를 비교하여 동일하면 null을 반환하고, 
	동일하지 않으면 첫번째 데이터1을 반환처리하는 함수이다
	

*/

-- null인 데이터가 있음 -> nvl로 처리
-- 하나의 컬럼 데이터가 null일때 합산값도 null이기 때문에 0으로 처리한다.
SELECT ename, sal, comm, sal+comm, 
	nvl(comm,0), sal+nvl(comm,0) 
FROM emp;


-- comm이 null일 때는 100, null이 아닐 때는 comm에서 10% 더 추가해서
--	결과값을 출력하기
SELECT ename, sal, comm, nvl2(comm, comm*1.1, 100) "보너스"
FROM emp;


-- 응용) comm일 때는 sal의 15%로 설정하고, null이 아닐 때는 comm에서 sal의 
--	5%를 더하여 보너스금액을 설정하여 사원명, 연봉, 보너스를 출력하기 (6조)
-- 문제풀 때 잘 읽어보고 풀기,,, ,
SELECT ename 사원명, sal 연봉,  
	nvl2(comm, comm+(sal*0.05), sal*0.15) 보너스
FROM emp;


SELECT nullif('a', 'a') show1,
	nullif('a', 'b') show2,
	nvl(NULLIF('a', 'a'), '동일') show3,
	nvl(NULLIF('a', 'b'), '동일') show4
FROM dual;


-- 응용) 회사에서 일괄보너스 지급 금액이 60이라고 정하는데 연봉의 
--	5%(10단위로 절삭)와 같으면 60, 다르면 연봉의 5%로 처리하는 sql 작성
--	절삭함수trunc, nvl2, nullif 

SELECT ename, trunc(sal*0.05, -1) "연봉의5%", 
	nullif(trunc(sal*0.05, -1), 60) 같은지여부,
	trunc(nvl2(NULLIF(trunc(sal*0.05, -1), 60),sal*0.05, 60),-1) 보너스
FROM emp;


/*
#decode 함수
1. 프로그래밍 언어의 if문이나 case문으로 표현되는 내용을 하나의 함수로
	처리할 수 있게 해준다.
2. 기본형식
	decode(데이터, case1, case1일때 처리할 데이터,
				case2, case2일때 처리할 데이터,
				case3, case3일때 처리할 데이터,
				위 내용에 해당하지 않을 때 처리할 데이터)
	- 짝수개의 파라미터를 가지고 있다
			
*/

SELECT ename, deptno,
	decode(deptno, 10, '인사과',
					20, '총무',
					30, '회계',
					'부서정하지않음') 부서명
FROM emp;


-- 응용1) 사원번호를 기준으로 짝수면 홍팀, 홀수이면 청팀으로 처리하기 (4조)

SELECT ename 사원명, deptno 부서번호, 
	decode (MOD(empno,2), 0, '홍팀', 
						1, '청팀', 
						'없음') 팀
FROM emp;


-- 응용2) 입사일의 분기(1/4)를 기준으로 출장을 가기로 했다
-- 		1: 부산, 2: 광주, 3: 제주 그 외에는 출장없음으로 처리
--		사원명, 입사일, 분기, 출장지를 출력하기 (3조)
-- 		to_char(hiredate, 'Q') : 1~4 값이 나옴
--		decode(위 분기 처리내용, '1', '부산', '2', '광주', '3', '제주', '출장없음') 


SELECT ename 사원명, hiredate 입사일 , to_char(hiredate, 'Q "/ 4 분기"')  , 
	decode(to_char(hiredate, 'Q'), 1, '부산',
								2, '광주',
								3, '제주',
								'출장없음') 출장지
FROM emp;



/*
#일반함수 case
1. decode의 확장된 함수 형식을 표현식 또는 컬럼값 '=' 비교를 통해
	조건이 일치하는 경우에만 다른 값으로 대치하지만, case 함수에서는
	산술 연산, 관계 연산, 논리 연산과 같은 다양한 비교가 가능하다
2. 기본 형식
	1) 조건문 형태 활용
		case when 논리/산술/관계 then 처리할 데이터
			 when 논리/산술/관계 then 처리할 데이터
			else 기타 처리할 데이터
		end
	-> 참고! 
		case when은 앞에서 선언 조건식을 제외한 조건을 처리한다.
		
	2) switch case문 형태 - decode와 비슷 
		case [컬럼명]
			when 데이터1 then 처리할 데이터
			when 데이터1 then 처리할 데이터
			else 그외 데이터
		end

*/

-- 부서번호에 따라 처리하는 데이터를 다르게 할때 
-- 1번 유형) if처럼 조건/산술로 
SELECT ename, deptno,
	CASE WHEN deptno = 10 THEN sal*0.2
		WHEN deptno = 20 THEN sal*0.5
		WHEN deptno = 30 THEN sal*0.7
		ELSE sal*1.2
	END show
FROM emp;

-- 2번 유형) case문 처럼
SELECT ename, deptno,
	CASE deptno
		WHEN 10 THEN sal*0.2
		WHEN 20 THEN sal*0.5
		WHEN 30 THEN sal*0.7
		ELSE sal*1.2
	END show
FROM emp;


-- 응용) case문을 이용해 분기별로 보너스 금액을 급여의 30%, 20%, 10%, 5%로 지정하여
-- 사원명, 입사일, 입사분기, 급여, 보너스를 출력하기 (2조)

SELECT ename 사원명, hiredate 입사일, to_char(hiredate, 'Q') 분기, 	
	sal 급여, 
	CASE to_number(to_char(hiredate, 'Q'))
		WHEN 1 THEN sal*0.3
		WHEN 2 THEN sal*0.2
		WHEN 3 THEN sal*0.1
		ELSE sal*0.05
	END 보너스
FROM emp;

-- 입사월을 기준으로 짝수월을  보너스가 1000, 홀수월인 경우 보너스가 500을
-- 사원, 입사일, 입사월, 보너스금액
SELECT ename 사원명, hiredate 입사일, to_char(hiredate, 'MM') 입사월, 
	decode(MOD(to_char(hiredate, 'MM'), 2), 0, 1000, 
											1, 500) 보너스금액
FROM emp;


-- 비교연산자 sal >= 5000, sal >= 4000
-- 응용1) 급여별 등급 표시를 한다고 했을 떄 case when문 활용
--		5000~ (A등급)
--		4000 ~ 5000 미만 (B등급)
-- 		3000 ~ 4000 미만 (C등급)
-- 		2000 ~ 3000 미만 (D등급)
-- 		1000 ~ 2000 미만 (E등급)
--		0 ~ 1000 미만 (F등급)
--		그 외 (범위는 0 이상) 
SELECT ename 사원명, sal 급여,
		CASE WHEN sal >= 5000 THEN 'A등급'
			WHEN sal >= 4000 THEN 'B등급'
			-- case when 앞에 있는 조건을 제외시킨다.
			-- when sal >= 4000 and sal < 5000을 포함하고 있다.
	 		WHEN sal >= 3000 THEN 'C등급'
	 		WHEN sal >= 2000 THEN 'D등급'
	 		WHEN sal >= 1000 THEN 'E등급'
	 		WHEN sal >= 0 THEN 'F등급'
	 		ELSE '범위는 0 이상'
		END 등급
FROM emp;


-- 비교연산자 sal >= 5000, sal >= 4000
-- 응용2) 사원명, 입사일, 입사구분(상/하반기)
SELECT ename 사원명, hiredate 입사일, to_char(hiredate, 'MM') 입사월,
	CASE WHEN to_number(to_char(hiredate, 'MM')) <= 6 THEN '상반기'
		ELSE '하반기'
	END 
FROM emp;

		
-- 응용3)sal 5000 이상 (상), 2000~5000미만 (중), 2000미만(하)
-- 이름, 연봉, 등급 case when 구문으로 처리해서 출력

SELECT ename 사원명, sal 연봉,
	CASE WHEN sal >= 5000 THEN '상'
		WHEN sal >= 2000 THEN '중'
		WHEN sal < 2000 THEN '하'
	END 등급
FROM emp;

SELECT to_char(sysdate, 'A.M HH:MI:SS')
FROM dual;