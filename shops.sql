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



-- 商品表
create table product(
	id 		int  		primary key auto_increment,		-- 商品编号 主键
	pnamme  varchar(20) not null,
	cid     int  ,      -- 外键 引自cate表中的cid
	pno     varchar(30),-- 货号
	pic     varchar(100), -- 商品图片
	price   double,   -- 商品价格
	online  int ,      -- 1:上线 0:下线
	pdetail text		-- 商品详情
);
insert into product(pnamme,cid,pno,pic,price,online,pdetail)values("水杯",29,"a0001","images/icon001.png",50.00,1,"这件衣服真好看");

-- 类别表
create table Cate(
	cid     int        primary key auto_increment,
	cname   varchar(20)  not null,
	pid     int
);
insert into Cate(cname,pid) values ("衣服",0);

-- 规格表
create table rule(
	id    int   primary key auto_increment,
	pid   int 	,-- 商品id，引用商品表中的id
	size  varchar(20) -- 尺寸
);

insert into rule (pid,size)values(1,"c33");
-- 会员表
--  买家帐号信息
create table account_consume(
	id     int  primary key auto_increment,
	loginname varchar(50) not null,
	password varchar(50),
	registertime bigint, -- 注册时间
	lastLogintime bigint,  -- 最后登录时间
	ip            varchar(20) -- ip地址
);

insert into account_consume(loginname,password,registertime,lastLogintime,ip)values(?,?,?,?,?);
-- 买家购物信息

create table shoppingInfo_consumer(
	id        int      primary key auto_increment,
	aid       int      ,-- 买家帐号id,依赖account_consume表中的id
	nickname  varchar(20) ,-- 用户昵称
	money	  double,  -- 订单金额
	lasttime  bigint   -- 最近消费
);


-- 卖家 
-- 卖家帐号信息
create table account_product(
	id       int   primary key auto_increment,
	loginname  varchar(50) not null,
	password   varchar(50),
	registertime bigint,   -- 注册时间
	lastlogintime bigint ,-- 最后登录时间
	ip     varchar(20) -- ip地址
);



-- 地址表,供客户选择
create table address(
	id      int    primary key auto_increment,
	provience varchar(20)    not null,  -- 省份
	city      varchar(40)    not null,   -- 城市
	area      varchar(40)    not null  -- 区/县
);
insert into address(provience,city,area)values("山西省","晋中市","寿阳县");
-- 买家收货信息表
create table aonsumer_addr(
	id    int     primary key auto_increment,
	name  varchar(20)  not null, -- 收货人姓名
	addr  varchar(200)   not null, -- 收货人地址
	phone  varchar(20)   not null, -- 联系方式
	provice  varchar(20)  ,-- 省份
	city  varchar(20), -- 市
	area varchar(40),  -- 区/县
	allAddr  varchar(200) -- 详细信息
);
insert into aonsumer_addr(name,addr,phone,provice,city,area,allAddr) values("李华栋","重庆市","1326464646","重庆市","酉阳县","桃花源村","26");
select name,addr,phone,provice,city,area,allAddr from aonsumer_addr where name="李华栋"
-- 订单表
create table orderinfo(
	id  int primary key auto_increment,  -- 订单id
	orderno  varchar(50) not null, -- 订单编号
	orderstatus int ,-- 订单状态  1:未付款2：已付款 3.已发货  4已完成
	paystatus   int,  -- 1.线上支付  2.线下支付  3.平邮
	ordertime bigint ,-- 下单时间
	paytime bigint ,-- 付款时间
	addrinfo  int, -- 收货人信息:引用子aosumer_addr表中的id
	mash     varchar(200) -- 备注信息
);
insert into orderinfo(orderno,orderstatus,paystatus,ordertime,paytime,addrinfo,mash)values("2005",2,2,6465454,5345544,5,"真不好玩");

-- 多对多关系  订单和商品
create table product_orderInfo(
	orderid  int ,-- 订单id 值引用orderinfo表中的id
	productid int  , -- 商品id，值引用子product表中的id
	primary key(orderid,productid) -- 联合主键
);