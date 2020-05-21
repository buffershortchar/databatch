DROP TABLE IF EXISTS `TEST`;
CREATE TABLE `TEST` (
  `id` bigint(10) NOT NULL COMMENT 'ID',
  `field1` varchar(10) NOT NULL COMMENT '字段一',
  `field2` varchar(10) NOT NULL COMMENT '字段二',
  `field3` varchar(10) NOT NULL COMMENT '字段三',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
