create table member(
	memberId 	varchar2(20)	primary key,
	password	varchar2(20)	not null,
	name		varchar2(20)	not null,
	gender		varchar2(1)		not null,
	birth		date 			not null,
	email		varchar2(50)	not null,
	phone		varchar2(20) 	not null
	
)

select * from member;
insert into member values('lsh', '1234', '이수현', 'M', '1992-02-03', 'tooona@naver.com', '010-6486-7621', null);
insert into member values('kdb', '1234', '김디비', 'F', '1989-02-03', 'kdb@naver.com', '010-6486-7621', null);
insert into member values('jyp', '1234', '박진영', 'M', '1967-02-03', 'jyp@naver.com', '010-6486-7621', null);
insert into member values('kss', '1234', '김삼성', 'M', '1991-02-03', 'samsung@naver.com', '010-6486-7621', null);

create sequence RESUME_SEQ

create table favoriteMember(
	memberId 				varchar2(20),	
	constraint fk_favoriteMemeber_memberId foreign key(memberId) references member(memberId),
	acceptor 				varchar2(20) 	not null,
	favoriteCheck			varchar2(1)		default 'F',
	requestTimeStamp		date			not null,
	acknowledgeTimeStamp	date
)

create table resume(
	resumeId		varchar2(20)	primary key,
	memberId		varchar2(20),
	constraint fk_resume_memberId foreign key(memberId) references member(memberId),
	orginalImgFile	varchar2(200),
	savedImgFile	varchar2(50),
	prTitle			varchar2(100),	
	prContent		varchar2(1000)
)

create table academicBg(
	academicBgId	varchar2(20)	primary key,
	resumeId		varchar2(20),
	constraint fk_academicBg_resumeId foreign key(resumeId) references resume(resumeId),
	adminssionYear	varchar2(20),
	graduationYear	varchar2(20),
	schoolName		varchar2(50),
	major			varchar2(50),
	degree			varchar2(20),
	remarks			varchar2(20)		
)

create table career(
	careerId		varchar2(20)	primary key,
	resumeId		varchar2(20),
	constraint fk_career_resumeId foreign key(resumeId) references resume(resumeId),
	joinYear		varchar2(20),
	retirementYear	varchar2(20),
	companyName		varchar2(50),
	businessType	varchar2(20),
	department		varchar2(50),
	position		varchar2(20)
)

create table certificate(
	certificateId	varchar2(20)	primary key,
	resumeId		varchar2(20),
	constraint fk_certificate_resumeId foreign key(resumeId) references resume(resumeId),
	year			varchar2(20),
	month			varchar2(20),
	certificateName	varchar2(50),
	remarks			varchar2(20)
)

create table projectCareer(
	projectCareerID		varchar2(20)	primary key,
	resumeId		varchar2(20),
	constraint fk_projectCareer_resumeId foreign key(resumeId) references resume(resumeId),
	projectName			varchar2(50),
	developmentPeriod	varchar2(50),
	duration			varchar2(20),
	language			varchar2(20),
	dbos				varchar2(20),
	etc					varchar2(20)
)



