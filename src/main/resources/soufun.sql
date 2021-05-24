-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.40-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  10.2.0.5717
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 soufun 的数据库结构
CREATE DATABASE IF NOT EXISTS `soufun` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `soufun`;

-- 导出  表 soufun.house 结构
CREATE TABLE IF NOT EXISTS `house` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'house唯一标识',
  `title` varchar(32) NOT NULL,
  `price` decimal(10,0) unsigned NOT NULL DEFAULT '0' COMMENT '价格',
  `area` int(11) unsigned NOT NULL COMMENT '面积',
  `room` int(11) unsigned NOT NULL COMMENT '卧室数量',
  `floor` int(11) unsigned NOT NULL COMMENT '楼层',
  `total_floor` int(11) unsigned NOT NULL COMMENT '总楼层',
  `watch_times` int(11) unsigned DEFAULT '0' COMMENT '被看次数',
  `build_year` int(4) NOT NULL COMMENT '建立年限',
  `status` int(4) unsigned NOT NULL DEFAULT '0' COMMENT '房屋状态 0-未审核 1-审核通过 2-已出租 3-逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_update_time` datetime NOT NULL COMMENT '最近数据更新时间',
  `city_en_name` varchar(32) NOT NULL COMMENT '城市标记缩写 如 北京bj',
  `region_en_name` varchar(255) NOT NULL COMMENT '地区英文简写 如昌平区 cpq',
  `cover` varchar(32) DEFAULT NULL COMMENT '封面',
  `direction` int(11) NOT NULL COMMENT '房屋朝向',
  `distance_to_subway` int(11) NOT NULL DEFAULT '-1' COMMENT '距地铁距离 默认-1 附近无地铁',
  `parlour` int(11) NOT NULL DEFAULT '0' COMMENT '客厅数量',
  `district` varchar(32) NOT NULL COMMENT '所在小区',
  `admin_id` int(11) NOT NULL COMMENT '所属管理员id',
  `bathroom` int(11) NOT NULL DEFAULT '0',
  `street` varchar(32) NOT NULL COMMENT '街道',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COMMENT='房屋信息表';

-- 正在导出表  soufun.house 的数据：~15 rows (大约)
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
INSERT INTO `house` (`id`, `title`, `price`, `area`, `room`, `floor`, `total_floor`, `watch_times`, `build_year`, `status`, `create_time`, `last_update_time`, `city_en_name`, `region_en_name`, `cover`, `direction`, `distance_to_subway`, `parlour`, `district`, `admin_id`, `bathroom`, `street`) VALUES
	(15, '富力城 国贸CBD 时尚休闲 商务办公', 6200, 70, 2, 10, 20, 2, 2005, 2, '2017-09-06 18:56:14', '2017-12-03 11:13:46', 'bj', 'hdq', '40287781794f4cd601794ff2dced0000', 2, 10, 1, '融泽嘉园', 2, 0, '龙域西二路'),
	(16, '富力城 国贸CBD 时尚休闲 商务办公', 6300, 70, 2, 10, 20, 0, 2012, 2, '2017-09-06 19:53:35', '2017-12-03 11:13:42', 'bj', 'hdq', '40287781794f4cd601794ff2dced0000', 1, -1, 1, '融泽嘉园', 2, 0, '龙域西二路'),
	(17, '二环东直门地铁站附近、王府井、天安门、国贸、三里屯、南锣鼓巷', 3000, 35, 1, 5, 10, 2, 2013, 1, '2017-09-06 20:45:35', '2017-12-03 11:13:36', 'bj', 'hdq', '40287781794f4cd601794ff2dced0000', 1, 200, 0, '融泽嘉园', 2, 0, '龙域西二路'),
	(18, '华贸城 东向一居挑空loft 干净温馨 随时可以签约', 5700, 52, 1, 7, 20, 0, 2012, 1, '2017-09-06 21:01:02', '2017-12-03 11:13:30', 'bj', 'hdq', '40287781794f4cd601794ff2dced0000', 2, 1085, 1, '融泽嘉园', 2, 0, '龙域西二路'),
	(19, '望春园板楼三居室 自住精装 南北通透 采光好视野棒！', 9200, 132, 3, 6, 14, 0, 2005, 1, '2017-09-06 22:44:25', '2017-12-03 11:13:25', 'bj', 'hdq', '40287781794f4cd601794ff2dced0000', 2, 1108, 2, '融泽嘉园', 2, 0, '龙域西二路'),
	(20, '高大上的整租两居室 业主诚意出租', 5400, 56, 2, 12, 20, 0, 2012, 1, '2017-09-06 23:39:50', '2017-12-03 11:13:20', 'bj', 'hdq', '40287781794f4cd601794ff2dced0000', 2, -1, 1, '融泽嘉园', 2, 0, '龙域西二路'),
	(21, '新康园 正规三居室 精装修 家电家具齐全', 1900, 18, 1, 13, 25, 0, 2012, 1, '2017-09-07 00:52:47', '2017-12-03 11:13:15', 'bj', 'hdq', '40287781794f4cd601794ff2dced0000', 3, 1302, 0, '融泽嘉园', 2, 0, '龙域西二路'),
	(24, '湖光壹号望京华府183-387㎡阔景大宅', 50000, 288, 5, 1, 1, 0, 2015, 2, '2017-09-07 11:42:20', '2017-12-03 11:13:10', 'bj', 'hdq', '40287781794f4cd601794ff2dced0000', 5, 200, 3, '融泽嘉园', 2, 0, '龙域西二路'),
	(25, '测试房源-编辑', 3000, 59, 2, 10, 20, 0, 2010, 3, '2017-10-28 22:34:48', '2017-11-11 12:22:50', 'bj', 'cpq', '40287781794f4cd601794ff2dced0000', 2, 1000, 1, '融泽嘉园', 2, 0, '龙域中街'),
	(26, '1', 1, 1, 1, 1, 1, 0, 2019, 3, '2021-05-09 15:07:54', '2021-05-09 15:07:54', 'bj', 'xcq', '40287781794f4cd601794ff2dced0000', 2, 111, 0, '1', 2, 0, '1'),
	(30, '1', 1, 1, 1, 1, 1, NULL, 2019, 0, '2021-05-13 20:02:24', '2021-05-13 20:02:24', 'bj', 'dcq', '40287781796593940179659430270000', 2, 11, 0, '1', 2, 0, '1'),
	(31, '2', 2, 2, 2, 2, 2, NULL, 2019, 0, '2021-05-16 17:17:29', '2021-05-16 17:17:29', 'bj', 'xcq', '4028778179746da3017974774c460000', 2, 10, 2, '2', 2, 0, '2'),
	(32, '2', 2, 2, 2, 2, 2, NULL, 2019, 0, '2021-05-16 17:19:01', '2021-05-16 17:19:01', 'bj', 'xcq', '4028778179746da3017974774c460000', 2, 10, 2, '2', 2, 0, '2'),
	(33, '2', 2, 3, 2, 2, 2, NULL, 2019, 1, '2021-05-16 17:19:02', '2021-05-17 20:55:29', 'bj', 'xcq', '4028778179746da3017974774c460000', 2, 10, 2, '2', 2, 0, '2'),
	(34, '2', 2, 2, 2, 2, 2, NULL, 2019, 3, '2021-05-16 17:19:06', '2021-05-16 17:19:06', 'bj', 'xcq', '90', 2, 10, 2, '2', 2, 0, '2');
