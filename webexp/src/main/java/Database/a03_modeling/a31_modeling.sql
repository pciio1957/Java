
-- 식별/비식별 관계 

CREATE TABLE student001(
	pcode char(8) PRIMARY key
);

-- 식별자 관계
CREATE TABLE registerLesson001(
	scode char(8),
	pcode char(8) REFERENCES student001(pcode),
	PRIMARY KEY(scode, pcode)
);

CREATE TABLE student002(
	pcode char(8) PRIMARY key
);

-- 식별자 관계
CREATE TABLE registerLesson002(
	scode char(8) PRIMARY KEY,
	pcode char(8) REFERENCES student002(pcode)
);

 
-- 정규화 
-- 1) 기본 테이블 : 다른 테이블의 기본이 되는 테이블 생성
-- 제품번호, 제품명, 재고수량, 주문번호, 수출여부, 고객번호, 사업자번호, 우선순위, 주문수량
CREATE TABLE nomarlization_0 ( 
	prodnum number,
	name varchar2(50),
	rcnt number,
	ordnum char(5),
	isexport char(4), 
	memnum number,
	busnum number,
	priority number,
	ordcount number
);

-- 기존 테이블에 데이터 삽입
INSERT INTO nomarlization_0 values(1001, '모니터', 1990, 'AB345', 'X', 4520, 398201, 1, 150);
INSERT INTO nomarlization_0 values(1001, '모니터', 1990, 'AD347', 'X', 2341, null, 3, 600);
INSERT INTO nomarlization_0 values(1007, '마우스', 9702, 'CA210', 'X', 3280, 200212, 8, 1200);
INSERT INTO nomarlization_0 values(1007, '마우스', 9702, 'AB345', 'X', 4520, 398201, 1, 300);
INSERT INTO nomarlization_0 values(1007, '마우스', 9702, 'CB230', 'X', 2341, 563892, 3, 690);
INSERT INTO nomarlization_0 values(1201, '스피커', 2108, 'CB231', 'Y', 8320, null, 2, 80);

SELECT * FROM nomarlization_0;

-- 2) 제품 테이블 : 1정규화 실행
-- 앞의 제품번호부분이 중복되므로 -> 중복 속성을 분리하여 별도의 테이블로 구성
CREATE TABLE normal_product_1 
AS SELECT DISTINCT prodnum, name, rcnt 
FROM nomarlization_0 
ORDER BY prodnum;

-- 3) 주문목록 테이블 : 1정규화 실행
CREATE TABLE normal_orderlist_1 
AS SELECT prodnum, ordnum, isexport, memnum, busnum, priority, ordcount 
FROM nomarlization_0;

SELECT * FROM normal_orderlist_1;

-- => 중복속성이 분리되었으므로 제품번호 식별자를 가지는 단일 로우가 구성됨
-- 		중복되는 속성을 분리하여 별도의 테이블로 구성함 
-- 1정규화란? 복수의 속성값을 갖는 속성을 분리함


-- 응용1) 화면에 보이는 테이블을 정규화 처리 (1조)
CREATE TABLE normalform0 (
	cus_id varchar2(30),
	event_no varchar2(100),
	is_checked varchar2(50),
	grade varchar2(30),
	discount number
);

DROP TABLE normalform0;

-- 고객아이디, 이벤트번호, 당첨여부, 등급, 할인율
INSERT INTO normalform0 values('apple', 'E001, E005, E010', 'Y, N, Y', 'gold', 0.5);
INSERT INTO normalform0 values('banana', 'E002', 'N, Y', 'vip', 0.2);
INSERT INTO normalform0 values('carot', 'E003, E007', 'Y,Y', 'gold', 0.1);
INSERT INTO normalform0 values('orange', 'E004', 'N', 'silver', 0.05);


-- 1정규화 실행
-- 원자성 원칙 : 하나의 컬럼에 하나의 데이터만 들어가야한다.
-- 테이블을 분리시키지 않고 데이터를 하나씩만 들어갈 수 있도록 작성하기 
CREATE TABLE normal_eventlist_1 
AS SELECT event_no, cus_id, is_checked 
FROM normalform0;

