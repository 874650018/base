CREATE TABLE demo(
	id bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	name varchar(64)  NULL COMMENT '名称',
	number int  NULL COMMENT '个数',
 insert_time datetime  NULL COMMENT '创建时间',
 PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='demo';