/*!40000 ALTER TABLE `house` ENABLE KEYS */;

-- 导出  表 soufun.house_area 结构
CREATE TABLE IF NOT EXISTS `house_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `min` int(11) unsigned NOT NULL COMMENT '最小值',
  `max` int(11) unsigned NOT NULL COMMENT '最大值',
  `sort` int(11) NOT NULL COMMENT '排序值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='房源面积表';

-- 正在导出表  soufun.house_area 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `house_area` DISABLE KEYS */;
INSERT INTO `house_area` (`id`, `name`, `min`, `max`, `sort`) VALUES
	(1, '0~90', 0, 90, 1);
/*!40000 ALTER TABLE `house_area` ENABLE KEYS */;

-- 导出  表 soufun.house_detail 结构
CREATE TABLE IF NOT EXISTS `house_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL COMMENT '详细描述',
  `layout_desc` varchar(255) DEFAULT NULL COMMENT '户型介绍',
  `traffic` varchar(255) DEFAULT NULL COMMENT '交通出行',
  `round_service` varchar(255) DEFAULT NULL COMMENT '周边配套',
  `rent_way` int(2) NOT NULL COMMENT '租赁方式',
  `address` varchar(32) NOT NULL COMMENT '详细地址 ',
  `subway_line_id` int(11) DEFAULT NULL COMMENT '附近地铁线id',
  `subway_line_name` varchar(32) DEFAULT NULL COMMENT '附近地铁线名称',
  `subway_station_id` int(11) DEFAULT NULL COMMENT '地铁站id',
  `subway_station_name` varchar(32) DEFAULT NULL COMMENT '地铁站名',
  `house_id` int(11) NOT NULL COMMENT '对应house的id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_on_house_id` (`house_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  soufun.house_detail 的数据：~14 rows (大约)
