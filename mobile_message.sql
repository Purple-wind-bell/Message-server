/*
 Navicat MySQL Data Transfer

 Source Server         : java_mysql
 Source Server Type    : MySQL
 Source Server Version : 100302
 Source Host           : localhost:3306
 Source Schema         : mobile_message

 Target Server Type    : MySQL
 Target Server Version : 100302
 File Encoding         : 65001

 Date: 08/01/2018 15:31:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rechargeable_card
-- ----------------------------
DROP TABLE IF EXISTS `rechargeable_card`;
CREATE TABLE `rechargeable_card`  (
  `cardID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充值卡卡号',
  `password` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充值卡密码',
  `denomination` float(6, 0) NOT NULL COMMENT '面额',
  `usable` tinyint(2) NOT NULL COMMENT '充值卡是否可用',
  PRIMARY KEY (`cardID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rechargeable_card
-- ----------------------------
INSERT INTO `rechargeable_card` VALUES ('1111111111', '111111', 100, 1);

-- ----------------------------
-- Table structure for sms_history
-- ----------------------------
DROP TABLE IF EXISTS `sms_history`;
CREATE TABLE `sms_history`  (
  `senderID` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发件人手机号',
  `receiverID` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收件人手机号',
  `sendTime` datetime(6) NOT NULL COMMENT '发件时间',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短信内容'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sp_service
-- ----------------------------
DROP TABLE IF EXISTS `sp_service`;
CREATE TABLE `sp_service`  (
  `ID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'SP服务id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'SP服务名称',
  `charge` float(10, 1) NOT NULL COMMENT 'SP服务费',
  `avaiable` tinyint(2) NOT NULL COMMENT 'SP服务是否可用',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sp_service
-- ----------------------------
INSERT INTO `sp_service` VALUES ('000', 'DX', 0.1, 1);
INSERT INTO `sp_service` VALUES ('001', 'YE', 0.1, 1);
INSERT INTO `sp_service` VALUES ('002', 'TQ', 0.1, 1);
INSERT INTO `sp_service` VALUES ('003', 'CZ', 0.1, 1);
INSERT INTO `sp_service` VALUES ('004', 'CX', 0.1, 1);

-- ----------------------------
-- Table structure for transaction_record
-- ----------------------------
DROP TABLE IF EXISTS `transaction_record`;
CREATE TABLE `transaction_record`  (
  `userID` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易用户手机号',
  `spID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'SP服务id',
  `charge` float(10, 0) NOT NULL COMMENT '服务费',
  `tradingTime` datetime(6) NOT NULL COMMENT '交易时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易备注'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userID` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `userIP` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户注册ip',
  `onlineStatus` tinyint(2) NOT NULL COMMENT '在线状态',
  `frozenStatus` tinyint(2) NOT NULL COMMENT '手机是否冻结',
  `balance` float(20, 2) NOT NULL COMMENT '余额',
  `openSP` tinyint(2) NOT NULL COMMENT '是否开通SP服务',
  `password` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`userID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('11111111111', '127.0.0.1', 1, 0, -2.00, 1, '111111');
INSERT INTO `user` VALUES ('22222222222', '192.168.3.30', 1, 0, 1.00, 1, '111111');
INSERT INTO `user` VALUES ('33333333333', '0.0.0.0', 0, 0, 1.00, 1, '111111');

-- ----------------------------
-- Table structure for weather
-- ----------------------------
DROP TABLE IF EXISTS `weather`;
CREATE TABLE `weather`  (
  `cityID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市id',
  `cityName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市名',
  `date` date NOT NULL COMMENT '日期',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '天气状态',
  PRIMARY KEY (`cityID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weather
-- ----------------------------
INSERT INTO `weather` VALUES ('0', '南京', '2018-01-05', '晴');
INSERT INTO `weather` VALUES ('1', '11', '2018-01-17', '解决');
INSERT INTO `weather` VALUES ('2', '112123', '2018-01-17', '123412');

SET FOREIGN_KEY_CHECKS = 1;
