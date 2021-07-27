
/*
1-1. 함수란
함수의 매개변수를 통해 데이터가 입력되면 함수로 인해 원하는 데이터를 원하는 데이터 형식으로 
변경하여 효율적으로 활용하기 위해 사용된다.
function 함수명(매개변수,,) {
	프로세스	
	return 리턴값;
}
1-2. 함수의 종류
	1) 단일행 함수 : 입력한 데이터의 갯수와 출력한 데이터의 갯수가 동일할 때를 말함
		일반적인 함수로 숫자처리함수, 문자처리함수, 날짜함수, 기타기능함수가 있다.
	2) 복수행 함수 : 단일 또는 그룹의 데이터 건수에 의해 처리되는 함수로 
		그룹을 통한 통계 함수(최대값, 최소값, 평균값.. )


2. 검색
select *
from product
where upper(pname) like upper('%' || 검색데이터 || '%') 


3. 
lengthb의 경우 오라클에서 한글은 3바이트
테이블 생성시 선언하는 char(크기) varchar2(크기)는 byte기준으로 선언한다.
select '안녕하세요' s1, length('안녕하세요') s2, lengthb('안녕하세요') s3, 
	'hello' se1, length('hello') se2, lengthb('hello') se3
from dual;


4. 
select substr(ename, 1, 3) || '(' || deptno || ')' ||
	'의 직책은 ' || substr(job, -5, 5) || '입니다' show
from emp;
substr(컬럼명, -5, 5) : 마이너스는 뒤에서부터 5를 추출해서 시작함
	시작위치를 뒤에서 -5 index로 부터 시작해서 5개를 추출 처리 
	
	
5. 
lpad(컬럼명, 기준이되는자리수, 자리수보다 적을때 채워놓은 문자)



6. 
1. 자리수처리
round, trunc 
자리수에 + : 소숫점이하 자리수
자리수에 - : 왼쪽으로 10, 100, 1000단위 처리
2. 정수로 처리
ceil(데이터) : 올림
floor(데이터) : 내림


7. 
select ename, sal, mod(empno, 3) "보너스(%)",
	sal * mod(empno, 3)/10 "보너스", 
	sal + (sal * mod(empno, 3)/10) "총계"
from emp;

0 -> 0%, 1 -> 10%, 2 -> 20%
mod(empno, 3) : 나머지값을 기준으로 보너스 % 표시
sal * mod(empno, 3)/10 : 실제 연산할 %에 해당하는 실수값을 
	sal과 연산한 보너스 금액
sal + (sal * mod(empno, 3)/10) : 원금 + 보너스를 한 총계 처리


8.
소숫점 -는 10, 100단위이므로 -2 지정
select empno, mgr, trunc(sal,-2) "급여"
from emp
where mod(mgr, 2) = 0;


*/