/*!40000 ALTER TABLE `house_detail` DISABLE KEYS */;
INSERT INTO `house_detail` (`id`, `description`, `layout_desc`, `traffic`, `round_service`, `rent_way`, `address`, `subway_line_id`, `subway_line_name`, `subway_station_id`, `subway_station_name`, `house_id`) VALUES
	(21, '国贸CBD商务区,近SOHO现代城,富顿中心,富力城商业街区,乐成中心,潘家园古玩城,八王坟长途客运站,北京游乐园,经由三环路可直达首都机场。附近有双井桥南,双井桥北,双井桥东双井桥西等30多条公交站牌!\n《天安门,故宫,王府井,三里屯,前门,天坛,北海,颐和园,雍和宫,奥林匹克公园,水立方,西单,欢乐谷,燕莎商城等》知名购物区及旅游名胜古迹,是您休闲旅游及商务下榻的理想选择', '房间采光良好,落地窗外景色宜人', '房子处于北京的CBD商务中心区国贸双井!紧邻双井地铁站,步行5分钟即到!这离国贸、中央电视台、潘家园、三里屯、团结湖、日坛使馆区、儿研所、大郊亭都很近', '房子闹中取静,地理位置优越,交通方便,紧邻呼家楼地铁站和东大桥地铁站;去机场可乘坐东直门机场快轨,非常方便｡购物中心有双井购物中心、国贸购物中心和侨福芳草地购物中心、三里屯购物中心等,远道而来的朋友可尽览都市璀璨!', 0, '二号院7号楼', 4, '10号线', 58, '双井', 15),
	(22, '国贸CBD商务区,近SOHO现代城,富顿中心,富力城商业街区,乐成中心,潘家园古玩城,八王坟长途客运站,北京游乐园,经由三环路可直达首都机场。附近有双井桥南,双井桥北,双井桥东双井桥西等30多条公交站牌!\n《天安门,故宫,王府井,三里屯,前门,天坛,北海,颐和园,雍和宫,奥林匹克公园,水立方,西单,欢乐谷,燕莎商城等》知名购物区及旅游名胜古迹,是您休闲旅游及商务下榻的理想选择!', '房间采光良好,落地窗外景色宜人', '房子处于北京的CBD商务中心区国贸双井!紧邻双井地铁站,步行5分钟即到', '这离国贸、中央电视台、潘家园、三里屯、团结湖、日坛使馆区、儿研所、大郊亭都很近。房子闹中取静,地理位置优越,交通方便,紧邻呼家楼地铁站和东大桥地铁站;去机场可乘坐东直门机场快轨,非常方便｡购物中心有双井购物中心、国贸购物中心和侨福芳草地购物中心、三里屯购物中心等,远道而来的朋友可尽览都市璀璨！', 0, '1号院1号楼', 1, '13号线', 5, '上地', 16),
	(24, '我和我女盆友当房东已经一年了,也是超赞房东,希望能为大家提供舒适的住所~ 房间的大门和房门都是密码门,小区有保安24小时值班,非常安全方便。 通常入住时间是下午三点,提前来的同学可以先寄存行李和洗澡哦~\n\n', '房間非常漂亮,空間很大,鵝黃色的牆壁看起來非常舒服', '位置距離地鐵站不遠', '距故宫、天安门、王府井、三里屯、簋街、南锣鼓巷等景点均可地铁半小时内到达,交通便利~', 0, '1号院2号楼', 1, '13号线', 16, '东直门', 17),
	(25, '这个经纪人很懒，没写核心卖点', '此房是一居室的格局，上下两层，面宽，房间亮堂，进门右手厨房，正前方是25平米的客厅，楼上是卧室，带洗手间！ 喧闹和安静隔开，适合居住', '小区距离地铁13号线北苑站500米的距离，交通出行便利....', '小区楼下就是华贸天地娱乐街，保利电影院，眉州东坡，中信银行，麦当劳等娱乐休闲设施齐全', 0, '1号院3号楼', 1, '13号线', 11, '北苑', 18),
	(26, '这个经纪人很懒，没写核心卖点', '此房为望春园小区板楼南北通透户型，主卧客厅朝南，次卧朝北，两个客厅双卫，居住很舒适。', '距离地铁5号线立水桥南站630米，有464,465,966,081，621等多条公交线路，交通出行四通八达。', '小区旁有大型购物商场易事达，物美超市，丰宁蔬菜基地，航空总医院、安贞医院北苑分院，中国银行、中国农业银行、中国工商银行、中国交通银行、中国建设银行、招商银行分布。小区旁有天奥健身房，还有立水桥公园..', 0, '6号院1号楼', 1, '13号线', 10, '立水桥', 19),
	(27, '高大上的整租两居室 业主诚意出租\n1、客厅挑高、宽敞舒适、阳光充足 2、卧室搭配的很新颖，使用之高 3、厨房带阳台，让您和家人有足够的空间展现私家厨艺', '客厅挑高、宽敞舒适、阳光充足 2、卧室搭配的很新颖，使用之高 3、厨房带阳台，让您和家人有足够的空间展现私家厨艺', '近地铁13号线东直门站', '社区环境好，环境优美，适宜居住，人文素质高，物业管理完善； 2、属于低密度社区 ，适宜居住 3、小区的林密树多，让您感受花园一样的家', 0, '1号院5号楼', 1, '13号线', 16, '东直门', 20),
	(28, '房子是正规三室一厅一厨一卫，装修保持的不错，家电家具都齐全。\n', '房子客厅朝北面积比较大，主卧西南朝向，次卧朝北，另一个次卧朝西，两个次卧面积差不多大。', '小区出南门到8号线育新地铁站614米，交通便利，小区500米范围内有物美，三旗百汇，龙旗广场等几个比较大的商场，生活购物便利，出小区北门朝东952米是地铁霍营站，是8号线和 13号线的换乘站，同时还有个S2线，通往怀来。（数据来源百度地图）', '小区西边300米就是物美超市和三旗百汇市场（日常百货、粮油米面、瓜果蔬菜、生鲜海货等等，日常生活很便利，消费成本低），北边200米是龙旗购物广场和永辉超市（保利影院，KFC，麦当劳等，轻松满足娱乐消费）。小区里还有商店，饭店，家政等。', 0, '2号院1号楼', 1, '13号线', 9, '霍营', 21),
	(31, '懒死了 不谢', '户型介绍', '交通出行', '周边配套', 0, '3号院1号楼', 1, '13号线', 12, '望京西', 24),
	(32, '房屋描述-编辑', '户型介绍', '交通出行', '周边配套-编辑', 0, '3号院2单元1003', 1, '13号线', 8, '回龙观', 25),
	(36, '1', '1', '1', '1', 0, '1', 1, '13号线', 13, '上地', 30),
	(37, 'hhhhhh', '2', '2', '2', 0, '2', 4, '三元桥', 51, NULL, 31),
	(38, 'hhhhhh', '2', '2', '2', 0, '2', 4, '三元桥', 51, NULL, 32),
	(39, 'hhhhhh', '2', '2', '2', 0, '2', 4, NULL, 51, NULL, 33),
	(40, 'hhhhhh', '2', '2', '2', 0, '2', 4, '三元桥', 51, NULL, 34);
/*!40000 ALTER TABLE `house_detail` ENABLE KEYS */;

-- 导出  表 soufun.house_picture 结构
CREATE TABLE IF NOT EXISTS `house_picture` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `house_id` int(11) NOT NULL COMMENT '所属房屋id',
  `width` int(11) DEFAULT NULL COMMENT '宽',
  `height` int(11) DEFAULT NULL COMMENT '高',
  `path` varchar(255) NOT NULL COMMENT '文件名',
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COMMENT='房屋图片信息';

