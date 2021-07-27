
/*

#데이터베이스 보안을 위한 권한 설정
1. 데이터 베이스 관리자는(DBA)는 사용자가 데이터베이스 객체(테이블, view, sequence..)에
 	대한 특정 권한을 가질 수 있게 하여, 다수의 사용자가 데이터베이스에 저장된 정보를 공유하면서도
 	정보에 대한 보안이 이루어지게 한다
2. DB서버에 접근시 필요한 사용자 계정/암호를 통해 로그인 인증을 받는다
3. 권한의 역할과 종류
	1) create user : 사용자를 새롭게 생성하는 권한
	2) drop user : 사용자를 삭제하는 권한 
	3) drop any table : 테이블을 삭제하는 권한
	4) query rewrite : 함수 기반 인덱스 생성 권한
	5) backup any table : 테이블 백업 권한
	
	6) create session : 데이터베이스에 접속할 수 있는 권한
	7) create table/view/sequence/procedure : 데이터베이스의
		객체들을 생성하는 권한
	8) resource : 여러 객체들을 생성/사용 가능한 권한
	9) dba : 관리자 권한으로 계정을 생성하고, 권한을 부여할 수 있는 권한 
		
		
#추가 사용자 생성하기
1. system 관리자 계정으로 접근하여 scott에 DBA 권한을 부여하여
	계정 생성과 권한 부여가 가능하게 하여야 한다.
2. 관리자 접근 권한 부여
	1) cmd : 권한 부여를 위해 cmd창을 연다
	2) sqlplus : DB에 접속하기 위해 sqlplus로 들어간다
	3) syste/1111 : 관리자 계정으로 접속 
	4) grant dba to scott; : scott 계정에 접근권한을 준다 
		한 후에 이클립스의 XE를 오른쪽 버튼을 누르고 검증/재검증 누르고 진행
	5) conn scott/tiger; : scott 계정으로 접속하는 것
		conn orauser01/user01; : orauser01 계정으로 접속
	
3. 사용자 생성
	create user 사용자명 indentified by 비밀번호;
4. 권한 부여 (접속 권한)
	grant 권한명 to 계정명;
	create session : 접속권한 

*/ 

-- 사용자 생성 : sqlplus에서도 생성 가능, 이클립스에서도 생성 가능
CREATE USER orauser01 IDENTIFIED BY user01;
GRANT create SESSION TO orauser01;


-- 응용) himan/7777 계정을 만들고 접속권한을 부여한 후 접속 확인하기 (4조)
CREATE USER himan IDENTIFIED BY 7777;
GRANT CREATE SESSION TO himan;

/*
#접속하는 방법
1. sqlplus
	user-name : 사용자
	password : 비밀번호 
	입력
2. conn 사용자/비밀번호
3. 현재 접속할 수 있는 계정
	system/1111
	scott/tiger

4. 사용자 생성 후 접속 권한 부여
	orauser01 생성 후 접속하기 위해서
	grant create session to himan;

#사용자 계정별로 자원에 대한 접근 권한 설정
1. 테이블 생성 권한 부여
	grant create table to 계정명;
	ex) grant create table to orauser01;
2. 전체 oracle에서 사용되는 여러객체 (테이블, 인덱스, 시퀀드 등등)에
	대한 권한 부여 
	grant resource to 계정명; 	
	
3. 전체적인 계정에 대한 권한 부여 내용 확인하는 테이블 
	dba_users 
4. 테이블(물리적으로 저장이 필요한 객체)은 tablespace라는 저장공간을 할당
	alter user 사용자명 default tablespace users; 
		- 사용자가 사용할 물리적 테이블스페이스 설정 
	alter user 사용자명 quote unlimited on users;
		- 사용자가 사용할 테이블스페이스의 용량 지정 	
		
		
#특정한 사용자가 테이블을 사용하기 위해
0. dba권한이 있는 권한자로 접속한 후에 진행
1. 계정 생성 : create user 사용자명 indentified by 비밀번호
2. 접속할 수 있는 권한 부여 : grant create session to 사용자명; 
3. 자원(테이블 등 여러객체)를 사용할 수 있는 권한 : grant resource to 사용자명;
4. 해당 사용자가 사용할 물리적 공간(tablespace) 설정 : 
	alter user 사용자명 default tablespace 테이블스페이명;
5. 사용자가 물리적 공간을 사용할 용량 설정 : 
	alter user 사용자명 quota 용량 on 테이블스페이명; 
			
	
	
#과제를 위한 계정 생성 
1. 계정 생성과 함께 접속, 자원 사용 권한 설정 
grant 권한1, 권한2, 권한3 .. to 사용자 identidied by 계정명;
	to scott identidied by tiger;
	
2. 생략가능
alter user scott default tablespace users;
alter user scott pemporary tablespace temp;

*/

-- 계정 생성 후 권한 부여 
CREATE USER goodman IDENTIFIED BY 8888;
GRANT CREATE SESSION TO goodman;
GRANT resource TO goodman;
-- 여기까지 진행하고 혹시모르니까 재연결하고 
-- cmd창에 goodman/8888 연결하면 연결됨! 

-- 테이블스페이스 생성 후 용량 설정
ALTER USER goodman DEFAULT tablespace users;
ALTER USER goodman quota unlimited ON users;



/*

#oracle 서버접속
1. 서버에서 계정 생성
2. 서버 vs 클라이언트 접속
	1) 서버는 식별되는 ip/port/sid  계정/비밀번호가 접속가능
		서버 ip 주소 : 211.63.89.68/1521/xe scott/tiger 
		내 ip : 192.168.0.73/1521/xe scott/tiger
	2) 클라이언트는 서버에 있는 위 정보를 기준으로 DB 서버에 접속을 한다.
	3) 서버 PC의 방화벽 풀기 : 
	
	푸는 순서 : 윈도우>설정>네트워크 및 인터넷> 
	방화벽~ > 고급설정>인바운드 규칙>새규칙> 규칙선택 후 특정 포트(오라클:1521) 
	>연결허용>다체크>이름 설정(오라클_1521) 
	>아웃바운드도 똑같이 설정 
	
	inbounce : 1521 port 열어줌
	outbounce : 1521 port 열어줌
	
	-> 조별로 특정 서버에 계정 생성, client로 접속 처리 
	
	
#서버 공유하는 법
1. 고정 ip 임대 (필수로 해야함)
2. 학원이나 집pc를 연동해서 서버로 설정. 임대한 고정 ip와 연동
3. 해당 server pc
	1) visual svn 설치(소스 공유)
	2) webserver tomcat (이클립스 안에서 설정)
	3) db server xe 설치
4. 외부에서 고정 ip로 어느 곳에서나 접속하여 개발할 수 있다.
*/