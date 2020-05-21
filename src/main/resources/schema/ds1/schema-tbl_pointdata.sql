CREATE TABLE IF NOT EXISTS `tbl_pointdata_01` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分布式主键',
  `data` double DEFAULT NULL COMMENT '数据',
  `date` datetime DEFAULT NULL COMMENT '日期',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `maxData` double DEFAULT NULL COMMENT '最小值',
  `minData` double DEFAULT NULL COMMENT '最大值',
  `pointId` int(11) DEFAULT NULL COMMENT '点id',
  `pointepc` varchar(20) DEFAULT NULL COMMENT 'epc地址',
  `region` varchar(20) DEFAULT NULL COMMENT '区域',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `pointId` (`date`,`pointId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;