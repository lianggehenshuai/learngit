create database business;
use business;

	create table if not exists account(
	  id         int          primary key auto_increment,
	  username   varchar(20)   not null,
	  password   varchar(20)   not null,
	  ip         varchar(20)   not null,
	  logindate  bigint   
	);
	
	insert into account(username,password,ip,logindate) values("admin","admin","127.0.0.1",null);



-- ��Ʒ��
create table product(
	id 		int  		primary key auto_increment,		-- ��Ʒ��� ����
	pnamme  varchar(20) not null,
	cid     int  ,      -- ��� ����cate���е�cid
	pno     varchar(30),-- ����
	pic     varchar(100), -- ��ƷͼƬ
	price   double,   -- ��Ʒ�۸�
	online  int ,      -- 1:���� 0:����
	pdetail text		-- ��Ʒ����
);
insert into product(pnamme,cid,pno,pic,price,online,pdetail)values("ˮ��",29,"a0001","images/icon001.png",50.00,1,"����·���ÿ�");

-- ����
create table Cate(
	cid     int        primary key auto_increment,
	cname   varchar(20)  not null,
	pid     int
);
insert into Cate(cname,pid) values ("�·�",0);

-- ����
create table rule(
	id    int   primary key auto_increment,
	pid   int 	,-- ��Ʒid��������Ʒ���е�id
	size  varchar(20) -- �ߴ�
);

insert into rule (pid,size)values(1,"c33");
-- ��Ա��
--  ����ʺ���Ϣ
create table account_consume(
	id     int  primary key auto_increment,
	loginname varchar(50) not null,
	password varchar(50),
	registertime bigint, -- ע��ʱ��
	lastLogintime bigint,  -- ����¼ʱ��
	ip            varchar(20) -- ip��ַ
);

insert into account_consume(loginname,password,registertime,lastLogintime,ip)values(?,?,?,?,?);
-- ��ҹ�����Ϣ

create table shoppingInfo_consumer(
	id        int      primary key auto_increment,
	aid       int      ,-- ����ʺ�id,����account_consume���е�id
	nickname  varchar(20) ,-- �û��ǳ�
	money	  double,  -- �������
	lasttime  bigint   -- �������
);


-- ���� 
-- �����ʺ���Ϣ
create table account_product(
	id       int   primary key auto_increment,
	loginname  varchar(50) not null,
	password   varchar(50),
	registertime bigint,   -- ע��ʱ��
	lastlogintime bigint ,-- ����¼ʱ��
	ip     varchar(20) -- ip��ַ
);



-- ��ַ��,���ͻ�ѡ��
create table address(
	id      int    primary key auto_increment,
	provience varchar(20)    not null,  -- ʡ��
	city      varchar(40)    not null,   -- ����
	area      varchar(40)    not null  -- ��/��
);
insert into address(provience,city,area)values("ɽ��ʡ","������","������");
-- ����ջ���Ϣ��
create table aonsumer_addr(
	id    int     primary key auto_increment,
	name  varchar(20)  not null, -- �ջ�������
	addr  varchar(200)   not null, -- �ջ��˵�ַ
	phone  varchar(20)   not null, -- ��ϵ��ʽ
	provice  varchar(20)  ,-- ʡ��
	city  varchar(20), -- ��
	area varchar(40),  -- ��/��
	allAddr  varchar(200) -- ��ϸ��Ϣ
);
insert into aonsumer_addr(name,addr,phone,provice,city,area,allAddr) values("���","������","1326464646","������","������","�һ�Դ��","26");
select name,addr,phone,provice,city,area,allAddr from aonsumer_addr where name="���"
-- ������
create table orderinfo(
	id  int primary key auto_increment,  -- ����id
	orderno  varchar(50) not null, -- �������
	orderstatus int ,-- ����״̬  1:δ����2���Ѹ��� 3.�ѷ���  4�����
	paystatus   int,  -- 1.����֧��  2.����֧��  3.ƽ��
	ordertime bigint ,-- �µ�ʱ��
	paytime bigint ,-- ����ʱ��
	addrinfo  int, -- �ջ�����Ϣ:������aosumer_addr���е�id
	mash     varchar(200) -- ��ע��Ϣ
);
insert into orderinfo(orderno,orderstatus,paystatus,ordertime,paytime,addrinfo,mash)values("2005",2,2,6465454,5345544,5,"�治����");

-- ��Զ��ϵ  ��������Ʒ
create table product_orderInfo(
	orderid  int ,-- ����id ֵ����orderinfo���е�id
	productid int  , -- ��Ʒid��ֵ������product���е�id
	primary key(orderid,productid) -- ��������
);