
/*

1. 함수종속성개념을 완전함수종속성, 부분함수종속성, 이행적함수종속성으로 나누어 기술하세요.
	완전 함수 종속성 : 릴레이션의 속성 A가 속성집합B 전체에 대해 함수적 종속이지만 
			속성집합B의 어떠한 부분 집합 C에 함수적 종속이 아닐때를 말한다
	부분 함수 종속성 : 릴레이션의 속성 A가 속성집합B 전체에 대해 함수적 종속이면서
			속성집합B의 부분집합에 함수적 종속일 때를 말한다
	이행적 함수 종속성 : 속성A -> B이고, B->C일 때 A->C를 만족하는 관계
	
	완전 함수 종속성 : 종속자가 기본키에만 종속되고 구성하는 모든 속성이
			기본키의 부분집합에 종속되는 경우 
			ex) 이벤트, 고객아이디 -> 이벤트당첨여부
	부분 함수 종속성 : 종속자가 다른 속성 혹은 기본키가 여러 개인 경우 특정
			기본키에 종속되는 경우
			ex) 이벤트, 고객아이디 -> 고객명 
2. 정규화의 개념을 기술하세요.
	함수 종속성을 이용해 정보의 중복과 이상현상이 발생하지 않는 올바른 릴레이션을 만들어가는 과정
	릴레이션의 속성집합은 연관성이 있는 속성들로만 구성되도록 관련없는 속성의 경우 별개의 릴레이션으로 나눔

3. 제1정규화, 제2정규화, 제3정규화, 보이스코드 정규화의 개념을 기술하세요.
	제 1정규화 : 릴레이션의 모든 값이 원자 값으로만 되어있는 정규형
	제 2정규화 : 기본키가 아닌 모든 속성이 기본키에 대해 완전 함수 종속성을 만족하는 정규형
	제 3정규화 : 릴레이션이 제 2정규형에 속하고, 기본키가 아닌 모든 속성이 
			기본키에 대해 이행적 종속을 만족하지 않는 정규형 
	BCNF(Boyce-Codd)정규화 : 릴레이션에서 결정자가 모두 후보키인 정규형
	
	제 1정규화 : 데이터가 원자성을 가지도록 처리. 복수의 속성값을 갖는 속성을 분리
	제 2정규화 : 주식별자에 종속적이지 않는 속성을 분리하는 것으로 완전 종속성 이외에
			부분 함수 종속성이나 종속적이지 않는 속성을 분리하는 것을 말한다
	제 3정규화 : 속성이 종속적인 속성의 분리로 함수 종속에서 다시 함수 종속적인 
			속성의 분리로 이행 함수 종속을 분리하는 것을 말한다
	BCNF정규화 : 다수의 주식별자 분리
	제 4정규화 : 다가 종속 속성분리
	제 5정규화 : 결합속성일 경우 두 개 이상의 N개로 분리한다
	
4. 식별자와 비식별자의 차이를 ERD 구성을 하여 기술하세요.
	(ERD 사진)
	
	식별자 : 해당 주키를 연관관계 테이블의 키로 설정할 때를 말한다
	비식별자 : 해당 주키로 연관관계 테이블의 키가 아닌 속성으로 설정할 때를 말한다
	
5. 아래와 같은 제2정규화가 끝난 릴레이션을 제3정규화를 처리하세요(ERD 및  sql 테이블 구성)
    학생명   점수   등급
    홍길동   90    A
    김길동   80    B
    마길동   80    B
    신길동   70    D
    오길동   55    F
    
    -- 범위로 등급을 결정하기 1:1, 1:다 관계를 설정하지 않고 분리한다
    -- ex) emp 테이블과 salgrade 테이블의 관계
    
    -- 학생 테이블 : 학생명, 점수
    create table normal_student_03
    as select stuname, stuscore from normal_student_02;
    
    -- 등급 테이블 :등급, 최소점수, 최고점수
    create table normal_grade_03
    as select stugrade, minScr, maxScr from normal_student_02;
 

    insert into normal_stusco_03 values('홍길동', 90);
    insert into normal_stusco_03 values('김길동', 80);
    insert into normal_stusco_03 values('마길동', 80);
    insert into normal_stusco_03 values('신길동', 75);
    insert into normal_stusco_03 values('오길동', 55);
    
    insert into normal_stugrd_03 values('A', 90, 100);
    insert into normal_stugrd_03 values('B', 80, 89);
    insert into normal_stugrd_03 values('D', 70, 79);
    insert into normal_stugrd_03 values('F', 0, 59);
    
    select a.*, grade, minScr, maxScr
    from normal_student_03 a, normal_grade_03 b
    where 
    
6. 3정규화가 끝난 릴레이션을 BCNF정규화를 처리하세요.(ERD 및 sql 테이블 구성)
    학생번호  담당교수번호  과목명
    S001    T001       컴퓨터공학
    S002    T001       데이터베이스개론
    S003    T002       알고리즘개론
    S004    T001       컴퓨터공학
    
    create table normal_stucls_04
    as select stuno, clstitle from normal_student_03;
    
    create table normal_clsteac_04
    as select distinct clstitle, teacno from normal_student_03;
    
    insert into normal_stucls_04 values('S001', '컴퓨터공학');
    insert into normal_stucls_04 values('S002', '데이터베이스개론');
    insert into normal_stucls_04 values('S003', '알고리즘개론');
    insert into normal_stucls_04 values('S004', '컴퓨터공학');
    
    insert into normal_clsteac_04 values('컴퓨터공학', 'T001');
    insert into normal_clsteac_04 values('데이터베이스개론', 'T001');
    insert into normal_clsteac_04 values('알고리즘개론', 'T002');
    
    
    
    -- 수강테이블 : 학생번호, 담당교수번호(fk)
    create table normal_classBCNF
    as select stuno, teacno from normal_student_03;
    
    -- 교수테이블 : 담당교수번호, 과목명
    create table normal_teacherBCNF
    as select teacno, clstitle from normal_student_03;
    
    select *
    from normal_classBCNF a, normal_teacherBCNF b
    where a.teacno = b.teacno;
    
    
~ 9:30 진행하겠습니다.


*/