-- 正在导出表  soufun.house_picture 的数据：~22 rows (大约)
/*!40000 ALTER TABLE `house_picture` DISABLE KEYS */;
INSERT INTO `house_picture` (`id`, `house_id`, `width`, `height`, `path`, `location`) VALUES
	(68, 19, 911, 683, 'Fp1xPKVYtPsCeVHVQVW0Hif2FXk7', NULL),
	(69, 19, 1012, 683, 'Fn371N5gLsJvjuIRC4IHjPtMy61h', NULL),
	(70, 24, 1280, 960, 'Fn1AGNmZfadCIVTJA33gByg6a33B', NULL),
	(71, 24, 1024, 683, 'FlgoAylUv1ilx1SAtxSyBCJF3bwb', NULL),
	(72, 21, 1024, 683, 'FnuOFbFtDYTbpPdFoZthR-R0tszC', NULL),
	(73, 21, 455, 683, 'FhCiRnyCDQ-O6pXusu5ftmZkIh0-', NULL),
	(74, 20, 1024, 683, 'FvVqU8LneZZ5xaLBAOM1KXR2Pz1X', NULL),
	(75, 20, 1024, 683, 'FtNl9uPM6p5PjEs8z2FnOuViNtOM', NULL),
	(76, 18, 1440, 960, 'FgcD3BufAprERe5y3Gd-Mezu5VAy', NULL),
	(77, 18, 1024, 683, 'Fl1lNikhmMIecbTn-JTsurxugtFU', NULL),
	(78, 17, 1024, 683, 'FvVHtS1qAApFFh6k5LMDm5tliufK', NULL),
	(79, 17, 1024, 683, 'FpVYJRsLykrBRyUSCEOeqsqWU-bt', NULL),
	(80, 16, 1024, 683, 'Fhysh6EcQ_ZTl-jdGe2zaCFi5Uvm', NULL),
	(81, 16, 1024, 683, 'Fvb9TDMRtl1haBj9gK9C0k43X0u0', NULL),
	(82, 16, 1024, 683, 'FvkO1FFyGbrxCP_1O9tA94u2qvbP', NULL),
	(83, 15, 1024, 683, 'FsxiS6rOTpSg5pK7tv41e8Zpnn_c', NULL),
	(84, 15, 1024, 683, 'FpOKJ2IEmbA1y1RbIqgZfqFKkJyS', NULL),
	(85, 15, 1440, 960, 'Fhxz_c16YmEmIz5UVxrp6ihwbvCk', NULL),
	(86, 30, 120, 100, 'http://localhost:8131/upload/40287781796593940179659430270000', NULL),
	(87, 31, 120, 100, 'http://localhost:8131/upload/4028778179746da3017974774c460000', NULL),
	(88, 32, 120, 100, 'http://localhost:8131/upload/4028778179746da3017974774c460000', NULL),
	(89, 33, 120, 100, 'http://localhost:8131/upload/4028778179746da3017974774c460000', NULL);
/*!40000 ALTER TABLE `house_picture` ENABLE KEYS */;

