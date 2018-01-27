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

 Date: 09/01/2018 14:02:24
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
INSERT INTO `rechargeable_card` VALUES ('2222222222', '222222', 10, 1);

-- ----------------------------
-- Table structure for sms_history
-- ----------------------------
DROP TABLE IF EXISTS `sms_history`;
CREATE TABLE `sms_history`  (
  `senderID` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发件人手机号',
  `receiverID` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收件人手机号',
  `sendTime` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '发件时间',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短信内容'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sms_history
-- ----------------------------
INSERT INTO `sms_history` VALUES ('11111111111', '22222222222', '2018-01-08 00:00:00.000000', '1111111111111111111111');
INSERT INTO `sms_history` VALUES ('11111111111', '22222222222', '2018-01-08 00:00:00.000000', '1111111111111111111111');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-08 00:00:00.000000', '我试试');
INSERT INTO `sms_history` VALUES ('22222222222', '11111111111', '2018-01-08 00:00:00.000000', '11111打  二个如花');
INSERT INTO `sms_history` VALUES ('22222222222', '11111111111', '2018-01-08 00:00:00.000000', '和我家看吧你看帅哥你了孙哥');
INSERT INTO `sms_history` VALUES ('22222222222', '11111111111', '2018-01-08 00:00:00.000000', '十大股东看来你你看见儿童动画他已经可以吧');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-08 00:00:00.000000', '学生身上事实上事实上身上试试');
INSERT INTO `sms_history` VALUES ('11111111111', '22222222222', '2018-01-08 00:00:00.000000', '学生身上事实上事实上身上试试');
INSERT INTO `sms_history` VALUES ('22222222222', '11111111111', '2018-01-08 00:00:00.000000', '111111');
INSERT INTO `sms_history` VALUES ('11111111111', '22222222222', '2018-01-08 00:00:00.000000', '22222222222');
INSERT INTO `sms_history` VALUES ('22222222222', '11111111111', '2018-01-08 00:00:00.000000', '2222222222');
INSERT INTO `sms_history` VALUES ('22222222222', '11111111111', '2018-01-08 00:00:00.000000', '为反复反复反复');
INSERT INTO `sms_history` VALUES ('22222222222', '11111111111', '2018-01-08 00:00:00.000000', '为反复反复反复');
INSERT INTO `sms_history` VALUES ('22222222222', '11111111111', '2018-01-08 00:00:00.000000', '快快快快快快');
INSERT INTO `sms_history` VALUES ('22222222222', '11111111111', '2018-01-08 00:00:00.000000', '快快快快快快');
INSERT INTO `sms_history` VALUES ('22222222222', '11111111111', '2018-01-08 00:00:00.000000', '快快快快快快');
INSERT INTO `sms_history` VALUES ('22222222222', '22222222222', '2018-01-08 00:00:00.000000', '快快快快快快');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 10:05:33.000000', '1  第三个给自己');
INSERT INTO `sms_history` VALUES ('11111111111', '22222222222', '2018-01-09 10:16:03.000000', '速度');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 10:25:16.000000', '111 是地方规划');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 10:25:27.000000', '111 是地方规划少废话虽然说');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 10:31:57.000000', '发改委专家');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 10:31:58.000000', '发改委专家');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 10:31:59.000000', '发改委专家');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 10:32:00.000000', '发改委专家');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 10:32:23.000000', '发给自己');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:07:45.000000', '1收到回复悲剧健康就是的可能');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:07:50.000000', '1收到回复悲剧健康就是的可能');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:07:54.000000', '1收到回复悲剧健康就是的可能');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:07:55.000000', '1收到回复悲剧健康就是的可能');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:11:49.000000', '1收到回复悲剧健康就是的可能');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:17:05.000000', '1收到回复悲剧健康就是的可能');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:17:15.000000', '1收到回复悲剧健康就是的可能');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:17:16.000000', '1收到回复悲剧健康就是的可能');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:17:17.000000', '1收到回复悲剧健康就是的可能');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:17:18.000000', '1收到回复悲剧健康就是的可能');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:20:11.000000', '1收到回复悲剧健康就是的可能');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:20:42.000000', '1收到回复悲剧健康就是的可能');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:22:35.000000', '是干什么女看了吗 登录；肯瑞托， 备份就');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:23:40.000000', '是干什么女看了吗 登录；肯瑞托， 备份就');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:35:58.000000', '是干什么女看了吗 登录；肯瑞托， 备份就');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:37:26.000000', '是干什么女看了吗 登录；肯瑞托， 备份就');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:37:27.000000', '是干什么女看了吗 登录；肯瑞托， 备份就');
INSERT INTO `sms_history` VALUES ('11111111111', '11111111111', '2018-01-09 11:37:30.000000', '是干什么女看了吗 登录；肯瑞托， 备份就');
INSERT INTO `sms_history` VALUES ('11111111111', '22222222222', '2018-01-09 13:32:27.000000', '111114跳舞');

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
  `charge` float(10, 0) NOT NULL COMMENT '交易金额',
  `tradingTime` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '交易时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易备注'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transaction_record
-- ----------------------------
INSERT INTO `transaction_record` VALUES ('11111111111', '003', 100, '2018-01-08 00:00:00.000000', '账号充值100.0元');
INSERT INTO `transaction_record` VALUES ('11111111111', '003', 100, '2018-01-08 00:00:00.000000', '账号充值100.0元');
INSERT INTO `transaction_record` VALUES ('11111111111', '001', 0, '2018-01-08 00:00:00.000000', 'SP服务001消费0.1元');
INSERT INTO `transaction_record` VALUES ('22222222222', '001', 0, '2018-01-08 00:00:00.000000', 'SP服务001消费0.1元');
INSERT INTO `transaction_record` VALUES ('22222222222', '001', 0, '2018-01-08 00:00:00.000000', 'SP服务001消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '002', 0, '2018-01-08 00:00:00.000000', 'SP服务002消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '001', 0, '2018-01-08 00:00:00.000000', 'SP服务001消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '001', 0, '2018-01-09 00:00:00.000000', 'SP服务001消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '001', 0, '2018-01-09 00:00:00.000000', 'SP服务001消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '001', 0, '2018-01-09 00:00:00.000000', 'SP服务001消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 11:35:58.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 11:35:58.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 11:37:26.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 11:37:26.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 11:37:28.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 11:37:28.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 11:37:30.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 11:37:30.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 13:32:27.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 13:32:27.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 13:37:58.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 13:37:58.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 13:40:50.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 13:40:50.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 13:40:52.000000', 'SP服务000消费0.1元');
INSERT INTO `transaction_record` VALUES ('11111111111', '000', 0, '2018-01-09 13:40:53.000000', 'SP服务000消费0.1元');

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
INSERT INTO `user` VALUES ('11111111111', '0.0.0.0', 0, 0, 192.00, 1, '111111');
INSERT INTO `user` VALUES ('22222222222', '0.0.0.0', 0, 0, 0.80, 1, '111111');
INSERT INTO `user` VALUES ('33333333333', '0.0.0.0', 0, 0, 1.00, 1, '111111');
INSERT INTO `user` VALUES ('44444444444', '0.0.0.0', 0, 0, 1.00, 1, '111111');

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
