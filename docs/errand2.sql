# Host: localhost  (Version: 5.7.26)
# Date: 2022-07-05 23:48:34
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "login"
#

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '用户密码',
  `account` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  PRIMARY KEY (`account`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "login"
#

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('111','111');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;

#
# Structure for table "orderinfo"
#

DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `orderid` varchar(255) NOT NULL DEFAULT '' COMMENT '订单号',
  `account` varchar(255) NOT NULL DEFAULT '' COMMENT '发布者账号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `phone` varchar(255) NOT NULL DEFAULT '' COMMENT '联系电话',
  `address0` varchar(255) NOT NULL DEFAULT '' COMMENT '取件地点',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '件数',
  `address1` varchar(255) NOT NULL DEFAULT '' COMMENT '送达地点',
  `detail` varchar(255) DEFAULT '无备注' COMMENT '备注',
  `price` int(11) NOT NULL DEFAULT '0' COMMENT '赏金',
  PRIMARY KEY (`orderid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "orderinfo"
#

/*!40000 ALTER TABLE `orderinfo` DISABLE KEYS */;
INSERT INTO `orderinfo` VALUES ('1656260963285','3325','李四','13799533325','桂五',1,'桂三','无',3),('1656261279242','6005','超级大帅哥','13720850336','桂五韵达',2,'桂三115','无',5),('1656261377344','0336','大帅B','18144006005','西门',2,'桃六','无',5),('1656296184591','111','跑腿哥','782727','桂5',1,'桂三111','无',10);
/*!40000 ALTER TABLE `orderinfo` ENABLE KEYS */;

#
# Structure for table "userinfo"
#

DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `account` varchar(255) NOT NULL DEFAULT '',
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `gender` varchar(255) NOT NULL DEFAULT '' COMMENT '性别',
  `phone` varchar(255) NOT NULL DEFAULT '' COMMENT '手机号',
  `idnumber` varchar(255) NOT NULL DEFAULT '' COMMENT '身份证号',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "userinfo"
#

/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES ('1111','0336','大帅B','男','18144006005','3333333333333333','888'),('1656296121168','111','abc','男','11111111111','2222222222222222','111'),('2222','3325','李四','男','13799533325','1234567896543568','777'),('3333','6005','超级大帅哥','男','13720850336','1234567899876541','999');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
