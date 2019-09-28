DROP TABLE IF EXISTS `administrative_area`;
CREATE TABLE `administrative_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `code` varchar(6) NOT NULL COMMENT '区码',
  `name` varchar(15) NOT NULL COMMENT '名称',
  `parent_id` varchar(6) NOT NULL COMMENT '辖区区码',
  `short_name` varchar(8) NOT NULL COMMENT '名称',
  `level_type` int(1) NOT NULL COMMENT '行政登记',
  `city_code` varchar(5) DEFAULT NULL COMMENT '城市码',
  `zip_code` varchar(6) DEFAULT NULL COMMENT '邮编',
  `merge_name` varchar(30) NOT NULL COMMENT '全称',
  `ing` varchar(11) NOT NULL COMMENT '经度',
  `lat` varchar(9) NOT NULL COMMENT '纬度',
  `pinyin` varchar(28) NOT NULL COMMENT '拼音名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1708 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `receiver` varchar(255) NOT NULL COMMENT '收货人',
  `mobile` varchar(11) NOT NULL COMMENT '用户号码',
  `province` varchar(255) NOT NULL COMMENT '所在省份',
  `prefecture` varchar(255) DEFAULT NULL COMMENT '所在地级市',
  `county` varchar(255) DEFAULT NULL COMMENT '所在县级市',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `user_id` int(11) NOT NULL COMMENT '对应的用户',
  `default_address` int(1) DEFAULT '0' COMMENT '是否是默认地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


-- 筛选情况分类
DROP TABLE IF EXISTS `label_category`;
CREATE TABLE `label_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `name` varchar(255) DEFAULT NULL COMMENT '属性名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 具体的筛选情况 引用filter_case
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `label_category_id` int(11) NOT NULL COMMENT '对应筛选条件id',
  `value` varchar(255) DEFAULT NULL COMMENT '具体的筛选条件',
  PRIMARY KEY (`id`),
  KEY `fk_label_label_category` (`label_category_id`) USING BTREE,
  CONSTRAINT `fk_label_lable_category` FOREIGN KEY (`label_category_id`) REFERENCES `label_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- 分类
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  `group_id` int(11) NOT NULL COMMENT '组号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;


-- 子分类  引用category
DROP TABLE IF EXISTS `sub_category`;
CREATE TABLE `sub_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  `category_id` int(11) NOT NULL COMMENT '组号',
  PRIMARY KEY (`id`),
  KEY `fk_sub_category_category` (`category_id`),
  CONSTRAINT `fk_sub_category_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=520 DEFAULT CHARSET=utf8;

-- 属性 引用category
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `name` varchar(255) DEFAULT NULL COMMENT '属性名称',
  `category_id` int(11) NOT NULL COMMENT '对应的分类id',
  PRIMARY KEY (`id`),
  KEY `fk_property_category` (`category_id`),
  CONSTRAINT `fk_property_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 产品  引用category
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  `name` varchar(255) NOT NULL COMMENT '产品名称',
  `sub_title` varchar(255) DEFAULT NULL COMMENT '小标题',
  `price` float DEFAULT NULL COMMENT '价格',
  `sale` int(11) DEFAULT NULL COMMENT '销量',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `category_id` int(11) DEFAULT NULL COMMENT '对应的分类id',
  `undercarriage` int(11) DEFAULT '0' COMMENT '是否下架，1下架',
  PRIMARY KEY (`id`),
  KEY `fk_product_category` (`category_id`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;


-- 属性值  引用produt property
DROP TABLE IF EXISTS `concrete_property`;
CREATE TABLE `concrete_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `product_id` int(11) NOT NULL COMMENT '对应产品id',
  `properti_id` int(11) NOT NULL COMMENT '对应属性id',
  `value` varchar(255) DEFAULT NULL COMMENT '具体的属性值',
  PRIMARY KEY (`id`),
  KEY `fk_concrete_property_property` (`properti_id`),
  KEY `fk_concrete_property_product` (`product_id`),
  CONSTRAINT `fk_concrete_property_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_concrete_property_property` FOREIGN KEY (`properti_id`) REFERENCES `property` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 产品图片 引用product
DROP TABLE IF EXISTS `product_image`;
CREATE TABLE `product_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `product_id` int(11) NOT NULL COMMENT '对应的产品id',
  `image_link` varchar(255) NOT NULL COMMENT '图片存储链接',
  PRIMARY KEY (`id`),
  KEY `fk_product_image_product` (`product_id`),
  CONSTRAINT `fk_product_image_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;


-- 绑定产品和筛选条件之间的关系 引用product  concrete_filter
DROP TABLE IF EXISTS `product_bind_label`;
CREATE TABLE `product_bind_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `product_id` int(11) NOT NULL COMMENT '对应产品id',
  `label_id` int(11) NOT NULL COMMENT '对应筛选情况id',
  PRIMARY KEY (`id`),
  KEY `fk_product_bind__label_label` (`label_id`) USING BTREE,
  KEY `fk_product_bind__label_product` (`product_id`) USING BTREE,
  CONSTRAINT `fk_product_bind__label_lable` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`),
  CONSTRAINT `fk_product_bind__label_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8;

-- 用户
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `name` varchar(255) DEFAULT '用户' COMMENT '用户名称',
  `phone` varchar(255) NOT NULL COMMENT '用户号码',
  `email` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `image` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


-- 购物车内的产品项  引用用户
DROP TABLE IF EXISTS `product_item`;
CREATE TABLE `product_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `product_id` int(11) NOT NULL COMMENT '对应的产品id',
  `quality` int(11) DEFAULT '1' COMMENT '商品数量',
  `user_id` int(11) NOT NULL COMMENT '购物车内商品的所有者',
  PRIMARY KEY (`id`),
  KEY `fk_product_item_product` (`product_id`),
  KEY `fk_product_item_user` (`user_id`),
  CONSTRAINT `fk_product_item_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_product_item_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;


-- 订单  引用 user
DROP TABLE IF EXISTS `order_`;
CREATE TABLE `order_` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `order_code` varchar(255) NOT NULL COMMENT '订单号',
  `complete_address` varchar(255) DEFAULT NULL COMMENT '完整的地址',
  `mobile` varchar(11) DEFAULT NULL COMMENT '用户电话号码',
  `receiver` varchar(255) DEFAULT NULL COMMENT '收货人',
  `user_message` varchar(255) DEFAULT NULL COMMENT '用户备注的信息',
  `create_date` datetime DEFAULT NULL COMMENT '订单创建时间',
  `pay_date` datetime DEFAULT NULL COMMENT '订单支付时间',
  `delivery_date` datetime DEFAULT NULL COMMENT '发货日期',
  `confirm_date` datetime DEFAULT NULL COMMENT '确认收货日期',
  `user_id` int(11) NOT NULL COMMENT '对应的用户id',
  `actual_payment` float DEFAULT NULL COMMENT '订单实付款',
  `status` varchar(255) NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_code` (`order_code`),
  KEY `fk_order_user` (`user_id`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 订单内的产品项   引用order product
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `order_code` varchar(255) NOT NULL COMMENT '订单号',
  `product_id` int(11) NOT NULL COMMENT '对应的产品id',
  `quality` int(11) DEFAULT '1' COMMENT '商品数量',
  PRIMARY KEY (`id`),
  KEY `fk_order_item_product` (`product_id`),
  KEY `fk_order_item_order` (`order_code`),
  CONSTRAINT `fk_order_item_order` FOREIGN KEY (`order_code`) REFERENCES `order_` (`order_code`),
  CONSTRAINT `fk_order_item_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `username` varchar(30) NOT NULL COMMENT '管理员账号',
  `password` varchar(30) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 引用链接
DROP TABLE IF EXISTS `scroll_ad`;
CREATE TABLE `scroll_ad` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  `text` varchar(255) NOT NULL COMMENT '超链内容',
  `link` varchar(255) NOT NULL COMMENT '超链地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;





DROP TABLE IF EXISTS `collection`;
CREATE TABLE `scroll_ad` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  `text` varchar(255) NOT NULL COMMENT '超链内容',
  `link` varchar(255) NOT NULL COMMENT '超链地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;



-- CREATE TABLE review (
--   id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
--   content varchar(4000) DEFAULT NULL COMMENT '评价内容',
--   user_id int(11) NOT NULL COMMENT '对应的用户id',
--   product_id int(11) NOT NULL COMMENT '对应的产品id',
--   createDate datetime DEFAULT NULL COMMENT '评价时间',
--   PRIMARY KEY (id),
--   CONSTRAINT fk_review_product FOREIGN KEY (product_id) REFERENCES product (id),
--   CONSTRAINT fk_review_user FOREIGN KEY (user_id) REFERENCES user (id)
-- ) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

 




