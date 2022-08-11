DROP
DATABASE IF EXISTS `sharding_01`;
CREATE
DATABASE sharding_01 DEFAULT CHARSET=utf8mb4;
use
sharding_01;
-- ----------------------------
-- Table structure for t_user_01
-- ----------------------------
DROP TABLE IF EXISTS `t_user_01`;
CREATE TABLE `t_user_01`
(
    `id`   bigint(20) NOT NULL COMMENT '主键',
    `name` varchar(32) NOT NULL COMMENT '姓名',
    `age`  int(11) NOT NULL COMMENT '年龄',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_user_02
-- ----------------------------
DROP TABLE IF EXISTS `t_user_02`;
CREATE TABLE `t_user_02`
(
    `id`   bigint(20) NOT NULL COMMENT '主键',
    `name` varchar(32) NOT NULL COMMENT '姓名',
    `age`  int(11) NOT NULL COMMENT '年龄',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP
DATABASE IF EXISTS `sharding_02`;
CREATE
DATABASE sharding_02 DEFAULT CHARSET=utf8mb4;
use
sharding_02;
-- ----------------------------
-- Table structure for t_user_01
-- ----------------------------
DROP TABLE IF EXISTS `t_user_01`;
CREATE TABLE `t_user_01`
(
    `id`   bigint(20) NOT NULL COMMENT '主键',
    `name` varchar(32) NOT NULL COMMENT '姓名',
    `age`  int(11) NOT NULL COMMENT '年龄',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_user_02
-- ----------------------------
DROP TABLE IF EXISTS `t_user_02`;
CREATE TABLE `t_user_02`
(
    `id`   bigint(20) NOT NULL COMMENT '主键',
    `name` varchar(32) NOT NULL COMMENT '姓名',
    `age`  int(11) NOT NULL COMMENT '年龄',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;