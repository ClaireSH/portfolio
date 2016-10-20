create table member(
	id 			varchar2(20)	primary key,
	password	varchar2(20)	not null,
	name		varchar2(20)	not null,
	gender		varchar2(1)		not null,
	birth		date 			not null,
	email		varchar2(50)	not null,
	phone		varchar2(20) 	not null,
	resumeId	varchar2(20),	
	constraint fk_resumeid foreign key(resumeid) references resume(resumeid)
	
)

create table favoriteMember(	
	id						varchar2(20),	
	constraint fk_id foreign key(id) references member(id),
	acceptor				varchar2(20)	not null,
	favoriteCheck			boolean			default false,
	requestTimeStamp		date			not null,
	acknowledgeTimeStamp	date
)

create table resume(
	resumeId		varchar2(20)	primary key,
	orginalImgFile	varchar2(200),
	savedImgFile	varchar2(50),
	prTitle			varchar2(100),	
	prContent		varchar2(1000),
	academicBgId	varchar2(20),	
	constraint fk_academicBgId foreign key(academicbgId) references academicbg(academicbgId),
	careerId		varchar2(20),	
	constraint fk_careerId foreign key(careerId) references career(careerId),
	certificateId	varchar2(20),	
	constraint fk_certificateId foreign key(certificateId) references certificate(certificateId),
	projectCareerId	varchar2(20),	
	constraint fk_projectCareerId foreign key(projectCareerId) references certificate(projectCareerId)
)

create table academicBg(
	academicBgId	varchar2(20)	primary key,
	adminssionYear	varchar2(20),
	graduationYear	varchar2(20),
	schoolName		varchar2(50),
	major			varchar2(50),
	degree			varchar2(20),
	remarks			varchar2(20)		
)

create table career(
	careerId		varchar2(20)	primary key,
	joinYear		varchar2(20),
	retirementYear	varchar2(20),
	companyName		varchar2(50),
	businessType	varchar2(20),
	department		varchar2(50),
	position		varchar2(20)
)

create table certificate(
	certificateId	varchar2(20)	primary key,
	year			varchar2(20),
	month			varchar2(20),
	certificateName	varchar2(50),
	remarks			varchar2(20)
)

create table projectCareer(
	projectCareerID		varchar2(20)	primary key,
	projectName			varchar2(50),
	developmentPeriod	varchar2(50),
	duration			varchar2(20),
	language			varchar2(20),
	dbos				varchar2(20),
	etc					varchar2(20)
)



