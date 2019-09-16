-- 分类
CREATE TABLE category (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  name varchar(255) NOT NULL COMMENT '分类名称',
  group_id int(11) NOT NULL COMMENT '组号',
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 子分类
CREATE TABLE sub_category (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  name varchar(255) NOT NULL COMMENT '分类名称',
  category_id int(11) NOT NULL COMMENT '组号',
  PRIMARY KEY (id),
  CONSTRAINT fk_sub_category_category FOREIGN KEY (category_id) REFERENCES category (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- 引用连接
CREATE TABLE referal_link (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  text varchar(255) NOT NULL COMMENT '超链内容',
  link varchar(255) NOT NULL COMMENT '超链地址',
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;



-- 产品
CREATE TABLE product (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  name varchar(255) NOT NULL COMMENT '产品名称',
  sub_title varchar(255) DEFAULT NULL COMMENT '小标题',
  price float DEFAULT NULL COMMENT '价格',
  sale int(11) DEFAULT NULL COMMENT '销量',
  stock int(11) DEFAULT NULL COMMENT '库存',
  category_id int(11) DEFAULT NULL COMMENT '对应的分类id',
  PRIMARY KEY (id),
  CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


-- 筛选情况分类
CREATE TABLE filter_case (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  name varchar(255) DEFAULT NULL COMMENT '属性名称',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 具体的筛选情况
CREATE TABLE concrete_filter (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  filter_case_id int(11) NOT NULL COMMENT '对应筛选条件id',
  value varchar(255) COMMENT '具体的筛选条件',
  PRIMARY KEY (id),
  CONSTRAINT fk_concrete_filter_filter_case FOREIGN KEY (filter_case_id) REFERENCES filter_case (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE product_bind_filter (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  product_id int(11) NOT NULL COMMENT '对应产品id',
  filter_value_id int(11) NOT NULL COMMENT '对应筛选情况id',
  PRIMARY KEY (id),
  CONSTRAINT fk_product_bind__filter_concrete_filter FOREIGN KEY (filter_value_id) REFERENCES concrete_filter (id),
  CONSTRAINT fk_product_bind__filter_product FOREIGN KEY (product_id) REFERENCES product (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;





CREATE TABLE property (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  name varchar(255) DEFAULT NULL COMMENT '属性名称',
  category_id int(11) NOT NULL COMMENT '对应的分类id',
  PRIMARY KEY (id),
  CONSTRAINT fk_property_category FOREIGN KEY (category_id) REFERENCES category(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE concrete_property (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  product_id int(11) NOT NULL COMMENT '对应产品id',
  properti_id int(11) NOT NULL COMMENT '对应属性id',
  value varchar(255) DEFAULT NULL COMMENT '具体的属性值',
  PRIMARY KEY (id),
  CONSTRAINT fk_concrete_property_property FOREIGN KEY (properti_id) REFERENCES property (id),
  CONSTRAINT fk_concrete_property_product FOREIGN KEY (product_id) REFERENCES product (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE product_image (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  product_id int(11) NOT NULL COMMENT '对应的产品id',
  image_link varchar(255) NOT NULL COMMENT '图片存储链接',
  PRIMARY KEY (id),
  CONSTRAINT fk_product_image_product FOREIGN KEY (product_id) REFERENCES product (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  name varchar(255) DEFAULT '用户' COMMENT '用户名称',
  phone varchar(255) NOT NULL COMMENT '用户号码',
  email varchar(255) COMMENT '用户邮箱',
  password varchar(255) NOT NULL COMMENT '用户密码',
  birthday datetime DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (id),
  UNIQUE (phone),
  UNIQUE (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE review (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  content varchar(4000) DEFAULT NULL COMMENT '评价内容',
  user_id int(11) NOT NULL COMMENT '对应的用户id',
  product_id int(11) NOT NULL COMMENT '对应的产品id',
  createDate datetime DEFAULT NULL COMMENT '评价时间',
  PRIMARY KEY (id),
  CONSTRAINT fk_review_product FOREIGN KEY (product_id) REFERENCES product (id),
  CONSTRAINT fk_review_user FOREIGN KEY (user_id) REFERENCES user (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

 

CREATE TABLE address (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  receiver varchar(255) NOT NULL COMMENT '收货人',
  mobile varchar(11) NOT NULL COMMENT '用户号码',
  province varchar(255) NOT NULL COMMENT '所在省份',
  prefecture varchar(255) COMMENT '所在地级市',
  county varchar(255) COMMENT '所在县级市',
  address varchar(255) COMMENT '详细地址',
  user_id int(11) NOT NULL COMMENT '对应的用户',
  default_address int(1) DEFAULT 0 COMMENT '是否是默认地址',
  PRIMARY KEY (id)
)

CREATE TABLE order_ (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  order_code varchar(255) NOT NULL UNIQUE COMMENT '订单号',
  address_id int(11) DEFAULT NULL COMMENT '收货地址id',
  user_message varchar(255) DEFAULT NULL COMMENT '用户备注的信息',
  create_date datetime NOT NULL COMMENT '订单创建时间',
  pay_date datetime DEFAULT NULL COMMENT '订单支付时间',
  delivery_date datetime DEFAULT NULL COMMENT '发货日期',
  confirm_date datetime DEFAULT NULL COMMENT '确认收货日期',
  user_id int(11) NOT NULL COMMENT '对应的用户id',
  actual_payment float COMMENT '订单实付款',
  status varchar(255) NOT NULL COMMENT '订单状态',
  PRIMARY KEY (id),
  CONSTRAINT fk_order_address FOREIGN KEY (address_id) REFERENCES address (id),
  CONSTRAINT fk_order_user FOREIGN KEY (user_id) REFERENCES user (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;




-- 购物车内的产品项
CREATE TABLE product_item(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  product_id int(11) NOT NULL COMMENT '对应的产品id',
  quality int(11) DEFAULT 1 COMMENT '商品数量',
  user_id int(11) NOT NULL COMMENT '购物车内商品的所有者',
  PRIMARY KEY(id),
  CONSTRAINT fl_shopping_cart_product FOREIGN KEY (product_id) REFERENCES product (id),
  CONSTRAINT fl_shopping_cart_user FOREIGN KEY (user_id) REFERENCES user (id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;



-- 订单内的产品项
CREATE TABLE order_item (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  order_code varchar(255) NOT NULL COMMENT '订单号',
  product_item_id int(11) NOT NULL COMMENT '购物车内产品项id',
  PRIMARY KEY(id),
  CONSTRAINT fk_order_item_order FOREIGN KEY (order_code) REFERENCES order_(order_code),
  CONSTRAINT fk_order_item_product_item FOREIGN KEY (product_item_id) REFERENCES product_item(id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
