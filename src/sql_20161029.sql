
delete from member; 
delete from resume;
delete from academicBg;
delete from career;
delete from certificate;
delete from projectCareer;

select * from member   


drop table member cascade constraints;
drop table resume cascade constraints;
drop table academicBg cascade constraints;
drop table career cascade constraints;
drop table certificate cascade constraints;
drop table projectCareer cascade constraints;

--테이블 삭제한 후 생성할 것!!
create table member(
	memberId 	varchar2(20)	primary key,
	password	varchar2(20)	not null,
	name		varchar2(20)	not null,
	gender		varchar2(1)		default '0',
	birth		date 			not null,
	email		varchar2(50)	not null,
	phone		varchar2(20) 	not null
	
);
create table resume(
	resumeId		varchar2(20)	primary key,
	memberId		varchar2(20),
	constraint fk_resume_memberId foreign key(memberId) references member(memberId) on delete cascade,
	originalImgFile	varchar2(200),
	savedImgFile	varchar2(50)
);

create table academicBg(
	academicBgId	varchar2(20)	primary key,
	resumeId		varchar2(20),
	constraint fk_academicBg_resumeId foreign key(resumeId) references resume(resumeId) on delete cascade,
	adminssionYear	varchar2(20),
	graduationYear	varchar2(20),
	schoolName		varchar2(50),
	major			varchar2(50),
	degree			varchar2(20),
	remarks			varchar2(20)		
);

create table career(
	careerId		varchar2(20)	primary key,
	resumeId		varchar2(20),
	constraint fk_career_resumeId foreign key(resumeId) references resume(resumeId) on delete cascade,
	joinYear		varchar2(20),
	retirementYear	varchar2(20),
	companyName		varchar2(50),
	businessType	varchar2(20),
	department		varchar2(50),
	position		varchar2(20)
);

create table certificate(
	certificateId	varchar2(20)	primary key,
	resumeId		varchar2(20),
	constraint fk_certificate_resumeId foreign key(resumeId) references resume(resumeId) on delete cascade,
	year			varchar2(20),
	month			varchar2(20),
	certificateName	varchar2(50),
	remarks			varchar2(20)
);

create table projectCareer(
	projectCareerID		varchar2(20)	primary key,
	resumeId			varchar2(20),
	constraint fk_projectCareer_resumeId foreign key(resumeId) references resume(resumeId) on delete cascade,
	projectName			varchar2(50),
	developmentPeriod	varchar2(50),
	duration			varchar2(20),
	language			varchar2(20),
	dbos				varchar2(20),
	etc					varchar2(20)
);




--//질문
drop table question cascade constraints
drop table answer cascade constraints
drop table pr cascade constraints

create table question(
	questionId			varchar2(20)	primary key,
	questionType		varchar2(20)	not null,
	question			varchar2(200) 	not null
);

--//답변
create table answer(	
	questionId			varchar2(20),
	constraint fk_answer_questionId foreign key(questionId) references question(questionId) on delete cascade,
	memberId			varchar2(20),
	constraint fk_answer_memberId foreign key(memberId) references member(memberId) on delete cascade,
	answer				varchar2(200)
);

create table MyCover(
	myCoverId			varchar2(20)	primary key,
	resumeId			varchar2(20),
	constraint fk_MyCover_resumeId foreign key(resumeId) references resume(resumeId) on delete cascade,
	versionName			varchar2(100)	not null,
	content				varchar2(3000)
);

create table Tag(
	tagName				varchar2(100),
	myCoverId			varchar2(20),
	constraint fk_Tag_myCoverId foreign key(myCoverId) references MyCover(myCoverId) on delete cascade
);

----------------------------------------------------------------------------------------------------------
보류 
----------------------------------------------------------------------------------------------------------
//자기소개
create table pr(
	prId 			varchar2(20)	primary key,
	resumeId		varchar2(20),
	constraint fk_pr_resumeId foreign key(resumeId) references resume(resumeId) on delete cascade,
	content		varchar2(2000)
);
----------------------------------------------------------------------------------------------------------
-- 더미데이터 -- 
----------------------------------------------------------------------------------------------------------

