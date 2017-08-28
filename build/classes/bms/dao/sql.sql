  create table book(
  isbn varchar2(100) primary key,
  title varchar2(200) not null,
  subtitle varchar2(200),
  author varchar2(10),
  trans varchar2(30),
  publisher varchar2(100),
  origin varchar2(200),
  price number(10) not null,
  count number(10) not null
  );
  
  create sequence b_seq 
  start with 1
  increment by 1
  maxvalue 99999;
  
  create table salesinfo(
  salesnum number(8) primary key,
  guestit varchar2(20) not null,
  salesday date default sysdate,
  isbn varchar2(100) not null,
  title varchar2(200) not null,
  price number(10) not null,
  salesstock number(4) not null,
  state varchar2(1),
  closing number(20)
  );
  
  create sequence s_seq 
  start with 1
  increment by 1
  maxvalue 99999;
  
  create table board(
  num number(5) primary key,
  writer varchar2(20) not null,
  subject varchar2(50) default '제목이 없습니다.',
  passwd varchar2(10) not null,
  contents varchar2(1000),
  readcnt number(5) default 0,
  ref number(5) default 0,
  ref_step number(5) default 0,
  ref_level number(5) default 0,
  reg_date timestamp default sysdate
  );
    
  create sequence bo_seq 
  start with 1
  increment by 1
  maxvalue 99999;
  
  create table guest(
  guestnum number(8) not null,
  guestid varchar(20) primary key,
  guestpw varchar(20) not null,
  guestname varchar(10) not null,
  guestbirth date,
  guestaddr varchar(200),
  guestemail varchar(50)
  );
  
  create sequence g_seq 
  start with 1
  increment by 1
  maxvalue 99999;

  insert guest(guestnum,guestid,guestpw,guestname) value(g_seq.nextval, host,host,host)
  