# Host: 127.0.0.1  (Version 5.6.26-log)
# Date: 2017-06-26 11:40:28
# Generator: MySQL-Front 5.4  (Build 4.153) - http://www.mysqlfront.de/

/*!40101 SET NAMES utf8 */;

#
# Structure for table "commodity"
#

DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `seller_id` int(11) NOT NULL COMMENT '卖家id',
  `picture` varchar(100) DEFAULT NULL COMMENT '主图',
  `name` varchar(25) NOT NULL COMMENT '商品名称',
  `starttime` datetime DEFAULT NULL COMMENT '开始秒杀时间',
  `postage` decimal(10,2) DEFAULT '0.00' COMMENT '邮费',
  `price` decimal(10,2) DEFAULT '-1.00' COMMENT '价格',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `seller_id` (`seller_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3619 DEFAULT CHARSET=utf8 COMMENT='普通商品表';

#
# Structure for table "description"
#

DROP TABLE IF EXISTS `description`;
CREATE TABLE `description` (
  `commodity_id` int(11) NOT NULL DEFAULT '0' COMMENT '商品id',
  `description` longtext COMMENT '商品描述',
  PRIMARY KEY (`commodity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品详情';

#
# Structure for table "member"
#

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `name` varchar(25) NOT NULL DEFAULT '' COMMENT '用户名',
  `passwd` varchar(25) NOT NULL DEFAULT '123456' COMMENT '密码',
  `seller_state` int(1) NOT NULL DEFAULT '0' COMMENT '卖家状态（0:买家，1:卖家）',
  `shop_name` varchar(25) DEFAULT NULL COMMENT '店铺名称',
  `balance` decimal(10,2) DEFAULT '10000000.00' COMMENT '余额',
  `address` varchar(50) DEFAULT '' COMMENT '买家地址',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='会员表';

#
# Structure for table "orders"
#

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '订单id',
  `commodity_id` int(11) NOT NULL COMMENT '商品id',
  `quantum` int(11) NOT NULL DEFAULT '0' COMMENT '商品数量',
  `seller_id` int(11) NOT NULL COMMENT '卖家id',
  `buyers_id` int(11) NOT NULL COMMENT '买家id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建日期',
  `order_status` int(1) NOT NULL DEFAULT '0' COMMENT '订单状态（0:未付款，1:已付款，）',
  `sum` decimal(10,2) DEFAULT '-1.00' COMMENT '总金额（包含邮费）',
  `address` varchar(50) DEFAULT '' COMMENT '发货地址',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `sellerid` (`seller_id`),
  KEY `buyers_id` (`buyers_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='订单表';

#
# Structure for table "shopping"
#

DROP TABLE IF EXISTS `shopping`;
CREATE TABLE `shopping` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `seller_id` int(11) DEFAULT NULL COMMENT '卖家id',
  `buyers_id` int(11) DEFAULT NULL COMMENT '买家id',
  `commodity_id` int(11) DEFAULT NULL COMMENT '商品id',
  `quantum` int(11) NOT NULL DEFAULT '0' COMMENT '商品数量',
  `shopName` varchar(25) DEFAULT NULL COMMENT '店铺名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='购物车';

#
# Structure for table "stock"
#

DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `commodity_id` int(11) NOT NULL DEFAULT '0' COMMENT '商品id',
  `stock` int(11) NOT NULL DEFAULT '0' COMMENT '库存',
  PRIMARY KEY (`commodity_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='商品库存';