insert into question values('00000', '여가생활', '여가 생활은 잘 보내고 있니?');
insert into question values('00001', '여가생활', '여가 시간에는 주로 무엇을 하며 시간을 보내?');
insert into question values('00002', '여가생활', '"주어진 대답"의 좋은 점이 뭐라고 생각해?');
insert into question values('00003', '여가생활', '"주어진 대답" 으로 인해 네가 바뀐 부분은 뭐야?');
insert into question values('00004', '대학생활', '동아리나 클럽에 가입하고 있거나 계획이 있니?');
insert into question values('00005', '대학생활', '동아리나 클럽에?');
insert into question values('00006', '대학생활', '가입하고 있거나');
insert into question values('00007', '대학생활', '계획이 있니?');
insert into question values('00008', '대학생활', '동아리나 클럽에 가입하고 있거나 계획이 있니?');
insert into question values('00009', '대학생활', '동아리나 클럽에 가입하고 있거나 계획이 있니?');
insert into question values('00010', '대학생활', '동아리나 클럽에 가입하고 있거나 계획이 있니?');
insert into question values('00011', '대학생활', '동아리나 클럽에 가입하고 있거나 계획이 있니?');
insert into question values('00012', '대학생활', '동아리나 클럽에 가입하고 있거나 계획이 있니?');



insert into answer values('00000', 'admin', '응!');


insert into question values('1', '여가생활', '여가 시간에는 주로 무엇을 하며 시간을 보내?');
insert into question values('2', '여가생활', '"주어진 대답"의 좋은 점이 뭐라고 생각해?');
insert into question values('3', '여가생활', '"주어진 대답" 으로 인해 네가 바뀐 부분은 뭐야?');
insert into question values('4', '대학생활', '대학에서 동아리나 클럽에 가입한 적이 있어?');
insert into question values('5', '대학생활', '어떤 활동을 했어?');
insert into question values('6', '대학생활', '기억에 남는 활동은?');
insert into question values('7', '대학생활', '당신의 리더로서의 모습은?');
insert into question values('8', '대학생활', '당신의 팔로워로서의 모습은?');
insert into question values('9', '대학생활', '다시 동아리에 들어간다면?');

insert into member values('admin','admin','관리자','0',sysdate,'admin@admin.com','01012345678');

insert into answer values('1', 'admin', '데스티니 차일드');
insert into answer values('2', 'admin', '일러스트를 볼 수 있다');
insert into answer values('3', 'admin', '몰라');
insert into answer values('4', 'admin', '아직');
insert into answer values('5', 'admin', '아직이다');

delete from member where memberId = 'admin'

------------------------------------------------------------------------------------------------------------
--확인용
------------------------------------------------------------------------------------------------------------

insert into MyCover(myCoverId, resumeId, versionName, content) values('admin0000', 'admin', 'Name01', 'Hello!');
insert into MyCover(myCoverId, resumeId, versionName, content) values('admin0001', 'admin', 'Name02', 'Hello Java!');
insert into MyCover(myCoverId, resumeId, versionName, content) values('admin0002', 'admin', 'Name03', 'Hello Unity!');
insert into MyCover(myCoverId, resumeId, versionName, content) values('admin0003', 'admin', 'Name04', 'Hello C!');
 		
insert into tag values('여가생활', 'admin0000');
insert into tag values('취미', 'admin0000');
insert into tag values('활동', 'admin0000');
insert into tag values('취직', 'admin0000');

 select b.myCoverId, b.tagName 
 		 from MyCover a, Tag b
 		 where a.myCoverId = b.myCoverId and a.resumeId = 'admin'	
select *
		from answer
		where memberId = 'admin'
		order by questionId asc;

select *
from question
order by questionId asc;

select * from member

select * from answer
delete from answer where memberId = 'tooona'

select q.questionId, q.questionType, q.question, a.answer
from question q, answer a, member m
where q.questionId = a.questionId and a.memberId = m.memberId 
and m.memberId = 'tooona'
order by questionId asc;

select *
from question
order by questionId asc;

select * from member



--//테이블 삭제 (안되면 밑에서 부터 차례대로 삭제!!)
drop table member CASCADE CONSTRAINTS;
drop table favoriteMember CASCADE CONSTRAINTS;
drop table resume CASCADE CONSTRAINTS;
drop table pr CASCADE CONSTRAINTS;
drop table academicBg CASCADE CONSTRAINTS;
drop table career CASCADE CONSTRAINTS;
drop table certificate CASCADE CONSTRAINTS;
drop table projectCareer CASCADE CONSTRAINTS;

--//데이터 삭제 (안되면 밑에서 부터 차례대로 삭제!!)
delete from  member;
delete from  favoriteMember;
delete from  resume;
delete from  academicBg;
delete from  career;
delete from  certificate;
delete from  projectCareer;
delete from  question;
delete from  answer;

select * from career
select * from member
select * from resume 
select * from academicbg;
select * from career 
select * from projectCareer where resumeId = '1a';


--친구추가 쿼리 -- 
--create table favoriteMember(
--	memberId 				varchar2(20),	
--	constraint fk_favoriteMemeber_memberId foreign key(memberId) references member(memberId) on delete cascade,
--	acceptor 				varchar2(20) 	not null,
--	favoriteCheck			varchar2(1)		default '0',
--	requestTimeStamp		date			not null,
--	acknowledgeTimeStamp	date
--);