-- 원자성 원칙에 따라 1정규화 실행 
-- 데이터만 나누면 되기때문에 where 1=0조건으로 구조만 생성하고 데이터 삽입
CREATE TABLE normal_eventlist_1
AS SELECT * FROM normalform0 WHERE 1=0;

-- 데이터를 삽입한다 
INSERT INTO normal_eventlist_1  values('apple', 'E001', 'Y', 'gold', 0.5);
INSERT INTO normal_eventlist_1  values('apple', 'E005', 'N', 'gold', 0.5);
INSERT INTO normal_eventlist_1  values('apple', 'E010', 'Y', 'gold', 0.5);
INSERT INTO normal_eventlist_1  values('banana', 'E002', 'N', 'vip', 0.2);
INSERT INTO normal_eventlist_1  values('banana', 'E002', 'Y', 'vip', 0.2);
INSERT INTO normal_eventlist_1  values('carot', 'E003', 'Y', 'gold', 0.1);
INSERT INTO normal_eventlist_1  values('carot', 'E007', 'Y', 'gold', 0.1);
INSERT INTO normal_eventlist_1  values('orange', 'E004', 'N', 'silver', 0.05);

SELECT * FROM normal_eventlist_1;


/*

#제 2정규화
주 식별자에 종속되지 않는 속성의 분리, 부분 종속 속성을 분리한다
1. 완전 함수종속성
2. 부분 함수종속성

function plus(num01, num02) {
	return num01+num02;
}

plus(25, 30) : 결과값은 55
25와 30은 55라는 데이터에 함수 종속성을 가지고 있다 
함수 종속성 : 결정자에 함수적으로 종속관계를 가지고 있다는 것을 의미 
ex) 이름, 출생지, 주소 -> 주민번호를 만드는 함수를 통해 -> 주민번호 생성
이름, 출생지, 주소는 주민번호에 종속성을 가지고 있다. 

*/


-- 응용2) 화면에 보이는 테이블과 같이 erd를 만들고 sql로 테이블을 만들고 데이터 입력 (2조)

CREATE TABLE normal_product2
AS SELECT prodnum, name, rcnt 
FROM nomarlization_0;

SELECT * FROM normal_product2;

CREATE TABLE normal_orderlist2 
AS SELECT prodnum, ordnum, ordcount 
FROM nomarlization_0;

SELECT * FROM normal_orderlist2;

CREATE TABLE normal_order2
AS SELECT ordnum, isexport, memnum, busnum, priority
FROM nomarlization_0;

SELECT * FROM normal_order2;


-- 풀이 : 주문목록 테이블(normal_orderList_1)을 제품주문 <-> 주문 테이블로 나눔
-- 제품주문 : 제 2정규화 완료
create TABLE normal_prod_order_2
AS SELECT prodnum, ordnum, ordcount
FROM normal_orderList_1;

-- 주문 : 제 2정규화 완료
CREATE TABLE normal_order2
AS SELECT ordnum, isexport, memnum, busnum, priority
FROM normal_orderList_1;


-- 응용3) 아래의 데이터를 제 2정규화 과정을 거져서 테이블 만들기 (3조)
-- normal_eventlist_1
-- cus_id, event_no, is_checked, grade, discount
CREATE TABLE normal_cus2 
AS SELECT DISTINCT cus_id, grade, discount 
FROM normal_eventlist_1;

CREATE TABLE normal_event2
AS SELECT event_no, is_checked, cus_id 
FROM normal_eventlist_1;



-- 0721 
-- 정규화가 안된 테이블의 문제

/*

#정규화가 안된 테이블의 문제 (emp+dept 테이블)
1. 삽입, 삭제, 수정 
	삽입 : 부서정보가 확정이 안된 상황에서 deptno, dname, loc을 비워두고 
		처리해야하는 부분이 있다. 필요업이 임시데이터를 입력해야하는 경우
	삭제 : 사원번호 7839, 7782, 7934를 삭제하는 경우 
		10번 부서정보가 삭제되어 다음에 10번 정보를 찾을 수 없다 
	수정 : 사원 7839의 부서명을 바꾸려고 하는데 다른 사원의 부서이름도
		바꿔야하거나 일치하는 정보를 확인할 수 있다
	데이터의 무결성 문제가 발생하여 단계적으로 정규화를 필요로 한다

*/
