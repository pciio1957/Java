
/*



#전날 정리 문제
1. 명시적 형변환 함수 3가지를 기본 예제와 함께 기술하기
2. 문자열 형변환 format 속성값(날짜, 시간)을 기술하기
3. 2/4분기에 입사한 사람을 이름과 분기, 입사년월일(YYYY/MM/DD)형식으로 출력하기
4. decode문의 기본형식을 기본예제와 함께 기술하기
5. case문의 기본형식을 기본예제와 함께 기술하기
6. nvl, nvl2, nullif 함수의 차이점 기술하기


#전날 정리 문제
1. 명시적 형변환 함수 3가지를 기본 예제와 함께 기술하기
-> to_char(문자열로), to_number(숫자로), to_date(날짜로)
select to_char(hiredate, 'YYYY-MM-DD'), to_number('7990'), to_date('2021/06/10 09:05:00', 'YYYY/MM/DD HH24:MI:SS')
from emp;

'문자열1'||'문자열2' : 문자열을 이어주는 처리
'숫자형문자열1'*'숫자형문자열2' : 자동형변환으로 계산된다.

2. 문자열 형변환 format 속성값(날짜, 시간)을 기술하기
(1)날짜변환
	1) CC : 세기
	2) YYYY/YYY/YY/Y : 년도표기
	3) AD/A.D : AD/BC 표기
	4) Q : 분기
	5) MM/MONTH/MON : 월표기
	6) WW/W : 연도를 주단위로 표기/월을 주단위로 표기
	7) DDD/DD/D : 날짜 표기
	8) DY/DAY : 요일 표기
(2)시간변환
	1) AM/PM : 오전/오후 시간표시
	2) A.M/P.M : 오전/오후 시각표시
	3) HH/HH12 : 시각(1~12) 표시
	4) HH24 : 24시간(0~23시) 표시
	5) MI : 분
	6) SS : 초 
(3)숫자변환
	9999 : 기본 자리수에 맞게 처리
	0000 : 해당 자리수 이하일때 0으로 채워짐
	$ : 앞에 $표기 처리
	. : 특정한 자리를 표기 소수점
	, : x특정한 위치에 ,를 표기 (천단위)


3. 2/4분기에 입사한 사람을 이름과 분기, 입사년월일(YYYY/MM/DD)형식으로 출력하기
SELECT ename 이름, to_char(hiredate, 'Q"/4"') "분기",  to_char(hiredate, 'YYYY/MM/DD')
FROM emp
WHERE to_char(hiredate, 'Q') = 2;


4. decode문의 기본형식을 기본예제와 함께 기술하기
decode(): 괄호안에 사용할 칼럼명, 칼럼에서 나오는 데이터1, 데이터1 대신 사용할 값, 데이터2, 데이터2 대신 사용할 값..., 아무것도 해당되지 않을때 사용할 값)

select ename 이름, deptno 부서번호, 
	decode(deptno, 10, "1팀",
			20, "2팀",
			30, "3팀",
			"부서없음") 부서명
from emp;



5. case문의 기본형식을 기본예제와 함께 기술하기
1) if문처럼 조건문의 형태로 사용하는 방법
select ename 이름, deptno 부서번호,
	case when deptno = 10 then "1팀"
		when deptno = 20 then "2팀"
		when deptno = 30 then "3팀"
		else "부서없음"
	end

2) switch case문의 형태로 사용하는 방법
select ename 이름, deptno 부서번호,
	case when 10 then "1팀"
		when 20 then "2팀"
		when 30 then "3팀"
		else "부서없음"
	end


6. nvl, nvl2, nullif 함수의 차이점 기술하기
1) nvl과 nvl2는 값이 null일때 대신할 데이터값을 리턴해주는 함수지만,
nullif는 데이터 2개를 넣고 동일하면 null을 리턴하고 동일하지 않으면 데이터1을 반환한다.
3) nvl은 null일때만 판별해서 처리할 데이터를 리턴하지만, nvl1은 null일때와 null이 아닐때를 처리해서 값을 리턴한다.

*/