-- 导出  表 soufun.house_subscribe 结构
CREATE TABLE IF NOT EXISTS `house_subscribe` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `house_id` int(11) NOT NULL COMMENT '房源id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `desc` varchar(255) DEFAULT NULL COMMENT '用户描述',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '预约状态 1-加入待看清单 2-已预约看房时间 3-看房完成',
  `create_time` datetime NOT NULL COMMENT '数据创建时间',
  `last_update_time` datetime NOT NULL COMMENT '记录更新时间',
  `order_time` datetime DEFAULT NULL COMMENT '预约时间',
  `telephone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `admin_id` int(11) NOT NULL COMMENT '房源发布者id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_on_user_and_house` (`house_id`,`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='预约看房信息表';

-- 正在导出表  soufun.house_subscribe 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `house_subscribe` DISABLE KEYS */;
INSERT INTO `house_subscribe` (`id`, `house_id`, `user_id`, `desc`, `status`, `create_time`, `last_update_time`, `order_time`, `telephone`, `admin_id`) VALUES
	(9, 17, 1, NULL, 3, '2017-11-26 11:06:23', '2017-12-02 09:21:01', '2017-12-03 00:00:00', '13888888888', 2);
/*!40000 ALTER TABLE `house_subscribe` ENABLE KEYS */;

-- 导出  表 soufun.house_tag 结构
CREATE TABLE IF NOT EXISTS `house_tag` (
  `house_id` int(11) NOT NULL COMMENT '房屋id',
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_on_house_id_and_name` (`house_id`,`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COMMENT='房屋标签映射关系表';

-- 正在导出表  soufun.house_tag 的数据：~13 rows (大约)
/*!40000 ALTER TABLE `house_tag` DISABLE KEYS */;
INSERT INTO `house_tag` (`house_id`, `id`, `name`) VALUES
	(30, 3, '空调'),
	(30, 4, '精装修'),
	(30, 5, '随时看房'),
	(31, 6, '独立阳台'),
	(31, 7, '集体供暖'),
	(32, 8, '独立阳台'),
	(32, 9, '集体供暖'),
	(33, 14, '独立卫生间'),
	(33, 10, '独立阳台'),
	(33, 15, '精装修'),
	(33, 11, '集体供暖'),
	(34, 12, '独立阳台'),
	(34, 13, '集体供暖');
/*!40000 ALTER TABLE `house_tag` ENABLE KEYS */;

-- 导出  表 soufun.message 结构
CREATE TABLE IF NOT EXISTS `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL DEFAULT '' COMMENT '类型 create 创建 delete删除 ',
  `data` text NOT NULL COMMENT '数据',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态 0待发送 1已发送',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='消息表';

-- 正在导出表  soufun.message 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` (`id`, `type`, `data`, `status`, `create_time`, `update_time`) VALUES
	(1, 'DELETE', '34', 1, '2021-05-22 09:15:33', '2021-05-22 09:15:33'),
	(2, 'CREATE', '{"detail":{"description":"hhhhhh","detailAddress":"2","houseId":33,"id":39,"layoutDesc":"2","rentWay":0,"roundService":"2","subwayLineId":4,"subwayStationId":51,"traffic":"2"},"house":{"adminId":2,"area":3,"bathroom":0,"buildYear":2019,"cityEnName":"bj","cover":"4028778179746da3017974774c460000","createTime":1621156742000,"direction":2,"distanceToSubway":10,"district":"2","floor":2,"id":33,"lastUpdateTime":1621256129000,"parlour":2,"price":2,"regionEnName":"xcq","room":2,"status":0,"street":"2","title":"2","totalFloor":2},"pictures":[{"height":100,"houseId":33,"id":89,"path":"http://localhost:8131/upload/4028778179746da3017974774c460000","width":120}],"tags":[{"houseId":33,"id":14,"name":"独立卫生间"},{"houseId":33,"id":10,"name":"独立阳台"},{"houseId":33,"id":15,"name":"精装修"},{"houseId":33,"id":11,"name":"集体供暖"}]}', 1, '2021-05-22 12:21:55', '2021-05-22 12:21:55');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;

-- 导出  表 soufun.rental 结构
CREATE TABLE IF NOT EXISTS `rental` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `min` int(11) DEFAULT NULL COMMENT '最小值',
  `max` int(11) DEFAULT NULL COMMENT '最大值',
  `sort` int(11) NOT NULL COMMENT '排序值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='租金范围表';

-- 正在导出表  soufun.rental 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `rental` DISABLE KEYS */;
INSERT INTO `rental` (`id`, `name`, `min`, `max`, `sort`) VALUES
	(1, '0~100', 0, 100, 1);
/*!40000 ALTER TABLE `rental` ENABLE KEYS */;

-- 导出  表 soufun.role 结构
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL COMMENT '用户id',
  `name` varchar(32) NOT NULL COMMENT '用户角色名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_and_name` (`user_id`,`name`) USING BTREE,
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';

-- 正在导出表  soufun.role 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `user_id`, `name`) VALUES
	(1, 1, 'USER'),
	(2, 2, 'ADMIN'),
	(3, 3, 'USER'),
	(4, 4, 'USER'),
	(5, 5, 'USER'),
	(6, 6, 'USER'),
	(7, 7, 'USER'),
	(8, 8, 'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- 导出  表 soufun.room_config 结构
CREATE TABLE IF NOT EXISTS `room_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `type` varchar(20) NOT NULL,
  `value` int(11) NOT NULL,
  `sort` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='房间户型和朝向配置表';

-- 正在导出表  soufun.room_config 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `room_config` DISABLE KEYS */;
INSERT INTO `room_config` (`id`, `name`, `type`, `value`, `sort`) VALUES
	(1, '不限', 'housetype', 0, 0),
	(2, '一室', 'housetype', 1, 1),
	(3, '二室', 'housetype', 1, 2),
	(4, '不限', 'orientations', 0, 0),
	(5, '朝东', 'orientations', 1, 1);
/*!40000 ALTER TABLE `room_config` ENABLE KEYS */;

-- 导出  表 soufun.subway 结构
CREATE TABLE IF NOT EXISTS `subway` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '线路名',
  `city_en_name` varchar(32) NOT NULL COMMENT '所属城市英文名缩写',
  PRIMARY KEY (`id`),
  KEY `index_on_city` (`city_en_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  soufun.subway 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `subway` DISABLE KEYS */;
INSERT INTO `subway` (`id`, `name`, `city_en_name`) VALUES
	(1, '13号线', 'bj'),
	(2, '1号线', 'bj'),
	(3, '2号线', 'bj'),
	(4, '10号线', 'bj'),
	(5, '8号线', 'bj'),
	(6, '9号线', 'bj'),
	(7, '7号线', 'bj');
/*!40000 ALTER TABLE `subway` ENABLE KEYS */;

-- 导出  表 soufun.subway_station 结构
CREATE TABLE IF NOT EXISTS `subway_station` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `subway_id` int(11) NOT NULL COMMENT '所属地铁线id',
  `name` varchar(32) NOT NULL COMMENT '站点名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_station` (`subway_id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  soufun.subway_station 的数据：~62 rows (大约)
/*!40000 ALTER TABLE `subway_station` DISABLE KEYS */;
INSERT INTO `subway_station` (`id`, `subway_id`, `name`) VALUES
	(5, 1, '上地'),
	(16, 1, '东直门'),
	(4, 1, '五道口'),
	(14, 1, '光熙门'),
	(11, 1, '北苑'),
	(8, 1, '回龙观'),
	(2, 1, '大钟寺'),
	(12, 1, '望京西'),
	(15, 1, '柳芳'),
	(3, 1, '知春路'),
	(10, 1, '立水桥'),
	(13, 1, '芍药居'),
	(6, 1, '西二旗'),
	(1, 1, '西直门'),
	(9, 1, '霍营'),
	(7, 1, '龙泽'),
	(33, 4, '三元家庄'),
	(51, 4, '三元桥'),
	(41, 4, '丰台站'),
	(52, 4, '亮马桥'),
	(27, 4, '健德门'),
	(46, 4, '公主坟'),
	(44, 4, '六里桥'),
	(53, 4, '农业展览馆'),
	(62, 4, '分钟寺'),
	(59, 4, '劲松'),
	(28, 4, '北土城'),
	(61, 4, '十里河'),
	(58, 4, '双井'),
	(55, 4, '呼家楼'),
	(54, 4, '团结湖'),
	(57, 4, '国贸'),
	(35, 4, '大红门'),
	(32, 4, '太阳宫'),
	(29, 4, '安贞门'),
	(64, 4, '宋家庄'),
	(20, 4, '巴沟'),
	(30, 4, '惠新西街南口'),
	(48, 4, '慈寿寺'),
	(63, 4, '成寿寺'),
	(42, 4, '泥洼'),
	(22, 4, '海淀黄庄'),
	(60, 4, '潘家园'),
	(19, 4, '火器营'),
	(26, 4, '牡丹园'),
	(24, 4, '知春路'),
	(23, 4, '知春里'),
	(34, 4, '石榴庄'),
	(39, 4, '纪家庙'),
	(31, 4, '芍药居'),
	(21, 4, '苏州街'),
	(38, 4, '草桥'),
	(45, 4, '莲花桥'),
	(25, 4, '西土城'),
	(43, 4, '西局'),
	(47, 4, '西钓鱼台'),
	(36, 4, '角门东'),
	(37, 4, '角门西'),
	(17, 4, '车道沟'),
	(56, 4, '金台夕照'),
	(18, 4, '长春桥'),
	(40, 4, '首经贸');
/*!40000 ALTER TABLE `subway_station` ENABLE KEYS */;

-- 导出  表 soufun.support_address 结构
CREATE TABLE IF NOT EXISTS `support_address` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `belong_to` varchar(32) NOT NULL DEFAULT '0' COMMENT '上一级行政单位名',
  `en_name` varchar(32) NOT NULL COMMENT '行政单位英文名缩写',
  `cn_name` varchar(32) NOT NULL COMMENT '行政单位中文名',
  `level` varchar(16) NOT NULL COMMENT '行政级别 市-city 地区-region',
  `baidu_map_lng` double NOT NULL COMMENT '百度地图经度',
  `baidu_map_lat` double NOT NULL COMMENT '百度地图纬度',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_en_name_and_belong_to` (`en_name`,`level`,`belong_to`) USING BTREE COMMENT '每个城市的英文名都是独一无二的'
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  soufun.support_address 的数据：~15 rows (大约)
/*!40000 ALTER TABLE `support_address` DISABLE KEYS */;
INSERT INTO `support_address` (`id`, `belong_to`, `en_name`, `cn_name`, `level`, `baidu_map_lng`, `baidu_map_lat`) VALUES
	(4, 'bj', 'bj', '北京', 'city', 116.395645, 39.929986),
	(5, 'sh', 'sh', '上海', 'city', 121.487899, 31.249162),
	(6, 'hb', 'sjz', '石家庄', 'city', 114.522082, 38.048958),
	(7, 'hb', 'ts', '唐山', 'city', 118.183451, 39.650531),
	(8, 'hb', 'hd', '邯郸', 'city', 114.482694, 36.609308),
	(9, 'bj', 'dcq', '东城区', 'region', 116.42188470126446, 39.93857401298612),
	(10, 'bj', 'xcq', '西城区', 'region', 116.37319010401802, 39.93428014370851),
	(12, 'bj', 'hdq', '海淀区', 'region', 116.23967780102151, 40.03316204507791),
	(13, 'bj', 'cpq', '昌平区', 'region', 116.21645635689414, 40.2217235498323),
	(14, 'sh', 'ptq', '普陀区', 'region', 121.39844294374956, 31.263742929075534),
	(15, 'sjz', 'caq', '长安区', 'region', 114.59262155387033, 38.07687479578663),
	(16, 'sjz', 'qdq', '桥东区', 'region', 114.51078430496142, 38.06338975380927),
	(17, 'sjz', 'qxq', '桥西区', 'region', 114.43813995531943, 38.033364550068136),
	(18, 'sjz', 'xhq', '新华区', 'region', 114.4535014286928, 38.117218640478164),
	(19, 'bj', 'cyq', '朝阳区', 'region', 116.52169489108084, 39.95895316640668);
/*!40000 ALTER TABLE `support_address` ENABLE KEYS */;

-- 导出  表 soufun.upload_file 结构
CREATE TABLE IF NOT EXISTS `upload_file` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `suffix` varchar(50) NOT NULL COMMENT '后缀',
  `type` varchar(50) DEFAULT NULL COMMENT '类型',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `path` varchar(255) NOT NULL COMMENT '路径',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `valid` bit(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  soufun.upload_file 的数据：~43 rows (大约)
/*!40000 ALTER TABLE `upload_file` DISABLE KEYS */;
INSERT INTO `upload_file` (`id`, `name`, `remark`, `suffix`, `type`, `create_time`, `path`, `update_time`, `valid`) VALUES
	('40287781792305550179230567c10000', 'timg.jfif', NULL, 'jfif', 'picture', '2021-04-30 21:43:47', '', '2021-04-30 21:43:47', b'1'),
	('40287781793c3c2701793c3cab720000', 'timg.jfif', NULL, 'jfif', 'picture', '2021-05-05 19:14:39', 'd:/soufun/file//2021-05-05/33162639816100timg.jfif33162640314700timg.jfif', '2021-05-05 19:14:39', b'1'),
	('40287781793c3f9901793c47dc160000', 'timg.jfif', NULL, 'jfif', 'picture', '2021-05-05 19:26:52', 'd:/soufun/file//2021-05-05/33895987131100timg.jfif33895987302900timg.jfif', '2021-05-05 19:26:52', b'1'),
	('402877817946a208017946a29b360000', 'timg.jfif', NULL, 'jfif', 'picture', '2021-05-07 19:42:12', 'd:/soufun/file//2021-05-07/1506317800600timg.jfif1506318194400timg.jfif', '2021-05-07 19:42:12', b'1'),
	('402877817946a4cf017946a53b250000', 'timg.jfif', NULL, 'jfif', 'picture', '2021-05-07 19:45:04', 'd:/soufun/file//2021-05-07/1678327583100timg.jfif1678327785100timg.jfif', '2021-05-07 19:45:04', b'1'),
	('402877817946a4cf017946a8e0430001', 'timg.jfif', NULL, 'jfif', 'picture', '2021-05-07 19:49:03', 'd:/soufun/file//2021-05-07/1917222087500timg.jfif1917224023000timg.jfif', '2021-05-07 19:49:03', b'1'),
	('402877817946a4cf017946ad281f0002', 'timg.jfif', NULL, 'jfif', 'picture', '2021-05-07 19:53:43', 'd:/soufun/file//2021-05-07/2197751572499timg.jfif2197751801100timg.jfif', '2021-05-07 19:53:43', b'1'),
	('402877817946a4cf017946adc97f0003', 'timg.jfif', NULL, 'jfif', 'picture', '2021-05-07 19:54:25', 'd:/soufun/file//2021-05-07/2239061508500timg.jfif2239061774300timg.jfif', '2021-05-07 19:54:25', b'1'),
	('402877817946a4cf017946ae284b0004', '2239061508500timg.jfif2239061774300timg.jfif', NULL, 'jfif', 'picture', '2021-05-07 19:54:49', 'd:/soufun/file//2021-05-07/22633462053002239061508500timg.jfif2239061774300timg.jfif22633463767002239061508500timg.jfif2239061774300timg.jfif', '2021-05-07 19:54:49', b'1'),
	('402877817946b31c017946b384180000', '1678327583100timg.jfif1678327785100timg.jfif', NULL, 'jfif', 'picture', '2021-05-07 20:00:40', 'd:/soufun/file//2021-05-07/26145075377001678327583100timg.jfif1678327785100timg.jfif26145077573001678327583100timg.jfif1678327785100timg.jfif', '2021-05-07 20:00:40', b'1'),
	('40287781794ec8a801794ec990710000', '1917222087500timg.jfif1917224023000timg.jfif', NULL, 'jfif', 'picture', '2021-05-09 09:41:43', 'd:/soufun/file//2021-05-0910801927229001917222087500timg.jfif1917224023000timg.jfif', '2021-05-09 09:41:43', b'1'),
	('40287781794ecada01794ecb327c0000', '2197751572499timg.jfif2197751801100timg.jfif', NULL, 'jfif', 'picture', '2021-05-09 09:43:30', 'd:/soufun/file//2021-05-0911872055256002197751572499timg.jfif2197751801100timg.jfif', '2021-05-09 09:43:30', b'1'),
	('40287781794ecada01794ecb69210001', '1506317800600timg.jfif1506318194400timg.jfif', NULL, 'jfif', 'picture', '2021-05-09 09:43:44', 'd:/soufun/file//2021-05-0912012151695001506317800600timg.jfif1506318194400timg.jfif', '2021-05-09 09:43:44', b'1'),
	('40287781794ed14501794ed201d20000', '1506317800600timg.jfif1506318194400timg.jfif', NULL, 'jfif', 'picture', '2021-05-09 09:50:56', 'd:/soufun/file//2021-05-0916335012112001506317800600timg.jfif1506318194400timg.jfif', '2021-05-09 09:50:56', b'1'),
	('40287781794ed54101794ed59bf30000', 'timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 09:54:52', 'd:/soufun/file//2021-05-091869569772500timg.jfif', '2021-05-09 09:54:52', b'1'),
	('40287781794eddf601794edec5ce0000', '2021-05-091869569772500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 10:04:53', 'd:/soufun/file//2021-05-0924701174246002021-05-091869569772500timg.jfif', '2021-05-09 10:04:53', b'1'),
	('40287781794eddf601794ee12d410002', 'timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 10:07:30', 'd:/soufun/file//2021-05-092627676057000timg.jfif', '2021-05-09 10:07:30', b'1'),
	('40287781794ee2bf01794ee3230f0000', '2021-05-092627676057000timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 10:09:39', 'd:/soufun/file//2021-05-09/27561260178002021-05-092627676057000timg.jfif', '2021-05-09 10:09:39', b'1'),
	('40287781794ee5bf01794ee624360000', '27561260178002021-05-092627676057000timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 10:12:55', 'd:/soufun/file//2021-05-09/295302515640027561260178002021-05-092627676057000timg.jfif', '2021-05-09 10:12:55', b'1'),
	('40287781794ee5bf01794ee8c6d30001', 'timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 10:15:48', 'd:/soufun/file//2021-05-09/3125742102200timg.jfif', '2021-05-09 10:15:48', b'1'),
	('40287781794eea9f01794eeb41f90000', 'timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 10:18:31', 'd:/soufun/file//2021-05-09/3288325799500timg.jfif', '2021-05-09 10:18:31', b'1'),
	('40287781794eed2001794eed8b610000', 'timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 10:21:01', 'd:/soufun/file//2021-05-09/3438184528800timg.jfif', '2021-05-09 10:21:01', b'1'),
	('40287781794eed2001794eedde7e0001', '3288325799500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 10:21:22', 'd:/soufun/file//2021-05-09/34594798610003288325799500timg.jfif', '2021-05-09 10:21:22', b'1'),
	('40287781794eed2001794eee33b30002', '27561260178002021-05-092627676057000timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 10:21:44', 'd:/soufun/file//2021-05-09/348126784020027561260178002021-05-092627676057000timg.jfif', '2021-05-09 10:21:44', b'1'),
	('40287781794eed2001794eee34690003', '34594798610003288325799500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 10:21:44', 'd:/soufun/file//2021-05-09/348146788030034594798610003288325799500timg.jfif', '2021-05-09 10:21:44', b'1'),
	('40287781794f30ff01794f33c4ee0000', '3288325799500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 11:37:43', 'd:/soufun/file//2021-05-09/80404407234003288325799500timg.jfif', '2021-05-09 11:37:43', b'1'),
	('40287781794f3cdc01794f3e722f0000', '80404407234003288325799500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 11:49:23', 'd:/soufun/file//2021-05-09/874015667160080404407234003288325799500timg.jfif', '2021-05-09 11:49:23', b'1'),
	('40287781794f3f9301794f40498c0000', '3288325799500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 11:51:23', 'd:/soufun/file//2021-05-09/88608150371003288325799500timg.jfif', '2021-05-09 11:51:23', b'1'),
	('40287781794f3f9301794f4140b90001', '3438184528800timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 11:52:27', 'd:/soufun/file//2021-05-09/89241155437003438184528800timg.jfif', '2021-05-09 11:52:27', b'1'),
	('40287781794f42d401794f43cb4c0000', '3125742102200timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 11:55:13', 'd:/soufun/file//2021-05-09/90906496890003125742102200timg.jfif', '2021-05-09 11:55:13', b'1'),
	('40287781794f482901794f495c130000', '3288325799500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 12:01:18', 'd:/soufun/file//2021-05-09/94553795117003288325799500timg.jfif', '2021-05-09 12:01:18', b'1'),
	('40287781794f4cd601794ff2dced0000', '80404407234003288325799500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-09 15:06:26', 'd:/soufun/file//2021-05-09/2056395940330080404407234003288325799500timg.jfif', '2021-05-09 15:06:26', b'1'),
	('402877817965798d0179657a40c30000', '80404407234003288325799500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-13 19:26:21', 'd:/soufun/file//2021-05-13/281742069880080404407234003288325799500timg.jfif', '2021-05-13 19:26:21', b'1'),
	('4028778179657b0e0179657bae4f0000', '3288325799500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-13 19:27:54', 'd:/soufun/file//2021-05-13/29110136252003288325799500timg.jfif', '2021-05-13 19:27:54', b'1'),
	('4028778179657f360179658030880000', '80404407234003288325799500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-13 19:32:50', 'd:/soufun/file//2021-05-13/320649648480080404407234003288325799500timg.jfif', '2021-05-13 19:32:50', b'1'),
	('4028778179657f360179658048ea0001', '3125742102200timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-13 19:32:56', 'd:/soufun/file//2021-05-13/32127450247003125742102200timg.jfif', '2021-05-13 19:32:56', b'1'),
	('4028778179657f360179658d6a7b0002', '3288325799500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-13 19:47:17', 'd:/soufun/file//2021-05-13/40733014074003288325799500timg.jfif', '2021-05-13 19:47:17', b'1'),
	('40287781796593940179659430270000', '3125742102200timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-13 19:54:41', 'd:/soufun/file//2021-05-13/45171256076003125742102200timg.jfif', '2021-05-13 19:54:41', b'1'),
	('40287781797446130179744d50d10000', '88608150371003288325799500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-16 16:31:34', 'd:/soufun/file//2021-05-16/403465914500088608150371003288325799500timg.jfif', '2021-05-16 16:31:34', b'1'),
	('4028778179746da3017974774c460000', '3438184528800timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-16 17:17:25', 'd:/soufun/file//2021-05-16/67860038753003438184528800timg.jfif', '2021-05-16 17:17:25', b'1'),
	('40287781797a1efc01797a26cdb80000', '874015667160080404407234003288325799500timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-17 19:47:13', 'd:/soufun/file//2021-05-17/1678023974300874015667160080404407234003288325799500timg.jfif', '2021-05-17 19:47:13', b'1'),
	('40287781797a4f0d01797a5141f30000', '3125742102200timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-17 20:33:36', 'd:/soufun/file//2021-05-17/44602865513003125742102200timg.jfif', '2021-05-17 20:33:36', b'1'),
	('40287781797a521e01797a52a8a30000', '3125742102200timg.jfif', NULL, 'jfif', 'image/jpeg', '2021-05-17 20:35:08', 'd:/soufun/file//2021-05-17/45521093906003125742102200timg.jfif', '2021-05-17 20:35:08', b'1');
/*!40000 ALTER TABLE `upload_file` ENABLE KEYS */;

-- 导出  表 soufun.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户唯一id',
  `name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `email` varchar(32) DEFAULT NULL COMMENT '电子邮箱',
  `phone_number` varchar(15) NOT NULL COMMENT '电话号码',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `status` int(2) unsigned NOT NULL DEFAULT '0' COMMENT '用户状态 0-正常 1-封禁',
  `create_time` datetime NOT NULL COMMENT '用户账号创建时间',
  `last_login_time` datetime NOT NULL COMMENT '上次登录时间',
  `last_update_time` datetime NOT NULL COMMENT '上次更新记录时间',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_on_phone` (`phone_number`) USING BTREE COMMENT '用户手机号',
  UNIQUE KEY `index_on_username` (`name`) USING BTREE COMMENT '用户名索引',
  UNIQUE KEY `index_on_email` (`email`) USING BTREE COMMENT '电子邮箱索引'
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='用户基本信息表';

-- 正在导出表  soufun.user 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `email`, `phone_number`, `password`, `status`, `create_time`, `last_login_time`, `last_update_time`, `avatar`) VALUES
	(1, 'lvhongli', 'lvhongli', '13404034390', '$2a$10$L/BQExYjzkRY6GDwHK6L5e.E8b4VBnmpOhritghvVBsYbbf/LgeT2', 1, '2017-08-25 15:18:20', '2017-08-25 12:00:00', '2017-11-26 10:29:02', 'http://7xo6gy.com1.z0.glb.clouddn.com/99ff568bd61c744bf31185aeddf13580.png'),
	(2, 'admin', 'admin@imooc.com', '1388888888', '$2a$10$L/BQExYjzkRY6GDwHK6L5e.E8b4VBnmpOhritghvVBsYbbf/LgeT2', 1, '2017-08-27 09:07:05', '2017-08-27 09:07:07', '2017-10-21 15:03:57', 'http://7xo6gy.com1.z0.glb.clouddn.com/99ff568bd61c744bf31185aeddf13580.png'),
	(5, '138****8888', NULL, '13888888888', NULL, 0, '2017-11-25 17:56:45', '2017-11-25 17:56:45', '2017-11-25 17:56:45', NULL),
	(8, '151****9677', NULL, '15110059677', NULL, 0, '2017-11-25 18:58:18', '2017-11-25 18:58:18', '2017-11-25 18:58:18', NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
