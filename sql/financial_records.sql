/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : newshop

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 22/05/2024 23:10:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for financial_records
-- ----------------------------
DROP TABLE IF EXISTS `financial_records`;
CREATE TABLE `financial_records`  (
  `ID` bigint(255) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `settlement_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '结算日期',
  `date` datetime NULL DEFAULT NULL COMMENT '日期',
  `order_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单号',
  `product_name_details` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品名称_详细信息',
  `amount` decimal(65, 2) NULL DEFAULT NULL COMMENT '账款',
  `is_completed` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否完成',
  `income_expense` varchar(65) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '支出收入',
  `payment_item` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '付款项目',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `brand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品牌方',
  `supplier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出货方',
  `handler` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处理人',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of financial_records
-- ----------------------------
INSERT INTO `financial_records` VALUES (1, '2023年4月', '2024-01-09 00:00:00', '123456', '代刷', 600.00, '', '', '', '', '欧', '', '刘备');
INSERT INTO `financial_records` VALUES (4, '', NULL, '', '', NULL, '', '', '', '', '', '', '');
INSERT INTO `financial_records` VALUES (5, '', '2024-01-14 10:29:36', '', '', NULL, '', '', '', '', '', '', '');

SET FOREIGN_KEY_CHECKS = 1;
